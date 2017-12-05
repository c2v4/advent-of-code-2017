package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day1PlusSpec : Spek({
    given("Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list. That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. Fortunately, your list has an even number of elements.") {
        on("1212") {
            it("produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.") {
                Assertions.assertThat(captcha2("1212")).isEqualTo(6)
            }
        }
        on("1221") {
            it("produces 0, because every comparison is between a 1 and a 2.") {
                Assertions.assertThat(captcha2("1221")).isEqualTo(0)
            }
        }
        on("123425") {
            it("produces 4, because both 2s match each other, but no other digit has a match.") {
                Assertions.assertThat(captcha2("123425")).isEqualTo(4)
            }
        }
        on("123123") {
            it("produces 12") {
                Assertions.assertThat(captcha2("123123")).isEqualTo(12)
            }
        }
        on("12131415") {
            it("produces 4") {
                Assertions.assertThat(captcha2("12131415")).isEqualTo(4)
            }
        }
    }
})