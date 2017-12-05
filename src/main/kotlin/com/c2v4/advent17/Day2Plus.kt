package com.c2v4.advent17

fun checksum2(input: String): Int =
        input
                .split('\n')
                .map {
                    it.trim().split(Regex("\\s"))
                            .map { it.toInt() }
                }
                .map { line -> (line.firstOrNull { element -> line.filterNot { it == element }.any { element % it == 0 } } ?: 0) / (line.firstOrNull { element -> line.filterNot { it == element }.any { it % element == 0 } } ?: 1) }
                .sum()

fun main(args: Array<String>) {
    print(checksum2("day2.txt".asResource()))
}