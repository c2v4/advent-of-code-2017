package com.c2v4.advent17

import java.lang.Math.*

fun spiral(n: Int): Int {
    val k = ceil((sqrt(n.toDouble()) - 1) / 2)
    var t = 2 * k + 1
    var m = Math.pow(t, 2.0)
    t -= 1
    if (n >= m - t) return (abs(k - (m - n)) + abs(-k)).toInt()
    else m -= t
    if (n >= m - t) return (abs(-k) + abs(-k + (m - n))).toInt()
    else m -= t
    if (n >= m - t) return (abs(-k + (m - n)) + abs(k)).toInt()
    else return (abs(k) + abs(k - (m - n - t))).toInt()
}


fun main(args: Array<String>) {
    print(spiral("day3.txt".asResource().toInt()))
}
