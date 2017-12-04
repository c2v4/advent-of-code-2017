package com.c2v4.advent17

fun Char.toIntValue() = this.toInt() - 48

fun captcha(input: String): Int =
        (0 until input.length)
                .filter { input[it] == input[(it + 1) % input.length] }
                .map { input[it] }.map { it.toIntValue() }
                .sum()

fun main(args: Array<String>) {
    print(captcha("day1.txt".asResource()))
}