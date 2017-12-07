package com.c2v4.advent17

fun tower2(input: String): Any =
        split(input)
                .let {
                    it.map { (first) ->
                        createDisc(first, it)
                    }
                }
                .filter { it.children.map { child -> calculateWeight(child) }.distinct().size > 1 }
                .let { list ->
                    list.filter { element ->
                        element.children.map { it.name }.intersect(list.map { it.name }).isEmpty()
                    }
                }
                .first().children.map { it to calculateWeight(it) }
                .let { children ->
                    val map = children.map { it.second }.groupingBy { it }.eachCount()
                    children.find { it.second == map.entries.find { it.value == 1 }?.key ?: 0 }?.let { it.first.ownWeight - it.second + map.entries.filterNot { it.value == 1 }.first().key } ?: 0//
                }

fun split(input: String): List<Triple<String, Int, List<String>>> = input.split('\n').map { it.trim() }.map {
    val split = it.split(" -> ")
    Triple(split[0].split(" ")[0],
            split[0].split(" ")[1].strip().toInt(),
            if (split.size > 1) split[1].split(", ") else emptyList())
}

private data class Disc(val name: String, val ownWeight: Int, val children: List<Disc>)

private fun calculateWeight(disc: Disc): Int = disc.ownWeight + disc.children.map {
    calculateWeight(it)
}.sum()

private fun createDisc(name: String,
                       tower: List<Triple<String, Int, List<String>>>): Disc =
        Disc(name,
                tower.find { it.first == name }?.second ?: 0,
                tower.find { it.first == name }?.third?.map {
                    createDisc(it,
                            tower)
                } ?: emptyList())


fun main(args: Array<String>) {
    print(tower2("day7.txt".asResource()))
}