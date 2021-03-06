package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day9Spek : Spek({
    given("A large stream blocks your path. According to the locals, it's not safe to cross the stream at the moment because it's full of garbage. You look down at the stream; rather than water, you discover that it's a stream of characters.\n" +
            "\n" +
            "You sit for a while and record part of the stream (your puzzle input). The characters represent groups - sequences that begin with { and end with }. Within a group, there are zero or more other things, separated by commas: either another group or garbage. Since groups can contain other groups, a } only closes the most-recently-opened unclosed group - that is, they are nestable. Your puzzle input represents a single, large group which itself contains many smaller ones.\n" +
            "\n" +
            "Sometimes, instead of a group, you will find garbage. Garbage begins with < and ends with >. Between those angle brackets, almost any character can appear, including { and }. Within garbage, < has no special meaning.\n" +
            "\n" +
            "In a futile attempt to clean up the garbage, some program has canceled some of the characters within it using !: inside garbage, any character that comes after ! should be ignored, including <, >, and even another !.\n" +
            "\n" +
            "You don't see any characters that deviate from these rules. Outside garbage, you only find well-formed groups, and garbage always terminates according to the rules above.\n" +
            "\n" +
            "Here are some self-contained pieces of garbage:\n" +
            "\n" +
            "<>, empty garbage.\n" +
            "<random characters>, garbage containing random characters.\n" +
            "<<<<>, because the extra < are ignored.\n" +
            "<{!>}>, because the first > is canceled.\n" +
            "<!!>, because the second ! is canceled, allowing the > to terminate the garbage.\n" +
            "<!!!>>, because the second ! and the first > are canceled.\n" +
            "<{o\"i!a,<{i<a>, which ends at the first >.\n" +
            "Here are some examples of whole streams and the number of groups they contain:\n" +
            "\n" +
            "{}, 1 group.\n" +
            "{{{}}}, 3 groups.\n" +
            "{{},{}}, also 3 groups.\n" +
            "{{{},{},{{}}}}, 6 groups.\n" +
            "{<{},{},{{}}>}, 1 group (which itself contains garbage).\n" +
            "{<a>,<a>,<a>,<a>}, 1 group.\n" +
            "{{<a>},{<a>},{<a>},{<a>}}, 5 groups.\n" +
            "{{<!>},{<!>},{<!>},{<a>}}, 2 groups (since all but the last > are canceled).\n" +
            "Your goal is to find the total score for all groups in your input. Each group is assigned a score which is one more than the score of the group that immediately contains it. (The outermost group gets a score of 1.)" ) {
        on("{}" ) {
            it("score of 1") {
                Assertions.assertThat(garbage("{}")).isEqualTo(1)
            }
        }
        on("{{{}}}" ) {
            it("score of 1 + 2 + 3 = 6.") {
                Assertions.assertThat(garbage("{{{}}}")).isEqualTo(6)
            }
        }
        on("{{},{}}" ) {
            it("score of 1 + 2 + 2 = 5.") {
                Assertions.assertThat(garbage("{{},{}}")).isEqualTo(5)
            }
        }
        on("{{{},{},{{}}}}" ) {
            it("score of 1 + 2 + 3 + 3 + 3 + 4 = 16.") {
                Assertions.assertThat(garbage("{{{},{},{{}}}}")).isEqualTo(16)
            }
        }
        on("{<a>,<a>,<a>,<a>}" ) {
            it("score of 1") {
                Assertions.assertThat(garbage("{<a>,<a>,<a>,<a>}")).isEqualTo(1)
            }
        }
        on("{{<ab>},{<ab>},{<ab>},{<ab>}}" ) {
            it("score of 1 + 2 + 2 + 2 + 2 = 9.") {
                Assertions.assertThat(garbage("{{<ab>},{<ab>},{<ab>},{<ab>}}")).isEqualTo(9)
            }
        }
        on("{{<!!>},{<!!>},{<!!>},{<!!>}}" ) {
            it("score of 1 + 2 + 2 + 2 + 2 = 9.") {
                Assertions.assertThat(garbage("{{<!!>},{<!!>},{<!!>},{<!!>}}")).isEqualTo(9)
            }
        }
        on("{{<a!>},{<a!>},{<a!>},{<ab>}}" ) {
            it(" score of 1 + 2 = 3.") {
                Assertions.assertThat(garbage("{{<a!>},{<a!>},{<a!>},{<ab>}}")).isEqualTo(3)
            }
        }
    }
})