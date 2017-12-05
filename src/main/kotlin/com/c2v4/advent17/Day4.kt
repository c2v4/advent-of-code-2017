package com.c2v4.advent17

fun passphrase(input:String):Boolean {
    val split = input.split(" ")
    return split == split.distinct()
}

fun main(args: Array<String>) {
    print("day4.txt".asResource().split("\n").map { it.trim() }.map { passphrase(it) }.filter { it }.count())
}
