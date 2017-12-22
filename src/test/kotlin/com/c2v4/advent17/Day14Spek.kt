package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day14Spek : Spek({
    given("A total of 128 knot hashes are calculated, each corresponding to a single row in the grid; each hash contains 128 bits which correspond to individual grid squares. Each bit of a hash indicates whether that square is free (0) or used (1).\n" +
        "\n" +
        "The hash inputs are a key string (your puzzle input), a dash, and a number from 0 to 127 corresponding to the row. For example, if your key string were flqrgnkx, then the first row would be given by the bits of the knot hash of flqrgnkx-0, the second row from the bits of the knot hash of flqrgnkx-1, and so on until the last row, flqrgnkx-127.\n" +
        "\n" +
        "The output of a knot hash is traditionally represented by 32 hexadecimal digits; each of these digits correspond to 4 bits, for a total of 4 * 32 = 128 bits. To convert to bits, turn each hexadecimal digit to its equivalent binary value, high-bit first: 0 becomes 0000, 1 becomes 0001, e becomes 1110, f becomes 1111, and so on; a hash that begins with a0c2017... in hexadecimal would begin with 10100000110000100000000101110000... in binary.") {
        on("Continuing this process, the first 8 rows and columns for key flqrgnkx appear as follows, using # to denote used squares, and . to denote free ones:\n" +
            "\n" +
            "##.#.#..-->\n" +
            ".#.#.#.#   \n" +
            "....#.#.   \n" +
            "#.#.##.#   \n" +
            ".##.#...   \n" +
            "##..#..#   \n" +
            ".#...#..   \n" +
            "##.#.##.-->\n" +
            "|      |   \n" +
            "V      V   ") {
            it("In this example, 8108 squares are used across the entire 128x128 grid.") {
                Assertions.assertThat(defrag("flqrgnkx")).isEqualTo(8108)
            }
        }
    }
})
