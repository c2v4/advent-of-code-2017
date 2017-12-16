package com.c2v4.advent17

fun captcha2(input: String): Int =
        (0 until input.length)
                .filter { input[it] == input[(it + input.length / 2) % input.length] }
                .map { input[it] }.map { it.toIntValue() }
                .sum()

fun main(args: Array<String>) {
    print(captcha2("day1.txt".asResource()))
}