package com.c2v4.advent17

fun defrag2(input: String): Int = buildGrid(input)
    .let { grid ->
        (0..127)
            .flatMap { row -> (0..127).map { row to it } }
            .filter { grid[it.first][it.second] }
            .fold(emptySet<Pair<Int, Int>>() to 0, { (alreadyVisited, numberOfGroups), pair ->
                if (alreadyVisited.contains(pair)) return@fold alreadyVisited to numberOfGroups
                alreadyVisited.plus(findGroup(grid, pair, emptySet())) to numberOfGroups + 1
            })
            .second
    }

fun findGroup(grid: List<List<Boolean>>,
              pair: Pair<Int, Int>,
              visited: Set<Pair<Int, Int>>): Set<Pair<Int, Int>> {
    if (visited.contains(pair) ||
        pair.first < 0 ||
        pair.second < 0 ||
        pair.first >= grid.size ||
        pair.second >= grid.size ||
        !grid[pair.first][pair.second]) return emptySet()
    val withPair = visited.plus(pair)
    val withLeft = withPair
        .plus(findGroup(grid, pair.first - 1 to pair.second, withPair))
    val withRight = withLeft
        .plus(findGroup(grid, pair.first + 1 to pair.second, withLeft))
    val withUp = withRight
        .plus(findGroup(grid, pair.first to pair.second - 1, withRight))
    return withUp
        .plus(findGroup(grid, pair.first to pair.second + 1, withUp))
}

private fun buildGrid(input: String) =
    (0..127)
        .map { bitHash(input.trim() + "-" + it) }
        .map { it.fold(emptyList<Boolean>(), { acc, i -> acc.plus(i.toBooleanArray(8)) }) }
        .fold(emptyList<List<Boolean>>(), { acc, list -> acc.plusElement(list) })

fun Int.toBooleanArray(minLength: Int) = this.toString(2).padStart(minLength,
    '0').toCharArray().map { it == '1' }

fun main(args: Array<String>) {
    print(defrag2("day14.txt".asResource()))
}
