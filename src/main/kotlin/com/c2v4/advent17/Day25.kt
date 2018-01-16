package com.c2v4.advent17

import com.c2v4.advent17.Direction25.LEFT
import com.c2v4.advent17.Direction25.RIGHT

fun turing(iterations: Int): Int = (0 until iterations)
    .fold(Result(states['A']!!, mutableSetOf(),0),{ acc, _ ->
        val action =
        if(acc.ones.contains(acc.currentPosition))
            acc.currentState.action1
        else
            acc.currentState.action0

        if(action.write){
            acc.ones.add(acc.currentPosition)
        }else{
            acc.ones.remove(acc.currentPosition)
        }

        acc.currentPosition+=action.move.modify

        acc.currentState= states[action.newState]!!

        acc
    }).ones.size

data class Result(var currentState: State, val ones:MutableSet<Int>, var currentPosition:Int)

val states = mapOf(
    'A' to State(
        Action(true, RIGHT,'B'),
        Action(false, LEFT,'F')
    ),
    'B' to State(
        Action(false, RIGHT,'C'),
        Action(false, RIGHT,'D')
    ),
    'C' to State(
        Action(true, LEFT,'D'),
        Action(true, RIGHT,'E')
    ),
    'D' to State(
        Action(false, LEFT,'E'),
        Action(false, LEFT,'D')
    ),
    'E' to State(
        Action(false, RIGHT,'A'),
        Action(true, RIGHT,'C')
    ),
    'F' to State(
        Action(true, LEFT,'A'),
        Action(false, RIGHT,'A')
    )
)
/*
Begin in state A.
Perform a diagnostic checksum after 12794428 steps.
 */
data class State(val action0:Action,val action1:Action)

data class Action(val write:Boolean, val move:Direction25,val newState:Char)

enum class Direction25(val modify: Int) {
    LEFT(-1),RIGHT(1)
}
fun main(args: Array<String>) {
    print(turing(12794428))
}
