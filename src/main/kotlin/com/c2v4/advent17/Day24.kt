package com.c2v4.advent17

import com.google.common.graph.Graph
import com.google.common.graph.GraphBuilder

fun bridge(input: String): Int = GraphBuilder.undirected().allowsSelfLoops(true).build<Int>()
    .also { graph -> input.split('\n').map { it.split('/') }.forEach { graph.putEdge(it.first().toInt(), it.last().toInt()) } }
    ?.let { var state = emptySet<List<Pair<Int, Int>>>()
        var newState = setOf(listOf(0 to 0))
        while(state!=newState){
            state = newState
            newState = expand(it,state)
        }
        state
    }?.maxBy {
    path -> path.sumBy {  (first,second) -> first+second } }.let { it?.sumBy { it.second + it.first }
}?:0


fun expand(graph: Graph<Int>, soFar: Set<List<Pair<Int, Int>>>): Set<List<Pair<Int, Int>>> = (soFar + soFar.flatMap { path ->
    graph.adjacentNodes(path.last().second).filterNot {
        path.contains(it to path.last().second) or path.contains(path.last().second to it)
    }.map {
        path.plusElement((path.last().second to (it?:-1)))
    }
})

fun main(args: Array<String>) {
    print(bridge("day24.txt".asResource().trim()))
}
