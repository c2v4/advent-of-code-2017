package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day2PlusSpec : Spek({
    given("It sounds like the goal is to find the only two numbers in each row where one evenly divides the other - that is, where the result of the division operation is a whole number. They would like you to find those numbers on each line, divide them, and add up each line's result.") {
        on("5 9 2 8\n" +
                "9 4 7 3\n" +
                "3 8 6 5") {
            it("In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4.\n" +
                    "In the second row, the two numbers are 9 and 3; the result is 3.\n" +
                    "In the third row, the result is 2.\n" +
                    "In this example, the sum of the results would be 4 + 3 + 2 = 9.") {
                Assertions.assertThat(checksum2("5 9 2 8\n" +
                        "9 4 7 3\n" +
                        "3 8 6 5")).isEqualTo(9)
            }
        }
    }
})