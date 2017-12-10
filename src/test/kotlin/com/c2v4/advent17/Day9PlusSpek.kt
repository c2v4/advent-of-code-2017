package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day9PlusSpek : Spek({
    given("To prove you've removed it, you need to count all of the characters within the garbage. The leading and trailing < and > don't count, nor do any canceled characters or the ! doing the canceling.\n" +
            "\n" +
            "<>, 0 characters.\n" +
            "<random characters>, 17 characters.\n" +
            "<<<<>, 3 characters.\n" +
            "<{!>}>, 2 characters.\n" +
            "<!!>, 0 characters.\n" +
            "<!!!>>, 0 characters.\n" +
            "<{o\"i!a,<{i<a>, 10 characters."
    ) {
        on("<>") {
            it("0 characters.") {
                Assertions.assertThat(garbage2("<>")).isEqualTo(0)
            }
        }
        on("<random characters>") {
            it("17 characters.") {
                Assertions.assertThat(garbage2("<random characters>")).isEqualTo(17)
            }
        }
        on("<<<<>") {
            it("3 characters.") {
                Assertions.assertThat(garbage2("<<<<>")).isEqualTo(3)
            }
        }
        on("<{!>}>") {
            it("2 characters.") {
                Assertions.assertThat(garbage2("<{!>}>")).isEqualTo(2)
            }
        }
        on("<!!>") {
            it("0 characters.") {
                Assertions.assertThat(garbage2("<!!>")).isEqualTo(0)
            }
        }
        on("<!!!>>") {
            it("0 characters.") {
                Assertions.assertThat(garbage2("<!!!>>")).isEqualTo(0)
            }
        }
        on("<{o\"i!a,<{i<a>") {
            it("10 characters.") {
                Assertions.assertThat(garbage2("<{o\"i!a,<{i<a>")).isEqualTo(10)
            }
        }
    }
})