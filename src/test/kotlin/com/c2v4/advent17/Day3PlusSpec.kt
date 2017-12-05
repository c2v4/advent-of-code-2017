package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day3PlusSpec : Spek({
    given("As a stress test on the system, the programs here clear the grid and then store the value 1 in square 1. Then, in the same allocation order as shown above, they store the sum of the values in all adjacent squares, including diagonals.\n" +
            "\n" +
            "So, the first few squares' values are chosen as follows:\n" +
            "\n" +
            "Square 1 starts with the value 1.\n" +
            "Square 2 has only one adjacent filled square (with value 1), so it also stores 1.\n" +
            "Square 3 has both of the above squares as neighbors and stores the sum of their values, 2.\n" +
            "Square 4 has all three of the aforementioned squares as neighbors and stores the sum of their values, 4.\n" +
            "Square 5 only has the first and fourth squares as neighbors, so it gets the value 5.\n" +
            "Once a square is written, its value does not change. Therefore, the first few squares would receive the following values:\n" +
            "\n" +
            "147  142  133  122   59\n" +
            "304    5    4    2   57\n" +
            "330   10    1    1   54\n" +
            "351   11   23   25   26\n" +
            "362  747  806--->   ..." +
            "What is the first value written that is larger than your puzzle input?") {
        on("120") {
            it("it returns 122.") {
                Assertions.assertThat(spiral2(120)).isEqualTo(122)
            }
        }
        on("300") {
            it("it returns 304.") {
                Assertions.assertThat(spiral2(300)).isEqualTo(304)
            }
        }
        on("400") {
            it("it returns 747.") {
                Assertions.assertThat(spiral2(400)).isEqualTo(747)
            }
        }
    }
})