package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day13Spek : Spek({
    given("By studying the firewall briefly, you are able to record (in your puzzle input) the depth of each layer and the range of the scanning area for the scanner within it, written as depth: range. Each layer has a thickness of exactly 1. A layer at depth 0 begins immediately inside the firewall; a layer at depth 1 would start immediately after that.\n" +
            "\n" +
            "For example, suppose you've recorded the following:\n" +
            "\n" +
            "0: 3\n" +
            "1: 2\n" +
            "4: 4\n" +
            "6: 4\n" +
            "This means that there is a layer immediately inside the firewall (with range 3), a second layer immediately after that (with range 2), a third layer which begins at depth 4 (with range 4), and a fourth layer which begins at depth 6 (also with range 4). Visually, it might look like this:\n" +
            "\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [ ] ... ... [ ] ... [ ]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "Within each layer, a security scanner moves back and forth within its range. Each security scanner starts at the top and moves down until it reaches the bottom, then moves up until it reaches the top, and repeats. A security scanner takes one picosecond to move one step. Drawing scanners as S, the first few picoseconds look like this:\n" +
            "\n" +
            "\n" +
            "Picosecond 0:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[S] [S] ... ... [S] ... [S]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            "Picosecond 1:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [ ] ... ... [ ] ... [ ]\n" +
            "[S] [S]         [S]     [S]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            "Picosecond 2:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [S] ... ... [ ] ... [ ]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[S]             [S]     [S]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            "Picosecond 3:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [ ] ... ... [ ] ... [ ]\n" +
            "[S] [S]         [ ]     [ ]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [S]     [S]\n" +
            "Your plan is to hitch a ride on a packet about to move through the firewall. The packet will travel along the top of each layer, and it moves at one layer per picosecond. Each picosecond, the packet moves one layer forward (its first move takes it into layer 0), and then the scanners move one step. If there is a scanner at the top of the layer as your packet enters it, you are caught. (If a scanner moves into the top of its layer while you are there, you are not caught: it doesn't have time to notice you before you leave.) If you were to do this in the configuration above, marking your current position with parentheses, your passage through the firewall would look like this:\n" +
            "\n" +
            "Initial state:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[S] [S] ... ... [S] ... [S]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            "Picosecond 0:\n" +
            " 0   1   2   3   4   5   6\n" +
            "(S) [S] ... ... [S] ... [S]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            " 0   1   2   3   4   5   6\n" +
            "( ) [ ] ... ... [ ] ... [ ]\n" +
            "[S] [S]         [S]     [S]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            "\n" +
            "Picosecond 1:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] ( ) ... ... [ ] ... [ ]\n" +
            "[S] [S]         [S]     [S]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] (S) ... ... [ ] ... [ ]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[S]             [S]     [S]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            "\n" +
            "Picosecond 2:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [S] (.) ... [ ] ... [ ]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[S]             [S]     [S]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [ ] (.) ... [ ] ... [ ]\n" +
            "[S] [S]         [ ]     [ ]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [S]     [S]\n" +
            "\n" +
            "\n" +
            "Picosecond 3:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [ ] ... (.) [ ] ... [ ]\n" +
            "[S] [S]         [ ]     [ ]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [S]     [S]\n" +
            "\n" +
            " 0   1   2   3   4   5   6\n" +
            "[S] [S] ... (.) [ ] ... [ ]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[ ]             [S]     [S]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            "\n" +
            "Picosecond 4:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[S] [S] ... ... ( ) ... [ ]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[ ]             [S]     [S]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [ ] ... ... ( ) ... [ ]\n" +
            "[S] [S]         [S]     [S]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            "\n" +
            "Picosecond 5:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [ ] ... ... [ ] (.) [ ]\n" +
            "[S] [S]         [S]     [S]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [S] ... ... [S] (.) [S]\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[S]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            "\n" +
            "Picosecond 6:\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [S] ... ... [S] ... (S)\n" +
            "[ ] [ ]         [ ]     [ ]\n" +
            "[S]             [ ]     [ ]\n" +
            "                [ ]     [ ]\n" +
            "\n" +
            " 0   1   2   3   4   5   6\n" +
            "[ ] [ ] ... ... [ ] ... ( )\n" +
            "[S] [S]         [S]     [S]\n" +
            "[ ]             [ ]     [ ]\n" +
            "                [ ]     [ ]") {
        on("0: 3\n" +
                "1: 2\n" +
                "4: 4\n" +
                "6: 4") {
            it("In this situation, you are caught in layers 0 and 6, because your packet entered the layer when its scanner was at the top when you entered it. You are not caught in layer 1, since the scanner moved into the top of the layer once you were already there.\n" +
                    "\n" +
                    "The severity of getting caught on a layer is equal to its depth multiplied by its range. (Ignore layers in which you do not get caught.) The severity of the whole trip is the sum of these values. In the example above, the trip severity is 0*3 + 6*4 = 24.") {
                Assertions.assertThat(scanner("0: 3\n" +
                        "1: 2\n" +
                        "4: 4\n" +
                        "6: 4")).isEqualTo(24)
            }
        }
    }
})