package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day17Spek : Spek({
    given("This spinlock's algorithm is simple but efficient, quickly consuming everything in its path. It starts with a circular buffer containing only the value 0, which it marks as the current position. It then steps forward through the circular buffer some number of steps (your puzzle input) before inserting the first new value, 1, after the value it stopped on. The inserted value becomes the current position. Then, it steps forward from there the same number of steps, and wherever it stops, inserts after it the second new value, 2, and uses that as the new current position again.\n" +
        "\n" +
        "It repeats this process of stepping forward, inserting a new value, and using the location of the inserted value as the new current position a total of 2017 times, inserting 2017 as its final operation, and ending with a total of 2018 values (including 0) in the circular buffer.") {
        on("For example, if the spinlock were to step 3 times per insert, the circular buffer would begin to evolve like this (using parentheses to mark the current position after each iteration of the algorithm):") {
            it("(0), the initial state before any insertions.\n" +
                "0 (1): the spinlock steps forward three times (0, 0, 0), and then inserts the first value, 1, after it. 1 becomes the current position.\n" +
                "0 (2) 1: the spinlock steps forward three times (0, 1, 0), and then inserts the second value, 2, after it. 2 becomes the current position.\n" +
                "0  2 (3) 1: the spinlock steps forward three times (1, 0, 2), and then inserts the third value, 3, after it. 3 becomes the current position.\n" +
                "And so on:\n" +
                "\n" +
                "0  2 (4) 3  1\n" +
                "0 (5) 2  4  3  1\n" +
                "0  5  2  4  3 (6) 1\n" +
                "0  5 (7) 2  4  3  6  1\n" +
                "0  5  7  2  4  3 (8) 6  1\n" +
                "0 (9) 5  7  2  4  3  8  6  1\n" +
                "Eventually, after 2017 insertions, the section of the circular buffer near the last insertion looks like this:\n" +
                "\n" +
                "1512  1134  151 (2017) 638  1513  851\n" +
                "Perhaps, if you can identify the value that will ultimately be after the last value written (2017), you can short-circuit the spinlock. In this example, that would be 638.") {
                Assertions.assertThat(spinlock("3")).isEqualTo(638)
            }
        }
    }
})
