package com.c2v4.advent17

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day21Spek : Spek({
    given("You find a program trying to generate some art. It uses a strange process that involves repeatedly enhancing the detail of an image through a set of rules.\n" +
        "\n" +
        "The image consists of a two-dimensional square grid of pixels that are either on (#) or off (.). The program always begins with this pattern:\n" +
        "\n" +
        ".#.\n" +
        "..#\n" +
        "###\n" +
        "Because the pattern is both 3 pixels wide and 3 pixels tall, it is said to have a size of 3.\n" +
        "\n" +
        "Then, the program repeats the following process:\n" +
        "\n" +
        "If the size is evenly divisible by 2, break the pixels up into 2x2 squares, and convert each 2x2 square into a 3x3 square by following the corresponding enhancement rule.\n" +
        "Otherwise, the size is evenly divisible by 3; break the pixels up into 3x3 squares, and convert each 3x3 square into a 4x4 square by following the corresponding enhancement rule.\n" +
        "Because each square of pixels is replaced by a larger one, the image gains pixels and so its size increases.\n" +
        "\n" +
        "The artist's book of enhancement rules is nearby (your puzzle input); however, it seems to be missing rules. The artist explains that sometimes, one must rotate or flip the input pattern to find a match. (Never rotate or flip the output pattern, though.) Each pattern is written concisely: rows are listed as single units, ordered top-down, and separated by slashes. For example, the following rules correspond to the adjacent patterns:\n" +
        "\n" +
        "../.#  =  ..\n" +
        "          .#\n" +
        "\n" +
        "                .#.\n" +
        ".#./..#/###  =  ..#\n" +
        "                ###\n" +
        "\n" +
        "                        #..#\n" +
        "#..#/..../#..#/.##.  =  ....\n" +
        "                        #..#\n" +
        "                        .##.\n" +
        "When searching for a rule to use, rotate and flip the pattern as necessary. For example, all of the following patterns match the same rule:\n" +
        "\n" +
        ".#.   .#.   #..   ###\n" +
        "..#   #..   #.#   ..#\n" +
        "###   ###   ##.   .#.") {
        on("../.# => ##./#../...\n" +
            ".#./..#/### => #..#/..../..../#..#") {
            it("As before, the program begins with this pattern:\n" +
                "\n" +
                ".#.\n" +
                "..#\n" +
                "###\n" +
                "The size of the grid (3) is not divisible by 2, but it is divisible by 3. It divides evenly into a single square; the square matches the second rule, which produces:\n" +
                "\n" +
                "#..#\n" +
                "....\n" +
                "....\n" +
                "#..#\n" +
                "The size of this enhanced grid (4) is evenly divisible by 2, so that rule is used. It divides evenly into four squares:\n" +
                "\n" +
                "#.|.#\n" +
                "..|..\n" +
                "--+--\n" +
                "..|..\n" +
                "#.|.#\n" +
                "Each of these squares matches the same rule (../.# => ##./#../...), three of which require some flipping and rotation to line up with the rule. The output for the rule is the same in all four cases:\n" +
                "\n" +
                "##.|##.\n" +
                "#..|#..\n" +
                "...|...\n" +
                "---+---\n" +
                "##.|##.\n" +
                "#..|#..\n" +
                "...|...\n" +
                "Finally, the squares are joined into a new grid:\n" +
                "\n" +
                "##.##.\n" +
                "#..#..\n" +
                "......\n" +
                "##.##.\n" +
                "#..#..\n" +
                "......\n" +
                "Thus, after 2 iterations, the grid contains 12 pixels that are on.") {
                assertThat(fractal("../.# => ##./#../...\n" +
                    ".#./..#/### => #..#/..../..../#..#", 2)).isEqualTo(12)
            }
        }
    }
    given("Rotation of array is needed") {
        on("1.0.0/0.1.1/0.1.0") {
            it("0.0.1/1.1.0/0.1.0") {
                assertThat(listOf(listOf(true, false, false), listOf(false, true, true), listOf(false, true, false)).rotate())
                    .isEqualTo(listOf(listOf(false, false, true), listOf(true, true, false), listOf(false, true, false)))
            }
        }
    }
    given("Join square is a function that flattens 2d lists of 2d lists to 2d lists") {
        on("[[[[1,2],[3,4],[[2]]],[[[3]],[[4]]]") {
            it("[[1,2],[3,4]]") {
                assertThat(listOf(listOf(listOf(listOf(1, 2), listOf(3, 4)), listOf(listOf(5, 6), listOf(7, 8))), listOf(listOf(listOf(9, 10), listOf(11, 12)), listOf(listOf(13, 14), listOf(15, 16)))).joinSquare())
                    .isEqualTo(listOf(listOf(1, 2, 5, 6), listOf(3, 4, 7, 8), listOf(9, 10, 13, 14), listOf(11, 12, 15, 16)))
            }
        }
    }
})
