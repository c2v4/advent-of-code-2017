package com.c2v4.advent17

fun String.strip() = this.substring(1 until this.length - 1)

fun tower(input: String): String? =
        input.split('\n').map { it.trim() }.map {
            val split = it.split(" -> ")
            Triple(split[0].split(" ")[0],
                    split[0].split(" ")[1].strip().toInt(),
                    if (split.size > 1) split[1].split(", ") else emptyList())
        }.let {
            it.filter { triple -> triple.third.isNotEmpty() }.find { (first) ->
                it.none { current ->
                    current.third.contains(first)
                }
            }
        }?.first

fun main(args: Array<String>) {
    print(tower("day7.txt".asResource()))
}