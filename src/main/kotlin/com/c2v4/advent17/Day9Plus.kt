package com.c2v4.advent17

fun garbage2(input: String): Int =
        input.toCharArray().fold(garbageCollector(), { acc: garbageCollector, c: Char ->
            when  {
                acc.skip -> return@fold acc.copy(skip = false)
                c=='!' -> return@fold acc.copy(skip = true)
                acc.inGarbage && c != '>' -> return@fold acc.copy(score = acc.score+1)
                c=='<' -> return@fold acc.copy(inGarbage = true)
                c=='>' -> return@fold acc.copy(inGarbage = false)
                else -> return@fold acc
            }
        }).score

internal data class garbageCollector(val score: Int = 0,
                                     val skip: Boolean = false,
                                     val inGarbage: Boolean = false)

fun main(args: Array<String>) {
    print(garbage2("day9.txt".asResource()))
}