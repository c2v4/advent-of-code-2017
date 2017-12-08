package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day8Spec : Spek({
    given("Each Instruction consists of several parts: the register to modify, whether to increase or decrease that register's value, the amount by which to increase or decrease it, and a predicate. If the predicate fails, skip the Instruction without modifying the register. The registers all start at 0. " ) {
        on("b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10" ) {
            it("These instructions would be processed as follows:\n" +
                    "\n" +
                    "Because a starts at 0, it is not greater than 1, and so b is not modified.\n" +
                    "a is increased by 1 (to 1) because b is less than 5 (it is 0).\n" +
                    "c is decreased by -10 (to 10) because a is now greater than or equal to 1 (it is 1).\n" +
                    "c is increased by -20 (to -10) because c is equal to 10.\n" +
                    "After this process, the largest value in any register is 1.") {
                Assertions.assertThat(cpu("b inc 5 if a > 1\n" +
                        "a inc 1 if b < 5\n" +
                        "c dec -10 if a >= 1\n" +
                        "c inc -20 if c == 10")).isEqualTo(1)
            }
        }

    }
})