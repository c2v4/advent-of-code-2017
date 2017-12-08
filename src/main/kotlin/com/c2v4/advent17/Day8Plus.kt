package com.c2v4.advent17

fun cpu2(input: String): Int =
        input
                .split("\n").map { it.trim() }.map { it.split(" ") }.map {
            Instruction(it[0],
                    Operation.from(it[1]),
                    it[2].toInt(),
                    Predicate(it[4], it[6].toInt(), Condition.from(it[5])))
        }
                .fold(emptyMap<String, Int>() to 0, { (registers, maxSoFar), instruction ->
                    val map = instruction.run(registers)
                    map to Math.max(map.maxBy { it.value }?.value ?: 0, maxSoFar) })
                .second


fun main(args: Array<String>) {
    print(cpu2("day8.txt".asResource()))
}