package com.c2v4.advent17

import java.lang.Math.min
import java.util.*


fun hash(listSize: Int, input: String): Int =
        input.split(',').map { it.toInt() }.fold(HashState((0 until listSize).toList()),
                { hashState, i ->
                    reduceHashState(hashState, i)
                }
        ).let { it.list[0] * it.list[1] }

data class HashState(val list: List<Int>,
                     val currentPosition: Int = 0,
                     val skipSize: Int = 0)

fun reduceHashState(hashState: HashState, input: Int): HashState {
    val (list, currentPosition, skipSize) = hashState

    val staticPart = (list + list).subList(
            (currentPosition + input) % list.size,
            min(list.size,
                    (currentPosition + input) % list.size) + list.size - input)

    val reversedPart = list.plus(list).subList(
            currentPosition,
            currentPosition + input).reversed()

    return HashState((staticPart +
            reversedPart)
            .rotate(currentPosition-staticPart.size),
            (currentPosition + input + skipSize) % list.size,
            skipSize + 1)
}

fun <T> List<T>.rotate( shift: Int): List<T> {
    val newValues = toMutableList()
    Collections.rotate(newValues, shift)
    return newValues
}


fun main(args: Array<String>) {
    print(hash(256,"day10.txt".asResource()))
}