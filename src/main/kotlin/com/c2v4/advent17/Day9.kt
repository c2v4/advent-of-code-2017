package com.c2v4.advent17

fun garbage(input: String): Int =
        input.toCharArray().fold(state(), { acc: state, c: Char ->
            when {
                acc.skip -> return@fold acc.copy(skip = false)
                c == '!' -> return@fold acc.copy(skip = true)
                acc.inGarbage && c != '>' -> return@fold acc
                c == '{' -> return@fold acc.copy(level = acc.level + 1)
                c == '}' -> return@fold acc.copy(score = acc.score + acc.level, level = acc.level - 1)
                c == '<' -> return@fold acc.copy(inGarbage = true)
                c == '>' -> return@fold acc.copy(inGarbage = false)
                c == ',' -> return@fold acc
                else -> throw IllegalStateException()
            }
        }).score

internal data class state(val score: Int = 0,
                          val level: Int = 0,
                          val skip: Boolean = false,
                          val inGarbage: Boolean = false)

fun main(args: Array<String>) {
    print(garbage("day9.txt".asResource()))
}