package com.c2v4.advent17

fun cpu(input: String): Int =
        input
                .split("\n").map { it.trim() }.map { it.split(" ") }.map {
            Instruction(it[0],
                    Operation.from(it[1]),
                    it[2].toInt(),
                    Predicate(it[4], it[6].toInt(), Condition.from(it[5])))
        }
                .fold(emptyMap<String, Int>(), { acc, instruction -> instruction.run(acc) })
                .maxBy { it.value }
                ?.value ?: 0

data class Instruction(val register: String,
                       val operation: Operation,
                       val value: Int,
                       val predicate: Predicate)

fun Instruction.run(registers: Map<String, Int>): Map<String, Int> {
    if (predicate.test(registers)) {
        return registers.plus(register to operation.invoke(registers.getOrDefault(register, 0),
                value))
    }
    return registers
}

data class Predicate(val register: String, val value: Int, val condition: Condition)

fun Predicate.test(registers: Map<String, Int>): Boolean {
    return condition.invoke(registers.getOrDefault(register, 0), value)
}

enum class Condition(private val function: (a: Int, b: Int) -> Boolean) {
    GREATER({ a, b -> a > b }),
    GREATER_OR_EQUAL({ a, b -> a >= b }),
    LESS({ a, b -> a < b }),
    LESS_OR_EQUAL({ a, b -> a <= b }),
    EQUAL({ a, b -> (a == b) }),
    NOT_EQUAL({ a, b -> a != b });

    companion object {
        fun from(input: String): Condition {
            return when (input) {
                ">" -> GREATER
                ">=" -> GREATER_OR_EQUAL
                "<" -> LESS
                "<=" -> LESS_OR_EQUAL
                "==" -> EQUAL
                "!=" -> NOT_EQUAL
                else -> throw IllegalArgumentException()
            }
        }
    }

    fun invoke(a: Int, b: Int): Boolean = function.invoke(a, b)
}

enum class Operation(private val function: (a: Int, b: Int) -> Int) {
    INCREASE({ a, b -> a + b }), DECREASE({ a, b -> a - b });

    companion object {
        fun from(input: String): Operation {
            return when (input) {
                "inc" -> INCREASE
                "dec" -> DECREASE
                else -> throw IllegalArgumentException()
            }
        }
    }

    fun invoke(a: Int, b: Int): Int = function.invoke(a, b)
}

fun main(args: Array<String>) {
    print(cpu("day8.txt".asResource()))
}