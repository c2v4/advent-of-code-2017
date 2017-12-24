package com.c2v4.advent17

fun spinlock2(input: String, end: Int = 50_000_000): Int {
    val shift = input.toInt()
    return (1..end).fold(
        0 to 0, { (value, currentPosition), i ->
        val newPosition = ((currentPosition + shift) % i) +1
        if (newPosition == 1) return@fold i to newPosition
        return@fold value to newPosition
    }).first
}


fun main(args: Array<String>) {
    print(spinlock2("day17.txt".asResource().trim()))
}
