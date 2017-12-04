package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day3Spec : Spek({
    given("Each square on the grid is allocated in a spiral pattern starting at a location marked 1 and then counting up while spiraling outward. For example, the first few squares are allocated like this:\n" +
            "\n" +
            "17  16  15  14  13\n" +
            "18   5   4   3  12\n" +
            "19   6   1   2  11\n" +
            "20   7   8   9  10\n" +
            "21  22  23---> ...") {
        on("Data from square 1") {
            it("is carried 0 steps, since it's at the access port.") {
                Assertions.assertThat(spiral(1)).isEqualTo(0)
            }
        }
        on("Data from square 12") {
            it("is carried 0 steps, since it's at the access port.") {
                Assertions.assertThat(spiral(12)).isEqualTo(3)
            }
        }
        on("Data from square 23") {
            it("is carried 0 steps, since it's at the access port.") {
                Assertions.assertThat(spiral(23)).isEqualTo(2)
            }
        }
        on("Data from square 1024") {
            it("is carried 0 steps, since it's at the access port.") {
                Assertions.assertThat(spiral(1024)).isEqualTo(31)
            }
        }
    }
})