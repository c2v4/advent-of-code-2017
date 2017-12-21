package com.c2v4.advent17

fun scanner(input: String): Int =
    buildFirewall(input).filter { it.first % ((it.second - 1) * 2) == 0 }.map { it.first * it.second }.sum()

fun buildFirewall(input: String): List<Pair<Int, Int>> =
    input.split('\n').map { it.trim() }.map { it.split(": ") }
        .map { it[0].toInt() to it[1].toInt() }

fun main(args: Array<String>) {
    print(scanner("day13.txt".asResource()))
}
