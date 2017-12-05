package com.c2v4.advent17

fun maze(input: String): Int {
    val list = input.split('\n').filterNot { it.isEmpty() }.map { it.trim() }.map { it.toInt() }.toMutableList()
    var i = 0
    var pointer = 0
    while (pointer < list.size) {
        val temp = list[pointer]
        list[pointer] += 1
        pointer += temp
        i++
    }
    return i
}

fun main(args: Array<String>) {
    print(maze("day5.txt".asResource()))
}