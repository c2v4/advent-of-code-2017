package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day12Spek : Spek({
    given(
            "You walk through the village and record the ID of each program and the IDs with which it can communicate directly (your puzzle input). Each program has one or more programs with which it can communicate, and these pipes are bidirectional; if 8 says it can communicate with 11, then 11 will say it can communicate with 8.\n" +
                    "You need to figure out how many programs are in the group that contains program ID 0.") {
        on("0 <-> 2\n" +
                "1 <-> 1\n" +
                "2 <-> 0, 3, 4\n" +
                "3 <-> 2, 4\n" +
                "4 <-> 2, 3, 6\n" +
                "5 <-> 6\n" +
                "6 <-> 4, 5") {
            it("Program 0 by definition.\n" +
                    "Program 2, directly connected to program 0.\n" +
                    "Program 3 via program 2.\n" +
                    "Program 4 via program 2.\n" +
                    "Program 5 via programs 6, then 4, then 2.\n" +
                    "Program 6 via programs 4, then 2.\n" +
                    "Therefore, a total of 6 programs are in this group; all but program 1, which has a pipe that connects it to itself.") {
                Assertions.assertThat(graph("0 <-> 2\n" +
                        "1 <-> 1\n" +
                        "2 <-> 0, 3, 4\n" +
                        "3 <-> 2, 4\n" +
                        "4 <-> 2, 3, 6\n" +
                        "5 <-> 6\n" +
                        "6 <-> 4, 5")).isEqualTo(6)
            }
        }
    }
})