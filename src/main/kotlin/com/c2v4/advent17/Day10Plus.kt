package com.c2v4.advent17

fun hash2(input: String): Any =
        bitHash(input).joinToString("") {
            it.toString(16).padStart(2, '0')
        }

fun bitHash(input: String): List<Int> {
    return input.toCharArray().map { it.toInt() }.let {
        it + listOf(17, 31, 73, 47, 23)
    }.let { list -> (0 until 64).fold(emptyList<Int>(), { acc, i -> acc + list }) }
        .fold(HashState((0 until 256).toList()),
            { hashState, i ->
                reduceHashState(hashState, i)
            }
        ).list.withIndex().groupBy { it.index / 16 }.map { it.value.map { it.value } }
        .map { it.reduce({ acc, i -> i xor acc }) }
}

fun main(args: Array<String>) {
    print(hash2("day10.txt".asResource()))
}
