package com.c2v4.advent17

fun passphrase2(input: String): Boolean {
    val split: List<String> = input.split(Regex("\\s"))
    return split.none { current ->
        split.filterNot { it == current }.any {
            isAnagram(it,
                    current)
        }
    }
}

fun isAnagram(first: String, second: String) =
        first.toCharArray().sorted() == second.toCharArray().sorted()


fun main(args: Array<String>) {
    print("day4.txt".asResource().split("\n").map { it.trim() }.map { passphrase2(it) }.filter { it }.count())
}