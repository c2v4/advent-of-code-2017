package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day10Spek : Spek({
    given("You come across some programs that are trying to implement a software emulation of a hash based on knot-tying. The hash these programs are implementing isn't very strong, but you decide to help them anyway. You make a mental note to remind the Elves later not to invent their own cryptographic functions.\n" +
            "\n" +
            "This hash function simulates tying a knot in a circle of string with 256 marks on it. Based on the input to be hashed, the function repeatedly selects a span of string, brings the ends together, and gives the span a half-twist to reverse the order of the marks within it. After doing this many times, the order of the marks is used to build the resulting hash.\n" +
            "\n" +
            "  4--5   pinch   4  5           4   1\n" +
            " /    \\  5,0,1  / \\/ \\  twist  / \\ / \\\n" +
            "3      0  -->  3      0  -->  3   X   0\n" +
            " \\    /         \\ /\\ /         \\ / \\ /\n" +
            "  2--1           2  1           2   5\n" +
            "To achieve this, begin with a list of numbers from 0 to 255, a current position which begins at 0 (the first element in the list), a skip size (which starts at 0), and a sequence of lengths (your puzzle input). Then, for each length:\n" +
            "\n" +
            "Reverse the order of that length of elements in the list, starting with the element at the current position.\n" +
            "Move the current position forward by that length plus the skip size.\n" +
            "Increase the skip size by one.\n" +
            "The list is circular; if the current position and the length try to reverse elements beyond the end of the list, the operation reverses using as many extra elements as it needs from the front of the list. If the current position moves past the end of the list, it wraps around to the front. Lengths larger than the size of the list are invalid.") {
        on("list 0, 1, 2, 3, 4 and input 3") {
            it("produces 2 1 0 [3] 4. Finally, the skip size increases to 1") {
                Assertions.assertThat(reduceHashState(HashState((0 until 5).toList()),
                        3)).isEqualTo(HashState(
                        listOf(2, 1, 0, 3, 4), 3, 1))
            }
        }
        on("list 2 1 0 [3] 4, skipSize 1  and input 4") {
            it("4 3 0 [1] 2. The skip size increases to 2") {
                Assertions.assertThat(reduceHashState(HashState(
                        listOf(2, 1, 0, 3, 4), 3, 1),
                        4)).isEqualTo(HashState(
                        listOf(4, 3, 0, 1, 2), 3, 2))
            }
        }
        on("list 4 3 0 [1] 2, skipSize 2  and input 1") {
            it("The third length, 1, selects a sublist of a single element, and so reversing it has no effect.\n" +
                    "The current position moves forward by the length (1) plus the skip size (2): 4 [3] 0 1 2. The skip size increases to 3.") {
                Assertions.assertThat(reduceHashState(HashState(
                        listOf(4, 3, 0, 1, 2), 3, 2),
                        1)).isEqualTo(HashState(
                        listOf(4, 3, 0, 1, 2), 1, 3))
            }
        }
        on("4 [3] 0 1 2  skip size  3 and input 5") {
            it("The fourth length, 5, selects every element starting with the second: 4) ([3] 0 1 2. Reversing this sublist (3 0 1 2 4 into 4 2 1 0 3) produces: 3) ([4] 2 1 0.\n" +
                    "Finally, the current position moves forward by 8: 3 4 2 1 [0]. The skip size increases to 4.") {
                Assertions.assertThat(reduceHashState(HashState(
                        listOf(4, 3, 0, 1, 2), 1, 3),
                        5)).isEqualTo(HashState(
                        listOf(3, 4, 2, 1, 0), 4, 4))
            }
        }
        on("list size of 5 and input 3, 4, 1, 5") {
            it("product of first two numbers is 12") {
                Assertions.assertThat(hash(5, "3,4,1,5")).isEqualTo(12)
            }
        }
    }
})