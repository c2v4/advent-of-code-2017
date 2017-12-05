package com.c2v4.advent17

fun spiral2(n: Int): Int {
    var currentValue = 0
    val spiral = Spiral()
    while (n > currentValue) {
        currentValue = spiral.getNextValue()
    }
    return currentValue
}

private class Spiral {
    val nodes: MutableList<Node> = MutableList(1, { Node(0, 0, 1) })

    fun getNextValue(): Int {
        addNode()
        return nodes.last().value
    }

    private fun addNode() {
        nodes.add(getNewNode(nodes.last()))
    }

    private fun getNewNode(last: Node): Node {
        var newNode: Node? = null
        when {
            (last.x in (-last.y + 1)..last.y && last.y > 0) -> newNode = Node(last.x - 1,
                    last.y,
                    getNodeValue(last.x - 1,
                            last.y))
            (last.x in (last.y)..(-last.y) && last.y <= 0) -> newNode = Node(last.x + 1,
                    last.y,
                    getNodeValue(last.x + 1, last.y))
            (last.y in (-last.x + 1) until last.x && last.x > 0) -> newNode = Node(last.x,
                    last.y + 1,
                    getNodeValue(last.x,
                            last.y + 1))
            (last.y in (last.x + 1)..(-last.x) && last.x <= 0) -> newNode = Node(last.x,
                    last.y - 1,
                    getNodeValue(last.x, last.y - 1))
        }
        if (newNode == null) {
            throw IllegalStateException()
        }
        return newNode
    }

    private fun getNodeValue(x: Int, y: Int): Int {
        return ((x - 1)..(x + 1)).flatMap { currentX ->
            ((y - 1)..(y + 1)).flatMap { currentY ->
                nodes.filter { it.x == currentX && it.y == currentY }.map { it.value }
            }
        }.sum()
    }

}

private data class Node(val x: Int, val y: Int, val value: Int)

fun main(args: Array<String>) {
    print(spiral2("day3.txt".asResource().toInt()))
}