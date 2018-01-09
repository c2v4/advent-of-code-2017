package com.c2v4.advent17

import kotlin.math.sign

fun particles2(input: String): Int = input.split('\n')
    .map { toParticle(it) }
    .let {
        var temp = it.distinctBy { it.position }
        while (temp.any { !it.asymptotic() }) {
            temp = temp.map { it.next() }.groupBy { it.position }.entries.filter { it.value.size==1 }.map { it.value[0] }
        }
        temp
    }.size

operator fun Point3.plus(another: Point3): Point3 = Point3(x + another.x, y + another.y, z + another.z)

fun Point3.signMatch(another: Point3) =
    (x == 0 || x.sign == another.x.sign) &&
        (y == 0 || y.sign == another.y.sign) &&
        (z == 0 || z.sign == another.z.sign)

fun Particle.asymptotic() = acceleration.signMatch(velocity) && velocity.signMatch(position)

fun Particle.next(): Particle = Particle(position + velocity + acceleration, acceleration + velocity, acceleration)

fun main(args: Array<String>) {
    print(particles2("day20.txt".asResource()))
}
