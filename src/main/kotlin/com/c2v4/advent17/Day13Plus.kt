package com.c2v4.advent17

fun scanner2(input: String): Int =
    generateSequence(2) { it + 2 }.takeWhile { i ->
        buildFirewall(input).any {
            val (key, value) = it
            ((key + i) % ((value - 1) * 2)) == 0
        }
    }.max()?.plus(2) ?: 0

fun main(args: Array<String>) {
    print(scanner2("day13.txt".asResource()))
}
