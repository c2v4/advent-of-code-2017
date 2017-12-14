package com.c2v4.advent17

import com.google.common.graph.Graph
import com.google.common.graph.GraphBuilder


fun graph(input: String): Any =
        input.split('\n')
                .map { it.trim() }
                .map { it.split(" <-> ") }
                .fold(GraphBuilder.undirected().allowsSelfLoops(true).build<Int>(), { acc, list ->
                    list.last().split(", ").forEach {
                        acc.putEdge(list.first().toInt(), it.toInt())
                    }
                    acc
                }).let { graph: Graph<Int> -> multilevelSuccessors(graph, emptySet(), 0) }.size

tailrec fun multilevelSuccessors(graph: Graph<Int>, acc: Set<Int>, i: Int): Set<Int> {
    if (acc.contains(i)) return acc
    return graph.successors(i).flatMap { multilevelSuccessors(graph, acc.plus(i), it) }.toSet()
}

fun main(args: Array<String>) {
    print(graph("day12.txt".asResource()))
}