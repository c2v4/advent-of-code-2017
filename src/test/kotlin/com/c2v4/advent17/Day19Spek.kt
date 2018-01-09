package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day19Spek : Spek({
    given("Its starting moveLocation is just off the top of the diagram. Lines (drawn with |, -, and +) show the path it needs to take, starting by going down onto the only line connected to the top of the diagram. It needs to follow this path until it reaches the end (located somewhere within the diagram) and stop there.\n" +
        "\n" +
        "Sometimes, the lines cross over each other; in these cases, it needs to continue going the same direction, and only turn left or right when there's no other option. In addition, someone has left letters on the line; these also don't change its direction, but it can use them to keep track of where it's been.") {
        on("     |          \n" +
                     "     |  +--+    \n" +
                     "     A  |  C    \n" +
                     " F---|----E|--+ \n" +
                     "     |  |  |  D \n" +
                     "     +B-+  +--+ \n" +
            "                     ") {
            it("Given this diagram, the packet needs to take the following path:\n" +
                "\n" +
                "Starting at the only line touching the top of the diagram, it must go down, pass through A, and continue onward to the first +.\n" +
                "Travel right, up, and right, passing through B in the process.\n" +
                "Continue down (collecting C), right, and up (collecting D).\n" +
                "Finally, go all the way left through E and stopping at F.\n" +
                "Following the path to the end, the letters it sees on its path are ABCDEF.") {
                Assertions.assertThat(tubes("     |          \n" +
                    "     |  +--+    \n" +
                    "     A  |  C    \n" +
                    " F---|----E|--+ \n" +
                    "     |  |  |  D \n" +
                    "     +B-+  +--+ \n" +
                    "                  ")).isEqualTo("ABCDEF")
            }
        }
    }
})
