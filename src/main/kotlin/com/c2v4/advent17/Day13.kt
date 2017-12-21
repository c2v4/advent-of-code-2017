package com.c2v4.advent17

fun scanner(input: String): Int =
        buildFirewall(input).let { 0..(it.grid.keys.max()?:0) to it }.let { (range, firewall) ->
            range.fold(firewall to 0,
            { (firewall, result), i ->
                val newResult = result +
                    if (firewall.scannersPositions[i] == 0) firewall.grid[i]?.plus(1)?.times(i) ?: 0 else 0
                firewall.step()
                firewall to newResult
            })
        }.second

fun buildFirewall(input: String): Firewall =
        input.split('\n').map { it.trim() }.map { it.split(": ") }
          .map { it[0].toInt() to it[1].toInt()-1 }.toMap().let { Firewall(it) }

data class Firewall(val grid: Map<Int, Int>) {
    val scannersPositions = grid.keys.map { it to 0 }.toMutableMap()
    private val directions = grid.keys.map { it to false }.toMutableMap()

    fun step() {
        scannersPositions.forEach { t, u ->
            if (directions[t] ?: true) {
                if (scannersPositions[t] == 0) {
                    scannersPositions.put(t, 1)
                    directions.put(t, false)
                } else {
                    scannersPositions.put(t, scannersPositions.getOrDefault(t, 0) - 1)
                }
            } else {
                if (scannersPositions[t] == grid[t]) {
                    scannersPositions.put(t, grid[t]?.minus(1) ?: 0)
                    directions.put(t, true)
                } else {
                    scannersPositions.put(t, scannersPositions.getOrDefault(t, 0) + 1)
                }
            }
        }
    }
}

private fun <K, V> Iterable<Pair<K, V>>.toMutableMap(): MutableMap<K, V> = this.toMap().toMutableMap()

fun main(args: Array<String>) {
    print(scanner("day13.txt".asResource()))
}
