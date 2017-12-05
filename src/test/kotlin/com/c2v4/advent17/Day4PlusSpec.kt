package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day4PlusSpec : Spek({
    given("For added security, yet another system policy has been put in place. Now, a valid passphrase must contain no two words that are anagrams of each other - that is, a passphrase is invalid if any word's letters can be rearranged to form any other word in the passphrase.") {
        on("abcde fghij") {
            it("is valid") {
                Assertions.assertThat(passphrase2("abcde fghij")).isEqualTo(true)
            }
        }
        on("abcde xyz ecdab") {
            it("is not valid - the letters from the third word can be rearranged to form the first word.") {
                Assertions.assertThat(passphrase2("abcde xyz ecdab")).isEqualTo(false)
            }
        }
        on("a ab abc abd abf abj") {
            it("is a valid passphrase, because all letters need to be used when forming another word.") {
                Assertions.assertThat(passphrase2("a ab abc abd abf abj")).isEqualTo(true)
            }
        }
        on("iiii oiii ooii oooi oooo") {
            it("is valid") {
                Assertions.assertThat(passphrase2("iiii oiii ooii oooi oooo")).isEqualTo(true)
            }
        }
        on("oiii ioii iioi iiio") {
            it("is not valid - any of these words can be rearranged to form any other word.") {
                Assertions.assertThat(passphrase2("oiii ioii iioi iiio")).isEqualTo(false)
            }
        }
        on("jbkuw kwir rkiw ubwkj") {
            it("is not valid - kwir - rkiw") {
                Assertions.assertThat(passphrase2("jbkuw kwir rkiw ubwkj")).isEqualTo(false)
            }
        }

    }
})