package com.c2v4.advent17

import java.awt.Point
import java.lang.Math.abs
import java.lang.Math.max


fun hex(input: String): Int =
        input.split(',').fold(Point(0, 0),
                { currentLocation, instruction ->
                    when (instruction) {
                        "n" -> currentLocation.moveNew(0, -1)
                        "ne" -> currentLocation.moveNew(1, -1)
                        "se" -> currentLocation.moveNew(1, 0)
                        "s" -> currentLocation.moveNew(0, 1)
                        "sw" -> currentLocation.moveNew(-1, 1)
                        "nw" -> currentLocation.moveNew(-1, 0)
                        else -> throw IllegalArgumentException()
                    }
                }
        ).let {
            val (x, y) = it
            max(abs(x), abs(y))
        }


private operator fun Point.component2(): Int = y

private operator fun Point.component1(): Int = x

private fun Point.moveNew(plusX: Int, plusY: Int): Point = Point(x + plusX, y + plusY)


fun main(args: Array<String>) {
    print(hex("day11.txt".asResource()))
}