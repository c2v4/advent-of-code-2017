package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day15Spek : Spek({
    given("The generators both work on the same principle. To create its next value, a generator will take the previous value it produced, multiply it by a factor (generator A uses 16807; generator B uses 48271), and then keep the remainder of dividing that resulting product by 2147483647. That final remainder is the value it produces next.\n" +
        "\n" +
        "To calculate each generator's first value, it instead uses a specific starting value as its \"previous value\" (as listed in your puzzle input).\n" +
        "\n" +
        "For example, suppose that for starting values, generator A uses 65, while generator B uses 8921. Then, the first five pairs of generated values are:\n" +
        "\n" +
        "--Gen. A--  --Gen. B--\n" +
        "   1092455   430625591\n" +
        "1181022009  1233683848\n" +
        " 245556042  1431495498\n" +
        "1744312007   137874439\n" +
        "1352636452   285222916\n" +
        "In binary, these pairs are (with generator A's value first in each pair):\n" +
        "\n" +
        "00000000000100001010101101100111\n" +
        "00011001101010101101001100110111\n" +
        "\n" +
        "01000110011001001111011100111001\n" +
        "01001001100010001000010110001000\n" +
        "\n" +
        "00001110101000101110001101001010\n" +
        "01010101010100101110001101001010\n" +
        "\n" +
        "01100111111110000001011011000111\n" +
        "00001000001101111100110000000111\n" +
        "\n" +
        "01010000100111111001100000100100\n" +
        "00010001000000000010100000000100\n" +
        "Here, you can see that the lowest (here, rightmost) 16 bits of the third value match: 1110001101001010. Because of this one match, after processing these five pairs, the judge would have added only 1 to its total.\n" +
        "\n" +
        "To get a significant sample, the judge would like to consider 40 million pairs.") {
        on("Generator A starts with 1092455\n" +
            "Generator B starts with 430625591") {
            it("In the example above, the judge would eventually find a total of 588 pairs that match in their lowest 16 bits.") {
                Assertions.assertThat(generator("Generator A starts with 1092455\n" +
                    "Generator B starts with 430625591")).isEqualTo(588)
            }
        }
    }
})
