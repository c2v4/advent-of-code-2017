package com.c2v4.advent17

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given

object Day23Spek : Spek({
    given("You decide to head directly to the CPU and fix the printer from there. As you get close, you find an experimental coprocessor doing so much work that the local programs are afraid it will halt and catch fire. This would cause serious issues for the rest of the computer, so you head in and see what you can do.\n" +
        "\n" +
        "The code it's running seems to be a variant of the kind you saw recently on that tablet. The general functionality seems very similar, but some of the instructions are different:\n" +
        "\n" +
        "set X Y sets register X to the value of Y.\n" +
        "sub X Y decreases register X by the value of Y.\n" +
        "mul X Y sets register X to the result of multiplying the value contained in register X by the value of Y.\n" +
        "jnz X Y jumps with an offset of the value of Y, but only if the value of X is not zero. (An offset of 2 skips the next instruction, an offset of -1 jumps to the previous instruction, and so on.)\n" +
        "Only the instructions listed above are used. The eight registers here, named a through h, all start at 0.\n" +
        "\n" +
        "The coprocessor is currently set to some kind of debug mode, which allows for testing, but prevents it from doing any meaningful work.") {
    }
})
