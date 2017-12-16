package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day7PlusSpec : Spek({
    given("For any program holding a disc, each program standing on that disc forms a sub-tower. Each of those sub-towers are supposed to be the same weight, or the disc itself isn't balanced. The weight of a tower is the sum of the weights of the programs in that tower." ) {
        on("pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "fwft (72) -> ktlj, cntj, xhth\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga, havc, qoyq\n" +
                "tknk (41) -> ugml, padx, fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo, ebii, jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)" ) {
            it("In the example above, this means that for ugml's disc to be balanced, gyxo, ebii, and jptl must all have the same weight, and they do: 61.\n" +
                    "\n" +
                    "However, for tknk to be balanced, each of the programs standing on its disc and all programs above it must each match. This means that the following sums must all be the same:\n" +
                    "\n" +
                    "ugml + (gyxo + ebii + jptl) = 68 + (61 + 61 + 61) = 251\n" +
                    "padx + (pbga + havc + qoyq) = 45 + (66 + 66 + 66) = 243\n" +
                    "fwft + (ktlj + cntj + xhth) = 72 + (57 + 57 + 57) = 243\n" +
                    "As you can see, tknk's disc is unbalanced: ugml's stack is heavier than the other two. Even though the nodes above ugml are balanced, ugml itself is too heavy: it needs to be 8 units lighter for its stack to weigh 243 and keep the towers balanced. If this change were made, its weight would be 60.") {
                Assertions.assertThat(tower2("pbga (66)\n" +
                        "xhth (57)\n" +
                        "ebii (61)\n" +
                        "havc (66)\n" +
                        "ktlj (57)\n" +
                        "fwft (72) -> ktlj, cntj, xhth\n" +
                        "qoyq (66)\n" +
                        "padx (45) -> pbga, havc, qoyq\n" +
                        "tknk (41) -> ugml, padx, fwft\n" +
                        "jptl (61)\n" +
                        "ugml (68) -> gyxo, ebii, jptl\n" +
                        "gyxo (61)\n" +
                        "cntj (57)")).isEqualTo(60)
            }
        }
    }
})