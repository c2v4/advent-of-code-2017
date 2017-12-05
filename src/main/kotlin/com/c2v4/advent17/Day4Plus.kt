package com.c2v4.advent17

fun passphrase2(input: String): Boolean {
    val split: List<String> = input.split(Regex("\\s"))
    return passphrase(split.map { it.toCharArray().sorted().joinToString("") }.joinToString(" "))
}

fun main(args: Array<String>) {
    print("day4.txt".asResource().split("\r\n").map { passphrase2(it) }.filter { it }.count())
}