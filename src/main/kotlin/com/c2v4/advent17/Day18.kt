package com.c2v4.advent17

fun duet(input: String): Long = input.split('\n').map { it.trim() }.filter { it.isNotEmpty() }.map {
    toInstruction(it)
}.let {
    State18(it)
}.let {
    var state = it
    while (!state.finished) {
        state = state.next()
    }
    state.lastPlayed
}

fun toInstruction(input: String): Instruction18 = input.split(Regex("\\s")).let {
    Instruction18(Instruction18.Command.valueOf(it[0].toUpperCase()),
        it[1],
        if (it.size > 2) it[2] else "")
}

data class Instruction18(private val command: Command, val arg1: String, val arg2: String = "") {
    enum class Command(val action: ((state: State18, arg1: String, arg2: String) -> State18)) {
        SND({ state, arg1, _ ->
            state.copy(pointer = state.pointer + 1,
                lastPlayed = getValue(state, arg1))
        }),
        SET({ state, arg1, arg2 ->
            state.copy(pointer = state.pointer + 1,
                registers = state.registers.plus(arg1.first() to getValue(state, arg2)))
        }),
        ADD({ state, arg1, arg2 ->
            state.copy(pointer = state.pointer + 1,
                registers = state.registers.plus(arg1.first() to
                    getValue(state, arg2) + state.registers.getOrDefault(arg1.first(), 0)))
        }),
        MUL({ state, arg1, arg2 ->
            state.copy(pointer = state.pointer + 1,
                registers = state.registers.plus(arg1.first() to
                    getValue(state, arg2) * state.registers.getOrDefault(arg1.first(), 0)))
        }),
        MOD({ state, arg1, arg2 ->
            state.copy(pointer = state.pointer + 1,
                registers = state.registers.plus(arg1.first() to
                    state.registers.getOrDefault(arg1.first(), 0) % getValue(state, arg2)))
        }),
        RCV({ state, arg1, _ ->
            if (getValue(state,
                arg1) == 0L) state.copy(pointer = state.pointer + 1) else state.copy(
                finished = true)
        }),
        JGZ({ state, arg1, arg2 ->
            if (getValue(state, arg1) > 0) state.copy(pointer = state.pointer + getValue(state,
                arg2).toInt())
            else state.copy(pointer = state.pointer + 1)
        })
    }

    fun apply(state: State18): State18 = command.action.invoke(state, arg1, arg2)
}

data class State18(private val instructions: List<Instruction18>,
                   val pointer: Int = 0,
                   val lastPlayed: Long = 0,
                   val registers: Map<Char, Long> = emptyMap(),
                   val finished: Boolean = false) {
    fun next(): State18 = instructions[pointer].apply(this)
}

fun getValue(state: State18,
             argument: String): Long = if (argument.matches(Regex("\\D"))) state.registers.getOrDefault(
    argument.first(),
    0) else argument.toLong()

fun main(args: Array<String>) {
    print(duet("day18.txt".asResource().trim()))
}
