package com.c2v4.advent17

fun dance(input: String, letters: Int = 16): String =
    input.split(',').fold((0 until letters).map { (it + aLetterCode).toChar() }, { acc, s ->
        when (s.first()) {
            's' -> acc.toCharArray().asList().rotate(s.substring(1).toInt())
            'x' -> swap(acc, s.substring(1).split('/')[0].toInt(), s.substring(1).split('/')[1].toInt())
            'p' -> swap(acc, acc.indexOf(s.substring(1).first()), acc.indexOf(s.substring(1).last()))
            else -> throw IllegalArgumentException()
        }
    }).joinToString("")

fun swap(input: List<Char>, first: Int, second: Int): List<Char> {
    val mutableInput = input.toMutableList()
    val temp = mutableInput[first]
    mutableInput[first] = mutableInput[second]
    mutableInput[second] = temp
    return mutableInput
}

val aLetterCode = 97

fun main(args: Array<String>) {
    print(dance("day16.txt".asResource().trim()))
}
