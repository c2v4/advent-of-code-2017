package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day9 : Spek({
    given("Each Instruction consists of several parts: the register to modify, whether to increase or decrease that register's value, the amount by which to increase or decrease it, and a predicate. If the predicate fails, skip the Instruction without modifying the register. The registers all start at 0. " ) {
        on("{}" ) {
            it("") {
                Assertions.assertThat(garbage("{}")).isEqualTo(1)
            }
        }
        on("{{{}}}" ) {
            it("") {
                Assertions.assertThat(garbage("{{{}}}")).isEqualTo(6)
            }
        }
        on("{{},{}}" ) {
            it("") {
                Assertions.assertThat(garbage("{{},{}}")).isEqualTo(5)
            }
        }
    }
})
/*
{}, score of 1.
{{{}}}, score of 1 + 2 + 3 = 6.
{{},{}}, score of 1 + 2 + 2 = 5.
{{{},{},{{}}}}, score of 1 + 2 + 3 + 3 + 3 + 4 = 16.
{<a>,<a>,<a>,<a>}, score of 1.
{{<ab>},{<ab>},{<ab>},{<ab>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
{{<!!>},{<!!>},{<!!>},{<!!>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
{{<a!>},{<a!>},{<a!>},{<ab>}}, score of 1 + 2 = 3.
 */