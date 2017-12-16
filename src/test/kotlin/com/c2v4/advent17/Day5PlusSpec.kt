package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day5PlusSpec : Spek({
    given("Now, the jumps are even stranger: after each jump, if the offset was three or more, instead decrease it by 1. Otherwise, increase it by 1 as before." ) {
        on("0\n" +
                "3\n" +
                "0\n" +
                "1\n" +
                "-3\n" ) {
            it("Using this rule with the above example, the process now takes 10 steps, and the offset values after finding the exit are left as 2 3 2 3 -1.") {
                Assertions.assertThat(maze2("0\n" +
                        "3\n" +
                        "0\n" +
                        "1\n" +
                        "-3\n")).isEqualTo(10)
            }
        }
    }
})