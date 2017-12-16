package com.c2v4.advent17

import java.util.Comparator.*

fun debugger(input: String): Int {
    var newList = input.split(Regex("\\s")).filter { it.isNotEmpty() }.map { it.toInt() }
    val states = mutableSetOf<List<Int>>()
    while (!states.contains(newList)) {
        states.add(newList)
        val tempList = newList.toMutableList()
        val maxWith = tempList
                .mapIndexed({ index, value -> index to value })
                .maxWith(comparing({ t: Pair<Int, Int> -> t.second })
                        .thenComparing(comparing({ t: Pair<Int, Int> -> t.first })
                                .reversed())
                        )
        maxWith?.let {
            tempList[maxWith.first] = 0
            (0 until it.second).forEach { index -> tempList[(it.first + 1 + index) % tempList.size] += 1 }
        }
        newList = tempList
    }
    return states.size
}

fun main(args: Array<String>) {
    print(debugger("day6.txt".asResource()))
}