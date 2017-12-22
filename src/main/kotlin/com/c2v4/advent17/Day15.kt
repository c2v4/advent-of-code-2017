package com.c2v4.advent17

fun generator(input: String,
              genAMultiplier: Int = 16807,
              genBMultiplier: Int = 48271,
              divisor: Long = 2_147_483_647,
              numberOfSamples: Long = 40_000_000): Any =
    input.split('\n').map { it.split(Regex("\\s")).last().toLong() }.let {
        (0 until numberOfSamples).fold(it[0] to it[1] to 0, { (generators, score), _ ->
            val genA = generators.first.times(genAMultiplier).rem(divisor)
            val genB = generators.second.times(genBMultiplier).rem(divisor)
            genA to genB to
                (score +
                    if (generators.first.and(0xFFFF) == generators.second.and(0xFFFF)) 1 else 0)
        }).second
    }

fun main(args: Array<String>) {
    print(generator("day15.txt".asResource().trim()))
}
