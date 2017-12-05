package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day5Spec : Spek({
    given("The message includes a list of the offsets for each jump. Jumps are relative: -1 moves to the previous instruction, and 2 skips the next one. Start at the first instruction in the list. The goal is to follow the jumps until one leads outside the list.\n" +
            "\n" +
            "In addition, these instructions are a little strange; after each jump, the offset of that instruction increases by 1. So, if you come across an offset of 3, you would move three instructions forward, but change it to a 4 for the next time it is encountered.\n" ) {
        on("0\n" +
                "3\n" +
                "0\n" +
                "1\n" +
                "-3\n" ) {
            it("Positive jumps (\"forward\") move downward; negative jumps move upward. For legibility in this example, these offset values will be written all on one line, with the current instruction marked in parentheses. The following steps would be taken before an exit is found:\n" +
                    "\n" +
                    "(0) 3  0  1  -3  - before we have taken any steps.\n" +
                    "(1) 3  0  1  -3  - jump with offset 0 (that is, don't jump at all). Fortunately, the instruction is then incremented to 1.\n" +
                    " 2 (3) 0  1  -3  - step forward because of the instruction we just modified. The first instruction is incremented again, now to 2.\n" +
                    " 2  4  0  1 (-3) - jump all the way to the end; leave a 4 behind.\n" +
                    " 2 (4) 0  1  -2  - go back to where we just were; increment -3 to -2.\n" +
                    " 2  5  0  1  -2  - jump 4 steps forward, escaping the maze.\n" +
                    "In this example, the exit is reached in 5 steps.") {
                Assertions.assertThat(maze("0\n" +
                        "3\n" +
                        "0\n" +
                        "1\n" +
                        "-3\n")).isEqualTo(5)
            }
        }

    }
})