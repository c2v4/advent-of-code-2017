package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day16Spek : Spek({
    given("There are sixteen programs in total, named a through p. They start by standing in a line: a stands in position 0, b stands in position 1, and so on until p, which stands in position 15.\n" +
        "\n" +
        "The programs' dance consists of a sequence of dance moves:\n" +
        "\n" +
        "Spin, written sX, makes X programs move from the end to the front, but maintain their order otherwise. (For example, s3 on abcde produces cdeab).\n" +
        "Exchange, written xA/B, makes the programs at positions A and B swap places.\n" +
        "Partner, written pA/B, makes the programs named A and B swap places.\n" +
        "For example, with only five programs standing in a line (abcde), they could do the following dance:\n" +
        "\n" +
        "s1, a spin of size 1: eabcd.\n" +
        "x3/4, swapping the last two programs: eabdc.\n" +
        "pe/b, swapping programs e and b: baedc.") {
        on("Generator A starts with 1092455\n" +
            "Generator B starts with 430625591") {
            it("In the example above, the judge would eventually find a total of 588 pairs that match in their lowest 16 bits.") {
                Assertions.assertThat(dance("s1,x3/4,pe/b",5)).isEqualTo("baedc")
            }
        }
    }
})
