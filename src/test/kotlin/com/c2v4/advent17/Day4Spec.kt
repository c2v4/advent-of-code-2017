package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day4Spec : Spek({
    given("To ensure security, a valid passphrase must contain no duplicate words.") {
        on("aa bb cc dd ee") {
            it("is valid") {
                Assertions.assertThat(passphrase("aa bb cc dd ee")).isEqualTo(true)
            }
        }
        on("aa bb cc dd aa") {
            it("is valid") {
                Assertions.assertThat(passphrase("aa bb cc dd aa")).isEqualTo(false)
            }
        }
        on("aa bb cc dd aaa") {
            it("is valid") {
                Assertions.assertThat(passphrase("aa bb cc dd aaa")).isEqualTo(true)
            }
        }

    }
})