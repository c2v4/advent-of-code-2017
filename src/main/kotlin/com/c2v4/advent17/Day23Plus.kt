package com.c2v4.advent17

import com.google.common.math.IntMath.isPrime

fun cocpu2(b:Int):Int = ((b+1000)*100).let {
    it..(it+17000) step 17
}.count { !isPrime(it) }


fun main(args: Array<String>) {
    print(cocpu2("day23.txt".asResource().trim().split('\n').first().takeLast(2).toInt()))
}
