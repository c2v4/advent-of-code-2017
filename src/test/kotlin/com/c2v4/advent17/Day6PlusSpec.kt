package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day6PlusSpec : Spek({
    given("Out of curiosity, the debugger would also like to know the size of the loop: starting from a state that has already been seen, how many block redistribution cycles must be performed before that same state is seen again?" ) {
        on("In the example above [0   2   7   0], 2 4 1 2 is seen again after four cycles" ) {
            it("and so the answer in that example would be 4") {
                Assertions.assertThat(debugger2("0   2   7   0")).isEqualTo(4)
            }
        }
    }
})