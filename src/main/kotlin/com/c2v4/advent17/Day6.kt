package com.c2v4.advent17

import java.util.*

fun debugger(input: String): Int {
    var newList = input.split(Regex("\\s")).filter { it.isNotEmpty() }.map { it.toInt() }
    val states = mutableSetOf<List<Int>>()
    while (!states.contains(newList)) {
        states.add(newList)
        val templist = newList.toMutableList()
        val maxWith = templist.mapIndexed({ index, value -> index to value }).maxWith(Comparator.comparing(
                { t: Pair<Int, Int> -> t.second }).thenComparing(
                { (first) -> first }))
        maxWith?.let {
            templist[maxWith.first]=0
            (0 until it.second).forEach { index -> templist[(it.first+1+index)%templist.size]+=1 }
        }
        newList = templist
    }
    return states.size
}

fun main(args: Array<String>) {
    print(debugger("day6.txt".asResource()))
}