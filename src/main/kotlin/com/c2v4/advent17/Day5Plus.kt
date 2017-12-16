package com.c2v4.advent17

fun maze2(input: String): Int {
    val list = input.split('\n').filterNot { it.isEmpty() }.map { it.trim() }.map { it.toInt() }.toMutableList()
    var i = 0
    var pointer = 0
    while (pointer < list.size) {
        val temp = list[pointer]
        if (list[pointer]>2) {
            list[pointer] -= 1
        } else {
            list[pointer] += 1
        }
        pointer += temp
        i++
    }
    return i
}

fun main(args: Array<String>) {
    print(maze2("day5.txt".asResource()))
}