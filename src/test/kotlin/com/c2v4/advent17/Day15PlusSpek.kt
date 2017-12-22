package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day15PlusSpek : Spek({
    given("In the interest of trying to align a little better, the generators get more picky about the numbers they actually give to the judge.\n" +
        "\n" +
        "They still generate values in the same way, but now they only hand a value to the judge when it meets their criteria:\n" +
        "\n" +
        "Generator A looks for values that are multiples of 4.\n" +
        "Generator B looks for values that are multiples of 8.\n" +
        "Each generator functions completely independently: they both go through values entirely on their own, only occasionally handing an acceptable value to the judge, and otherwise working through the same sequence of values as before until they find one.\n" +
        "\n" +
        "The judge still waits for each generator to provide it with a value before comparing them (using the same comparison method as before). It keeps track of the order it receives values; the first values from each generator are compared, then the second values from each generator, then the third values, and so on.\n" +
        "\n" +
        "Using the example starting values given above, the generators now produce the following first five values each:\n" +
        "\n" +
        "--Gen. A--  --Gen. B--\n" +
        "1352636452  1233683848\n" +
        "1992081072   862516352\n" +
        " 530830436  1159784568\n" +
        "1980017072  1616057672\n" +
        " 740335192   412269392\n" +
        "These values have the following corresponding binary values:\n" +
        "\n" +
        "01010000100111111001100000100100\n" +
        "01001001100010001000010110001000\n" +
        "\n" +
        "01110110101111001011111010110000\n" +
        "00110011011010001111010010000000\n" +
        "\n" +
        "00011111101000111101010001100100\n" +
        "01000101001000001110100001111000\n" +
        "\n" +
        "01110110000001001010100110110000\n" +
        "01100000010100110001010101001000\n" +
        "\n" +
        "00101100001000001001111001011000\n" +
        "00011000100100101011101101010000\n" +
        "Unfortunately, even though this change makes more bits similar on average, none of these values' lowest 16 bits match. Now, it's not until the 1056th pair that the judge finds the first match:\n" +
        "\n" +
        "--Gen. A--  --Gen. B--\n" +
        "1023762912   896885216\n" +
        "\n" +
        "00111101000001010110000111100000\n" +
        "00110101011101010110000111100000") {
        on("Generator A starts with 1092455\n" +
            "Generator B starts with 430625591") {
            it("This change makes the generators much slower, and the judge is getting impatient; it is now only willing to consider 5 million pairs. (Using the values from the example above, after five million pairs, the judge would eventually find a total of 309 pairs that match in their lowest 16 bits.)") {
                Assertions.assertThat(generator2("Generator A starts with 1092455\n" +
                    "Generator B starts with 430625591")).isEqualTo(309)
            }
        }
    }
})
