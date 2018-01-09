package com.c2v4.advent17

import com.c2v4.advent17.Direction.*

fun tubes2(input: String): Int = input.split("\n").map { it.toCharArray() }.let {
    var currentLocation = Point(it[0].indexOf('|'), 0)
    var currentDirection = SOUTH
    var steps =0
    var c = it[currentLocation.y][currentLocation.x]
    while (c != ' ') {
        when (c) {
            '|', '-' -> {
                currentLocation = currentDirection.movePoint(currentLocation)
            }
            '+' -> {
                when (currentDirection) {
                    NORTH, SOUTH -> {
                        if (it[currentLocation.y][currentLocation.x - 1] == ' ') {
                            currentLocation = currentLocation.copy(x = currentLocation.x + 1)
                            currentDirection = EAST
                        } else {
                            currentLocation = currentLocation.copy(x = currentLocation.x - 1)
                            currentDirection = WEST
                        }
                    }
                    EAST, WEST -> {
                        if (it[currentLocation.y - 1][currentLocation.x] == ' ') {
                            currentLocation = currentLocation.copy(y = currentLocation.y + 1)
                            currentDirection = SOUTH
                        } else {
                            currentLocation = currentLocation.copy(y = currentLocation.y - 1)
                            currentDirection = NORTH
                        }
                    }
                }
            }
            else -> {
                currentLocation = currentDirection.movePoint(currentLocation)
            }
        }
        c = it[currentLocation.y][currentLocation.x]
        steps++
    }
    return steps
}

fun main(args: Array<String>) {
    print(tubes2("day19.txt".asResource()))
}
