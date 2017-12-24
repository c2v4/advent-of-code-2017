package com.c2v4.advent17

fun spinlock(input: String, end: Int = 2017): Int = (1..end).fold(
    listOf(0) to 0, { (list, currentPosition), i ->
    val reifiedPosition = (currentPosition + input.toInt()) % list.size
    list.subList(0, reifiedPosition) + listOf(i) + list.subList(reifiedPosition,
        list.size) to (reifiedPosition + 1) % (list.size + 1)
}
).let {
    val list = it.first
    list[list.indexOf(end) + 1 % list.size]
}


fun main(args: Array<String>) {
    print(spinlock("day17.txt".asResource().trim()))
}
