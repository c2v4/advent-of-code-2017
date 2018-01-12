package com.c2v4.advent17

fun fractal(input: String, iterations: Int, startingPattern: String = ".#./" +
    "..#/" +
    "###"): Int = input
    .split('\n')
    .map { toRule(it) }
    .let { rules ->
        (0 until iterations).fold(toPattern(startingPattern), { acc, _ ->
            nextState(acc, rules)
        })
    }.cardinality()

private fun Iterable<Iterable<Boolean>>.cardinality(): Int = this.sumBy { it.count { it } }


fun nextState(state: List<List<Boolean>>, rules: List<Rule>): List<List<Boolean>> = state.let {
    splitSquare(it, if (it.size % 2 == 0) 2 else 3)
}.map {
    it.map { chunk ->
        rules.find { chunk.matches(it.qualifier) or chunk.flip().matches(it.qualifier) }?.result ?: emptyList()
    }
}.joinSquare()

private fun <T> List<List<T>>.flip(): List<List<T>> = map { it.reversed() }

fun <T> splitSquare(input: List<List<T>>, chunkSize: Int) =
    input.chunked(chunkSize).map {
        var initial = emptyList<MutableList<List<T>>>()
        (0 until it[0].size/chunkSize).forEach { initial = initial.plusElement(mutableListOf()) }
        it.map { it.chunked(chunkSize) }.fold(initial,{ acc, list -> list.forEachIndexed({ index, list -> acc[index].add(list) })
        acc})
    }

fun <T> List<List<List<List<T>>>>.joinSquare() = flatMap {
    val initial = mutableListOf<MutableList<T>>()
    (0 until it[0].size).forEach { initial.add(mutableListOf()) }
    it.fold(initial,{ acc, list -> list.forEachIndexed({ index, list1 -> acc[index].addAll(list1) })
        acc})
}

fun toRule(input: String) = input.split(" => ").let { Rule(toPattern(it[0]), toPattern(it[1])) }

fun toPattern(input: String) = input.split('/').map { it.toCharArray().map { it == '#' } }

data class Rule(val qualifier: List<List<Boolean>>, val result: List<List<Boolean>>)

fun <T> List<List<T>>.rotate(): List<List<T>> = mapIndexed { index, _ -> this.map { it[index] } }.map { it.reversed() }

fun <T> List<List<T>>.matches(other: List<List<T>>): Boolean = (0..3).any {
    var temp = this
    (0 until it).forEach { temp = temp.rotate() }
    other == temp
}

fun main(args: Array<String>) {
    print(fractal("day21.txt".asResource(), 5))
}
