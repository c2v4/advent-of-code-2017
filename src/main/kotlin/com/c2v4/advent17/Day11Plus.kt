package com.c2v4.advent17

import java.awt.Point
import java.lang.Math.abs
import java.lang.Math.max

fun hex2(input: String): Int =
        input.split(',').fold(Point(0, 0) to 0,
                { (currentLocation, maxSoFar), instruction ->
                    when (instruction) {
                        "n" -> {
                            val moveNew = currentLocation.moveNew(0, -1)
                            moveNew to max(maxSoFar, maxSteps(moveNew))
                        }
                        "ne" -> {
                            val moveNew = currentLocation.moveNew(1, -1)
                            moveNew to max(maxSoFar, maxSteps(moveNew))
                        }
                        "se" -> {
                            val moveNew = currentLocation.moveNew(1, 0)
                            moveNew to max(maxSoFar, maxSteps(moveNew))
                        }
                        "s" -> {
                            val moveNew = currentLocation.moveNew(0, 1)
                            moveNew to max(maxSoFar, maxSteps(moveNew))
                        }
                        "sw" -> {
                            val moveNew = currentLocation.moveNew(-1, 1)
                            moveNew to max(maxSoFar, maxSteps(moveNew))
                        }
                        "nw" -> {
                            val moveNew = currentLocation.moveNew(-1, 0)
                            moveNew to max(maxSoFar, maxSteps(moveNew))
                        }
                        else -> throw IllegalArgumentException()
                    }
                }
        ).let {
            it.second
        }

private fun maxSteps(point: Point): Int {
    val (x, y) = point
    return max(abs(x), abs(y))
}

private operator fun Point.component2(): Int = y

private operator fun Point.component1(): Int = x

private fun Point.moveNew(plusX: Int, plusY: Int): Point = Point(x + plusX, y + plusY)

fun main(args: Array<String>) {
    print(hex2("day11.txt".asResource()))
}