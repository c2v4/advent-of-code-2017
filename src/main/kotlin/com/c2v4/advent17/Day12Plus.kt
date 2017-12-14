package com.c2v4.advent17


fun graph2(input: String): Int =
        buildGraph(input)
                .let { graph ->
                    graph.nodes().fold(emptySet<Set<Int>>(),{ acc, i ->
                        acc.plusElement(multilevelSuccessors(graph, emptySet(),i))
                    })
                }
                .size


fun main(args: Array<String>) {
    print(graph2("day12.txt".asResource()))
}