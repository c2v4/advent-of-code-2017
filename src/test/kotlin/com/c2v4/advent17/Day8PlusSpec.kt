package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day8PlusSpec : Spek({
    given("To be safe, the CPU also needs to know the highest value held in any register during this process so that it can decide how much memory to allocate to these operations." ) {
        on("For example, in the above instructions" ) {
            it("the highest value ever held was 10 (in register c after the third instruction was evaluated).") {
                Assertions.assertThat(cpu2("b inc 5 if a > 1\n" +
                        "a inc 1 if b < 5\n" +
                        "c dec -10 if a >= 1\n" +
                        "c inc -20 if c == 10")).isEqualTo(10)
            }
        }
    }
})