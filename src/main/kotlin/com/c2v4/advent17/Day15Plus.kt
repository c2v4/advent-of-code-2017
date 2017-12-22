package com.c2v4.advent17

fun generator2(input: String,
               genAMultiplier: Int = 16807,
               genBMultiplier: Int = 48271,
               divisor: Long = 2_147_483_647,
               genADivisor: Int = 4,
               genBDivisor: Int = 8,
               numberOfSamples: Long = 5_000_000): Int =
    input.split('\n').map { it.split(Regex("\\s")).last().toLong() }.let {
        (0 until numberOfSamples).fold(it[0] to it[1] to 0, { (generators, score), _ ->
            var genA = generators.first.times(genAMultiplier).rem(divisor)
            while ((genA % genADivisor) != 0L) genA = genA.times(genAMultiplier).rem(divisor)
            var genB = generators.second.times(genBMultiplier).rem(divisor)
            while ((genB % genBDivisor) != 0L) genB = genB.times(genBMultiplier).rem(divisor)
            genA to genB to
                (score +
                    if (genA.and(0xFFFF) == genB.and(0xFFFF)) 1 else 0)
        }).second
    }

fun main(args: Array<String>) {
    print(generator2("day15.txt".asResource().trim()))
}
