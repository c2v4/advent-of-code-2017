package com.c2v4.advent17

fun checksum(input: String): Int =
        input
                .split('\n')
                .map {
                    it.trim().split("\t")
                            .map { it.toInt() }
                }
                .map { ((it.max() ?: 0) - (it.min() ?: 0)) }
                .sum()

fun main(args: Array<String>) {
    print(checksum("day2.txt".asResource()))
}