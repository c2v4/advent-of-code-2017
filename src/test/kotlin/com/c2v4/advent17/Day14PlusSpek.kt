package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day14PlusSpek : Spek({
    given("Now, all the defragmenter needs to know is the number of regions. A region is a group of used squares that are all adjacent, not including diagonals. Every used square is in exactly one region: lone used squares form their own isolated regions, while several adjacent squares all count as a single region.\n" +
        "\n" +
        "In the example above, the following nine regions are visible, each marked with a distinct digit:\n" +
        "\n" +
        "11.2.3..-->\n" +
        ".1.2.3.4   \n" +
        "....5.6.   \n" +
        "7.8.55.9   \n" +
        ".88.5...   \n" +
        "88..5..8   \n" +
        ".8...8..   \n" +
        "88.8.88.-->\n" +
        "|      |   \n" +
        "V      V   \n" +
        "Of particular interest is the region marked 8; while it does not appear contiguous in this small view, all of the squares marked 8 are connected when considering the whole 128x128 grid.") {
        on("flqrgnkx") {
            it("In total, in this example, 1242 regions are present.") {
                Assertions.assertThat(defrag2("flqrgnkx")).isEqualTo(1242)
            }
        }
    }
})
