package com.c2v4.advent17

import java.util.*

fun ant(input: String, iterations: Int): Int =
    (0 until iterations)
        .fold(
            State22(input.split("\n").mapIndexed({
                y, s -> s.toCharArray().mapIndexed({
                x, c -> if(c=='#') Optional.of(Point(x, y)) else Optional.empty()}) }).flatten().filter { it.isPresent }.map { it.get() }.toSet()
                , Point(input.split('\n')[0].length/2, input.split('\n').size/2)), {
            acc, _ -> acc.next()
        }).infected

data class State22(val infectedMap: Set<Point>, val currentLocation: Point, val direction: Direction = Direction.NORTH, val infected: Int = 0)

fun State22.next(): State22 {
    val currentInfected = infectedMap.contains(currentLocation)
    val newDirection = if (currentInfected) direction.right() else direction.left()
    return State22(if (currentInfected) infectedMap - currentLocation else infectedMap + currentLocation, newDirection.movePoint(currentLocation), newDirection, infected + (if (currentInfected) 0 else 1))
}

fun main(args: Array<String>) {
    print(ant("day22.txt".asResource(), 10000))
}
