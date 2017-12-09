package com.c2v4.advent17

fun garbage(input: String): Int =
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

fun main(args: Array<String>) {
    print(garbage("day9.txt".asResource()))
}