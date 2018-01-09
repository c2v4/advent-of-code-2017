package com.c2v4.advent17

fun particles(input: String): Int = input.split('\n')
    .map { toParticle(it) }
    .withIndex()
    .let { it }
    .minBy { it.value.acceleration.manhattan() }
    ?.index ?: 0

val numberPattern = Regex("-?\\d+")

fun toParticle(input: String) = input.split(">,")
    .map { numberPattern.findAll(it).toList() }
    .map { it.map { it.value } }
    .map { Point3(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
    .let { Particle(it[0], it[1], it[2]) }

data class Point3(val x: Int, val y: Int, val z: Int)

fun Point3.manhattan(): Int = (x * x) + (y * y) + (z * z)

data class Particle(val position: Point3, val velocity: Point3, val acceleration: Point3)

//p=<3020,-168,-204>, v=<431,-24,-25>, a=<-32,2,5>

fun main(args: Array<String>) {
    print(particles("day20.txt".asResource()))
}
