package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day12PlusSpek : Spek({
    given(
"A group is a collection of programs that can all communicate via pipes either directly or indirectly. The programs you identified just a moment ago are all part of the same group." +
        "Now, they would like you to determine the total number of groups.") {
        on("0 <-> 2\n" +
                "1 <-> 1\n" +
                "2 <-> 0, 3, 4\n" +
                "3 <-> 2, 4\n" +
                "4 <-> 2, 3, 6\n" +
                "5 <-> 6\n" +
                "6 <-> 4, 5") {
            it("In the example above, there were 2 groups: one consisting of programs 0,2,3,4,5,6, and the other consisting solely of program 1.") {
                Assertions.assertThat(graph2("0 <-> 2\n" +
                        "1 <-> 1\n" +
                        "2 <-> 0, 3, 4\n" +
                        "3 <-> 2, 4\n" +
                        "4 <-> 2, 3, 6\n" +
                        "5 <-> 6\n" +
                        "6 <-> 4, 5")).isEqualTo(2)
            }
        }
    }
})