package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day19PlusSpek : Spek({
    given("The packet is curious how many steps it needs to go.") {
        on("     |          \n" +
                     "     |  +--+    \n" +
                     "     A  |  C    \n" +
                     " F---|----E|--+ \n" +
                     "     |  |  |  D \n" +
                     "     +B-+  +--+ \n" +
            "                     ") {
            it("the packet would go:\n" +
                "\n" +
                "6 steps down (including the first line at the top of the diagram).\n" +
                "3 steps right.\n" +
                "4 steps up.\n" +
                "3 steps right.\n" +
                "4 steps down.\n" +
                "3 steps right.\n" +
                "2 steps up.\n" +
                "13 steps left (including the F it stops on).\n" +
                "This would result in a total of 38 steps.") {
                Assertions.assertThat(tubes2("     |          \n" +
                    "     |  +--+    \n" +
                    "     A  |  C    \n" +
                    " F---|----E|--+ \n" +
                    "     |  |  |  D \n" +
                    "     +B-+  +--+ \n" +
                    "                  ")).isEqualTo(38)
            }
        }
    }
})
