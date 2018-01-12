package com.c2v4.advent17

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day22PlusSpek : Spek({
    given("s you go to remove the virus from the infected nodes, it evolves to resist your attempt.\n" +
        "\n" +
        "Now, before it infects a clean node, it will weaken it to disable your defenses. If it encounters an infected node, it will instead flag the node to be cleaned in the future. So:\n" +
        "\n" +
        "Clean nodes become weakened.\n" +
        "Weakened nodes become infected.\n" +
        "Infected nodes become flagged.\n" +
        "Flagged nodes become clean.\n" +
        "Every node is always in exactly one of the above states.\n" +
        "\n" +
        "The virus carrier still functions in a similar way, but now uses the following logic during its bursts of action:\n" +
        "\n" +
        "Decide which way to turn based on the current node:\n" +
        "If it is clean, it turns left.\n" +
        "If it is weakened, it does not turn, and will continue moving in the same direction.\n" +
        "If it is infected, it turns right.\n" +
        "If it is flagged, it reverses direction, and will go back the way it came.\n" +
        "Modify the state of the current node, as described above.\n" +
        "The virus carrier moves forward one node in the direction it is facing.") {
        on("..#\n" +
            "#..\n" +
            "...") {
            it("Using the same initial state as the previous example, and drawing weakened as W and flagged as F, the middle of the infinite grid looks like this, with the virus carrier's position again marked with [ ]:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . # . . .\n" +
                ". . . #[.]. . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "This is the same as before, since no initial nodes are weakened or flagged. The virus carrier is on a clean node, so it still turns left, instead weakens the node, and moves left:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . # . . .\n" +
                ". . .[#]W . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "The virus carrier is on an infected node, so it still turns right, instead flags the node, and moves up:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . .[.]. # . . .\n" +
                ". . . F W . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "This process repeats three more times, ending on the previously-flagged node and facing right:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . W W . # . . .\n" +
                ". . W[F]W . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "Finding a flagged node, it reverses direction and cleans the node:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . W W . # . . .\n" +
                ". .[W]. W . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "The weakened node becomes infected, and it continues in the same direction:\n" +
                "\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . W W . # . . .\n" +
                ".[.]# . W . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                ". . . . . . . . .\n" +
                "Of the first 100 bursts, 26 will result in infection.") {
                assertThat(ant2("..#\n" +
                    "#..\n" +
                    "...", 100)).isEqualTo(26)
            }
            it("Unfortunately, another feature of this evolved virus is speed; of the first 10000000 bursts, 2511944 will result in infection.") {
                assertThat(ant2("..#\n" +
                    "#..\n" +
                    "...", 10000000)).isEqualTo(2511944)
            }
        }
    }
})
