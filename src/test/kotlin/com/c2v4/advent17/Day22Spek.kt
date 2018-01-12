package com.c2v4.advent17

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day22Spek : Spek({
    given("Diagnostics indicate that the local grid computing cluster has been contaminated with the Sporifica Virus. The grid computing cluster is a seemingly-infinite two-dimensional grid of compute nodes. Each node is either clean or infected by the virus.\n" +
        "\n" +
        "To prevent overloading the nodes (which would render them useless to the virus) or detection by system administrators, exactly one virus carrier moves through the network, infecting or cleaning nodes as it moves. The virus carrier is always located on a single node in the network (the current node) and keeps track of the direction it is facing.\n" +
        "\n" +
        "To avoid detection, the virus carrier works in bursts; in each burst, it wakes up, does some work, and goes back to sleep. The following steps are all executed in order one time each burst:\n" +
        "\n" +
        "If the current node is infected, it turns to its right. Otherwise, it turns to its left. (Turning is done in-place; the current node does not change.)\n" +
        "If the current node is clean, it becomes infected. Otherwise, it becomes cleaned. (This is done after the node is considered for the purposes of changing direction.)\n" +
        "The virus carrier moves forward one node in the direction it is facing.\n" +
        "Diagnostics have also provided a map of the node infection status (your puzzle input). Clean nodes are shown as .; infected nodes are shown as #. This map only shows the center of the grid; there are many more nodes beyond those shown, but none of them are currently infected.\n" +
        "\n" +
        "The virus carrier begins in the middle of the map facing up.") {
        on("..#\n" +
            "#..\n" +
            "...") {
            it("Then, the middle of the infinite grid looks like this, with the virus carrier's position marked with [ ]:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . # . . .\n" +
                ". . . #[.]. . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "The virus carrier is on a clean node, so it turns left, infects the node, and moves left:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . # . . .\n" +
                ". . .[#]# . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "The virus carrier is on an infected node, so it turns right, cleans the node, and moves up:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . .[.]. # . . .\n" +
                ". . . . # . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "Four times in a row, the virus carrier finds a clean, infects it, turns left, and moves forward, ending in the same place and still facing up:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . #[#]. # . . .\n" +
                ". . # # # . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "Now on the same node as before, it sees an infection, which causes it to turn right, clean the node, and move forward:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . # .[.]# . . .\n" +
                ". . # # # . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "After the above actions, a total of 7 bursts of activity had taken place. Of them, 5 bursts of activity caused an infection.\n" +
                "\n" +
                "After a total of 70, the grid looks like this, with the virus carrier facing up:\n" +
                "\n" +
                ". . . . . # # . .\n" +
                ". . . . # . . # .\n" +
                ". . . # . . . . #\n" +
                ". . # . #[.]. . #\n" +
                ". . # . # . . # .\n" +
                ". . . . . # # . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "By this time, 41 bursts of activity caused an infection (though most of those nodes have since been cleaned).\n") {
                assertThat(ant("..#\n" +
                    "#..\n" +
                    "...", 70)).isEqualTo(41)
            }
            it("After a total of 10000 bursts of activity, 5587 bursts will have caused an infection.") {
                assertThat(ant("..#\n" +
                    "#..\n" +
                    "...", 10000)).isEqualTo(5587)
            }
        }
    }
})
