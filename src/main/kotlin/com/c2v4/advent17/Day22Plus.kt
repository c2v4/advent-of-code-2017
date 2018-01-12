package com.c2v4.advent17

import com.c2v4.advent17.Infection.*
import java.util.*

fun ant2(input: String, iterations: Int): Int =
    (0 until iterations)
        .fold(
            State22P(input.split("\n").mapIndexed({ y, s ->
                s.toCharArray().mapIndexed({ x, c -> if (c == '#') Optional.of(Point(x, y)) else Optional.empty() })
            }).flatten().filter { it.isPresent }.map { it.get() to INFECTED }.toMap().toMutableMap()
                , Point(input.split('\n')[0].length / 2, input.split('\n').size / 2)), { acc, i ->
            acc.next()
            acc
        }).infected

data class State22P(val infectedMap: MutableMap<Point, Infection>, val currentLocation: Point, var direction: Direction = Direction.NORTH, var infected: Int = 0)

fun State22P.next() {
    val currentInfected = infectedMap[currentLocation]
    val newDirection = when (currentInfected) {
        null -> direction.left()
        WEAKENED -> direction
        INFECTED -> direction.right()
        FLAGGED -> direction.reverse()
    }
    if (currentInfected == FLAGGED) infectedMap.remove( currentLocation )
    else infectedMap.put(currentLocation.copy() , (currentInfected?.nextState ?: WEAKENED))
    direction = newDirection
    currentLocation.x += direction.xModifier
    currentLocation.y += direction.yModifier
    infected += (if (currentInfected == WEAKENED) 1 else 0)
}

enum class Infection(val nextState: Infection?) {
    FLAGGED(null), INFECTED(FLAGGED), WEAKENED(INFECTED)
}

fun main(args: Array<String>) {
    print(ant2("day22.txt".asResource(), 10000000))
}
