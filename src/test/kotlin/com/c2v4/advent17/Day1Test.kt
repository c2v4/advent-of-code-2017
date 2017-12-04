package com.c2v4.advent17

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day1Spec : Spek({
    given("The com.c2v4.advent17.captcha requires you to review a sequence of digits (your puzzle input) and find the sum of all digits that match the next digit in the list. The list is circular, so the digit after the last digit is the first digit in the list.") {
        on("1122") {
            it("produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.") {
                assertThat(captcha("1122")).isEqualTo(3)
            }
        }
        on("1111") {
            it("produces 4 because each digit (all 1) matches the next.") {
                assertThat(captcha("1111")).isEqualTo(4)
            }
        }
        on("1234") {
            it("produces 0 because no digit matches the next.") {
                assertThat(captcha("1234")).isEqualTo(0)
            }
        }
        on("91212129") {
            it("produces 9 because the only digit that matches the next one is the last digit, 9.") {
                assertThat(captcha("91212129")).isEqualTo(9)
            }
        }
    }
})