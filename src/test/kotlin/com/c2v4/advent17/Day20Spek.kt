package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day20Spek : Spek({
    given("Suddenly, the GPU contacts you, asking for help. Someone has asked it to simulate too many particles, and it won't be able to finish them all in time to render the next frame at this rate.\n" +
        "\n" +
        "It transmits to you a buffer (your puzzle input) listing each particle in order (starting with particle 0, then particle 1, particle 2, and so on). For each particle, it provides the X, Y, and Z coordinates for the particle's position (p), velocity (v), and acceleration (a), each in the format <X,Y,Z>.\n" +
        "\n" +
        "Each tick, all particles are updated simultaneously. A particle's properties are updated in the following order:\n" +
        "\n" +
        "Increase the X velocity by the X acceleration.\n" +
        "Increase the Y velocity by the Y acceleration.\n" +
        "Increase the Z velocity by the Z acceleration.\n" +
        "Increase the X position by the X velocity.\n" +
        "Increase the Y position by the Y velocity.\n" +
        "Increase the Z position by the Z velocity.\n" +
        "Because of seemingly tenuous rationale involving z-buffering, the GPU would like to know which particle will stay closest to position <0,0,0> in the long term. Measure this using the Manhattan distance, which in this situation is simply the sum of the absolute values of a particle's X, Y, and Z position.\n" +
        "\n" +
        "For example, suppose you are only given two particles, both of which stay entirely on the X-axis (for simplicity). Drawing the current states of particles 0 and 1 (in that order) with an adjacent a number line and diagram of current X positions (marked in parenthesis), the following would take place:") {
        on("p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0> " +
            "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0> ") {
            it("p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4\n" +
                "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>                         (0)(1)\n" +
                "\n" +
                "p=< 4,0,0>, v=< 1,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4\n" +
                "p=< 2,0,0>, v=<-2,0,0>, a=<-2,0,0>                      (1)   (0)\n" +
                "\n" +
                "p=< 4,0,0>, v=< 0,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4\n" +
                "p=<-2,0,0>, v=<-4,0,0>, a=<-2,0,0>          (1)               (0)\n" +
                "\n" +
                "p=< 3,0,0>, v=<-1,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4\n" +
                "p=<-8,0,0>, v=<-6,0,0>, a=<-2,0,0>                         (0)   \n" +
                "At this point, particle 1 will never be closer to <0,0,0> than particle 0, and so, in the long run, particle 0 will stay closest.") {
                Assertions.assertThat(particles("p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0> " +
                    "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0> ")).isEqualTo(0)
            }
        }
    }
})
