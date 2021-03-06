package com.c2v4.advent17

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day24Spek : Spek({
    given("The CPU itself is a large, black building surrounded by a bottomless pit. Enormous metal tubes extend outward from the side of the building at regular intervals and descend down into the void. There's no way to cross, but you need to get inside.\n" +
        "\n" +
        "No way, of course, other than building a bridge out of the magnetic components strewn about nearby.\n" +
        "\n" +
        "Each component has two ports, one on each end. The ports come in all different types, and only matching types can be connected. You take an inventory of the components by their port types (your puzzle input). Each port is identified by the number of pins it uses; more pins mean a stronger connection for your bridge. A 3/7 component, for example, has a type-3 port on one side, and a type-7 port on the other.\n" +
        "\n" +
        "Your side of the pit is metallic; a perfect surface to connect a magnetic, zero-pin port. Because of this, the first port you use must be of type 0. It doesn't matter what type of port you end with; your goal is just to make the bridge as strong as possible.\n" +
        "\n" +
        "The strength of a bridge is the sum of the port types in each component. For example, if your bridge is made of components 0/3, 3/7, and 7/4, your bridge has a strength of 0+3 + 3+7 + 7+4 = 24.") {

        on("For example, suppose you had the following components:" +
            "0/2\n" +
            "2/2\n" +
            "2/3\n" +
            "3/4\n" +
            "3/5\n" +
            "0/1\n" +
            "10/1\n" +
            "9/10"){
                it("With them, you could make the following valid bridges:\n" +
                    "\n" +
                    "0/1\n" +
                    "0/1--10/1\n" +
                    "0/1--10/1--9/10\n" +
                    "0/2\n" +
                    "0/2--2/3\n" +
                    "0/2--2/3--3/4\n" +
                    "0/2--2/3--3/5\n" +
                    "0/2--2/2\n" +
                    "0/2--2/2--2/3\n" +
                    "0/2--2/2--2/3--3/4\n" +
                    "0/2--2/2--2/3--3/5\n" +
                    "(Note how, as shown by 10/1, order of ports within a component doesn't matter. However, you may only use each port on a component once.)\n" +
                    "\n" +
                    "Of these bridges, the strongest one is 0/1--10/1--9/10; it has a strength of 0+1 + 1+10 + 10+9 = 31."){
                    assertThat(bridge("0/2\n" +
                        "2/2\n" +
                        "2/3\n" +
                        "3/4\n" +
                        "3/5\n" +
                        "0/1\n" +
                        "10/1\n" +
                        "9/10")).isEqualTo(31)
                }
        }
    }
})
