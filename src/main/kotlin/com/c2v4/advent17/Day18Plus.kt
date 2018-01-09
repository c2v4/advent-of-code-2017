package com.c2v4.advent17

fun duet2(input: String): Int = input.split('\n').map { it.trim() }.filter { it.isNotEmpty() }.map {
    toInstructionP(it)
}.let {
    State18P(it, registers = mapOf('p' to 0L)) to State18P(it, registers = mapOf('p' to 1L))
}.let {
    var (first, second) = it
    var sent = 0
    while ((first.waiting == null || second.waiting == null) && !first.outOfBounds() && !second.outOfBounds()) {
        first = first.next()
        second = second.next()
        if (first.waiting != null && second.sending.isNotEmpty()) {
            first = first.receiveValue(second.sending.first())
            second = second.copy(sending = second.sending.drop(1))
            sent++
        }
        if (second.waiting != null && first.sending.isNotEmpty()) {
            second = second.receiveValue(first.sending.first())
            first = first.copy(sending = first.sending.drop(1))
        }

    }
    sent + second.sending.size
}

fun toInstructionP(input: String): Instruction18P = input.split(Regex("\\s")).let {
    Instruction18P(Instruction18P.Command.valueOf(it[0].toUpperCase()),
        it[1],
        if (it.size > 2) it[2] else "")
}

data class Instruction18P(private val command: Command, val arg1: String, val arg2: String = "") {
    enum class Command(val action: ((state: State18P, arg1: String, arg2: String) -> State18P)) {
        SND({ state, arg1, _ ->
            state.copy(pointer = state.pointer+1, sending = state.sending.plus(getValue(state, arg1)))
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
            state.copy(waiting = arg1.first())
        }),
        JGZ({ state, arg1, arg2 ->
            if (getValue(state, arg1) > 0) state.copy(pointer = state.pointer + getValue(state,
                arg2).toInt())
            else state.copy(pointer = state.pointer + 1)
        })
    }

    fun apply(state: State18P): State18P = command.action.invoke(state, arg1, arg2)
}

data class State18P(private val instructions: List<Instruction18P>,
                    val pointer: Int = 0,
                    val registers: Map<Char, Long> = emptyMap(),
                    val finished: Boolean = false,
                    val waiting: Char? = null,
                    val sending: List<Long> = emptyList()) {
    fun next(): State18P = instructions[pointer].apply(this)
    fun outOfBounds(): Boolean = pointer >= instructions.size
    fun receiveValue(value: Long): State18P =
        if (waiting == null) throw IllegalStateException()
        else copy(pointer = pointer + 1, registers = registers.plus(waiting to value), waiting = null)
}

fun getValue(state: State18P,
             argument: String): Long = if (argument.matches(Regex("\\D"))) state.registers.getOrDefault(
    argument.first(),
    0) else argument.toLong()


fun main(args: Array<String>) {
    print(duet2("day18.txt".asResource().trim()))
}
