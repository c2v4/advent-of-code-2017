package com.c2v4.advent17

fun dance2(input: String, letters: Int = 16): String {
    val function = getFunction(input)
    val memoize = mutableListOf<List<Char>>()
    var current = (0 until letters).map { (it + aLetterCode).toChar() }

    repeat(iterations) {
        if(memoize.contains(current)) return memoize[iterations % memoize.size].joinToString("")
        memoize.add(current)
        current=function.invoke(current)
    }
    return current.joinToString("")
}

val iterations = 1_000_000_000

fun getFunction(input: String): (List<Char>) -> List<Char> {
    return { state: List<Char> ->
        input.split(',').fold(state, { accumulator: List<Char>, s: String ->
            when (s.first()) {
                's' -> accumulator.rotate(s.substring(1).toInt())
                'x' -> swap(accumulator,
                    s.substring(1).split('/')[0].toInt(),
                    s.split('/')[1].toInt())
                'p' -> swap(accumulator,
                    accumulator.indexOf(s.substring(1).first()),
                    accumulator.indexOf(s.last()))
                else -> throw IllegalArgumentException()
            }
        })
    }
}


fun main(args: Array<String>) {
    print(dance2("day16.txt".asResource().trim()))
}
