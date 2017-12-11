package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day11Spek : Spek({
    given("The hexagons (\"hexes\") in this grid are aligned such that adjacent hexes can be found to the north, northeast, southeast, south, southwest, and northwest:\n" +
            "\n" +
            "  \\ n  /\n" +
            "nw +--+ ne\n" +
            "  /    \\\n" +
            "-+      +-\n" +
            "  \\    /\n" +
            "sw +--+ se\n" +
            "  / s  \\\n" +
            "You have the path the child process took. Starting where he started, you need to determine the fewest number of steps required to reach him. (A \"step\" means to move from the hex you are in to any adjacent hex.)") {
        on("ne,ne,ne") {
            it("is 3 steps away.") {
                Assertions.assertThat(hex("ne,ne,ne")).isEqualTo(3)
            }
        }
        on("ne,ne,sw,sw") {
            it("is 0 steps away (back where you started).") {
                Assertions.assertThat(hex("ne,ne,sw,sw")).isEqualTo(0)
            }
        }
        on("ne,ne,s,s") {
            it("is 2 steps away (se,se).") {
                Assertions.assertThat(hex("ne,ne,s,s")).isEqualTo(2)
            }
        }
        on("se,sw,se,sw,sw") {
            it(" is 3 steps away (s,s,sw).") {
                Assertions.assertThat(hex("se,sw,se,sw,sw")).isEqualTo(3)
            }
        }
    }
})