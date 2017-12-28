package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day18Spek : Spek({
    given("You discover a tablet containing some strange assembly code labeled simply \"Duet\". Rather than bother the sound card with it, you decide to run the code yourself. Unfortunately, you don't see any documentation, so you're left to figure out what the instructions mean on your own.\n" +
        "\n" +
        "It seems like the assembly is meant to operate on a set of registers that are each named with a single letter and that can each hold a single integer. You suppose each register should start with a value of 0.\n" +
        "\n" +
        "There aren't that many instructions, so it shouldn't be hard to figure out what they do. Here's what you determine:\n" +
        "\n" +
        "snd X plays a sound with a frequency equal to the value of X.\n" +
        "set X Y sets register X to the value of Y.\n" +
        "add X Y increases register X by the value of Y.\n" +
        "mul X Y sets register X to the result of multiplying the value contained in register X by the value of Y.\n" +
        "mod X Y sets register X to the remainder of dividing the value contained in register X by the value of Y (that is, it sets X to the result of X modulo Y).\n" +
        "rcv X recovers the frequency of the last sound played, but only when the value of X is not zero. (If it is zero, the command does nothing.)\n" +
        "jgz X Y jumps with an offset of the value of Y, but only if the value of X is greater than zero. (An offset of 2 skips the next instruction, an offset of -1 jumps to the previous instruction, and so on.)\n" +
        "Many of the instructions can take either a register (a single letter) or a number. The value of a register is the integer it contains; the value of a number is that number.\n" +
        "\n" +
        "After each jump instruction, the program continues with the instruction to which the jump jumped. After any other instruction, the program continues with the next instruction. Continuing (or jumping) off either end of the program terminates it.") {
        on("set a 1\n" +
            "add a 2\n" +
            "mul a a\n" +
            "mod a 5\n" +
            "snd a\n" +
            "set a 0\n" +
            "rcv a\n" +
            "jgz a -1\n" +
            "set a 1\n" +
            "jgz a -2\n") {
            it("The first four instructions set a to 1, add 2 to it, square it, and then set it to itself modulo 5, resulting in a value of 4.\n" +
                "Then, a sound with frequency 4 (the value of a) is played.\n" +
                "After that, a is set to 0, causing the subsequent rcv and jgz instructions to both be skipped (rcv because a is 0, and jgz because a is not greater than 0).\n" +
                "Finally, a is set to 1, causing the next jgz instruction to activate, jumping back two instructions to another jump, which jumps again to the rcv, which ultimately triggers the recover operation.\n" +
                "At the time the recover operation is executed, the frequency of the last sound played is 4.") {
                Assertions.assertThat(duet("set a 1\n" +
                    "add a 2\n" +
                    "mul a a\n" +
                    "mod a 5\n" +
                    "snd a\n" +
                    "set a 0\n" +
                    "rcv a\n" +
                    "jgz a -1\n" +
                    "set a 1\n" +
                    "jgz a -2\n")).isEqualTo(4)
            }
        }
    }
})
