package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day2Spec : Spek({
    given("The spreadsheet consists of rows of apparently-random numbers. To make sure the recovery process is on the right track, they need you to calculate the spreadsheet's checksum. For each row, determine the difference between the largest value and the smallest value; the checksum is the sum of all of these differences.") {
        on("5 1 9 5\n" +
                "7 5 3\n" +
                "2 4 6 8") {
            it("The first row's largest and smallest values are 9 and 1, and their difference is 8.\n" +
                    "The second row's largest and smallest values are 7 and 3, and their difference is 4.\n" +
                    "The third row's difference is 6.\n" +
                    "In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.") {
                Assertions.assertThat(checksum("5 1 9 5\n" +
                        "7 5 3\n" +
                        "2 4 6 8")).isEqualTo(18)
            }
        }
    }
})