package com.c2v4.advent17

fun cocpu(input: String): Int = input.split('\n').map { it.trim() }.filter { it.isNotEmpty() }.map {
    toInstruction23(it)
}.let {
    State23(it)
}.let {
    var state = it
    while (state.pointer<state.instructions.size) {
        state = state.next()
    }
    state.timesMul
}

fun toInstruction23(input: String): Instruction23 = input.split(Regex("\\s")).let {
    Instruction23(Instruction23.Command.valueOf(it[0].toUpperCase()),
        it[1],
        if (it.size > 2) it[2] else "")
}

data class Instruction23(private val command: Command, val arg1: String, val arg2: String = "") {
    enum class Command(val action: ((state: State23, arg1: String, arg2: String) -> State23)) {
        SET({ state, arg1, arg2 ->
            state.copy(pointer = state.pointer + 1,
                registers = state.registers.plus(arg1.first() to getValue(state, arg2)))
        }),
        SUB({ state, arg1, arg2 ->
            state.copy(pointer = state.pointer + 1,
                registers = state.registers.plus(arg1.first() to
                    state.registers.getOrDefault(arg1.first(), 0) - getValue(state, arg2)))
        }),
        MUL({ state, arg1, arg2 ->
            state.copy(pointer = state.pointer + 1,
                registers = state.registers.plus(arg1.first() to
                    getValue(state, arg2) * state.registers.getOrDefault(arg1.first(), 0)),timesMul = state.timesMul+1)
        }),
        JNZ({ state, arg1, arg2 ->
            if (getValue(state, arg1) != 0L) state.copy(pointer = state.pointer + getValue(state,
                arg2).toInt())
            else state.copy(pointer = state.pointer + 1)
        })
    }

    fun apply(state: State23): State23 = command.action.invoke(state, arg1, arg2)
}

data class State23(val instructions: List<Instruction23>,
                   val pointer: Int = 0,
                   val registers: Map<Char, Long> = emptyMap(),
                   val timesMul:Int=0) {
    fun next(): State23 = instructions[pointer].apply(this)
}

fun getValue(state: State23,
             argument: String): Long = if (argument.matches(Regex("\\D"))) state.registers.getOrDefault(
    argument.first(),
    0) else argument.toLong()

fun main(args: Array<String>) {
    print(cocpu("day23.txt".asResource().trim()))
}
