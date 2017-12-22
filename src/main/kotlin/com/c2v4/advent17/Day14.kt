package com.c2v4.advent17

fun defrag(input: String): Int = (0..127)
    .flatMap { bitHash(input.trim() + "-" + it) }
    .map { cardinality(it) }
    .sum()

fun cardinality(int: Int): Int {
    var x = int
    var count = 0
    while (x != 0) {
        x = x and (x - 1)
        count++
    }
    return count

}

fun main(args: Array<String>) {
    print(defrag("day14.txt".asResource().trim()))
}
