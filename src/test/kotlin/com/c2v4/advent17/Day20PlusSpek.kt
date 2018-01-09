package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day20PlusSpek : Spek({
    given("To simplify the problem further, the GPU would like to remove any particles that collide. Particles collide if their positions ever exactly match. Because particles are updated simultaneously, more than two particles can collide at the same time and place. Once particles collide, they are removed and cannot collide with anything else after that tick.") {
        on("p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>\n" +
            "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>\n" +
            "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>\n" +
            "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>") {
            it("For example:\n" +
                "\n" +
                "p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>    \n" +
                "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>    -6 -5 -4 -3 -2 -1  0  1  2  3\n" +
                "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>    (0)   (1)   (2)            (3)\n" +
                "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>\n" +
                "\n" +
                "p=<-3,0,0>, v=< 3,0,0>, a=< 0,0,0>    \n" +
                "p=<-2,0,0>, v=< 2,0,0>, a=< 0,0,0>    -6 -5 -4 -3 -2 -1  0  1  2  3\n" +
                "p=<-1,0,0>, v=< 1,0,0>, a=< 0,0,0>             (0)(1)(2)      (3)   \n" +
                "p=< 2,0,0>, v=<-1,0,0>, a=< 0,0,0>\n" +
                "\n" +
                "p=< 0,0,0>, v=< 3,0,0>, a=< 0,0,0>    \n" +
                "p=< 0,0,0>, v=< 2,0,0>, a=< 0,0,0>    -6 -5 -4 -3 -2 -1  0  1  2  3\n" +
                "p=< 0,0,0>, v=< 1,0,0>, a=< 0,0,0>                       X (3)      \n" +
                "p=< 1,0,0>, v=<-1,0,0>, a=< 0,0,0>\n" +
                "\n" +
                "------destroyed by collision------    \n" +
                "------destroyed by collision------    -6 -5 -4 -3 -2 -1  0  1  2  3\n" +
                "------destroyed by collision------                      (3)         \n" +
                "p=< 0,0,0>, v=<-1,0,0>, a=< 0,0,0>\n" +
                "In this example, particles 0, 1, and 2 are simultaneously destroyed at the time and place marked X. On the next tick, particle 3 passes through unharmed.") {
                Assertions.assertThat(particles2("p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>\n" +
                    "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>\n" +
                    "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>\n" +
                    "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>")).isEqualTo(1)
            }
        }
    }
})
