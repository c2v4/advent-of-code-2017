package com.c2v4.advent17

import com.c2v4.advent17.Direction.*

fun tubes(input: String): String = input.split("\n").map { it.toCharArray() }.let {
    var currentLocation = Point(it[0].indexOf('|'), 0)
    var currentDirection = SOUTH
    var code = ""
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
                code += c
                currentLocation = currentDirection.movePoint(currentLocation)
            }
        }
        c = it[currentLocation.y][currentLocation.x]
    }
    return code
}

data class Point(val x: Int, val y: Int)

enum class Direction(private val transform: (Point) -> Point) {
    NORTH({ point -> point.copy(y = point.y - 1) }),
    WEST({ point -> point.copy(x = point.x - 1) }),
    SOUTH({ point -> point.copy(y = point.y + 1) }),
    EAST({ point -> point.copy(x = point.x + 1) });

    companion object {
        val IN_ORDER = listOf(NORTH, EAST, SOUTH, WEST)
    }

    fun movePoint(point: Point): Point = transform(point)

    fun left() = IN_ORDER[(IN_ORDER.size + IN_ORDER.indexOf(this)-1) % IN_ORDER.size]
    fun right() = IN_ORDER[(IN_ORDER.indexOf(this)+1) % IN_ORDER.size]
}

fun main(args: Array<String>) {
    print(tubes("day19.txt".asResource()))
}
