package com.c2v4.advent17

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given

object Day25Spek : Spek({
    given("Following the twisty passageways deeper and deeper into the CPU, you finally reach the core of the computer. Here, in the expansive central chamber, you find a grand apparatus that fills the entire room, suspended nanometers above your head.\n" +
        "\n" +
        "You had always imagined CPUs to be noisy, chaotic places, bustling with activity. Instead, the room is quiet, motionless, and dark.\n" +
        "\n" +
        "Suddenly, you and the CPU's garbage collector startle each other. \"It's not often we get many visitors here!\", he says. You inquire about the stopped machinery.\n" +
        "\n" +
        "\"It stopped milliseconds ago; not sure why. I'm a garbage collector, not a doctor.\" You ask what the machine is for.\n" +
        "\n" +
        "\"Programs these days, don't know their origins. That's the Turing machine! It's what makes the whole computer work.\" You try to explain that Turing machines are merely models of computation, but he cuts you off. \"No, see, that's just what they want you to think. Ultimately, inside every CPU, there's a Turing machine driving the whole thing! Too bad this one's broken. We're doomed!\"\n" +
        "\n" +
        "You ask how you can help. \"Well, unfortunately, the only way to get the computer running again would be to create a whole new Turing machine from scratch, but there's no way you can-\" He notices the look on your face, gives you a curious glance, shrugs, and goes back to sweeping the floor.\n" +
        "\n" +
        "You find the Turing machine blueprints (your puzzle input) on a tablet in a nearby pile of debris. Looking back up at the broken Turing machine above, you can start to identify its parts:\n" +
        "\n" +
        "A tape which contains 0 repeated infinitely to the left and right.\n" +
        "A cursor, which can move left or right along the tape and read or write values at its current position.\n" +
        "A set of states, each containing rules about what to do based on the current value under the cursor.\n" +
        "Each slot on the tape has two possible values: 0 (the starting value for all slots) and 1. Based on whether the cursor is pointing at a 0 or a 1, the current state says what value to write at the current position of the cursor, whether to move the cursor left or right one slot, and which state to use next.\n" +
        "\n" +
        "For example, suppose you found the following blueprint:\n" +
        "\n" +
        "Begin in state A.\n" +
        "Perform a diagnostic checksum after 6 steps.\n" +
        "\n" +
        "In state A:\n" +
        "  If the current value is 0:\n" +
        "    - Write the value 1.\n" +
        "    - Move one slot to the right.\n" +
        "    - Continue with state B.\n" +
        "  If the current value is 1:\n" +
        "    - Write the value 0.\n" +
        "    - Move one slot to the left.\n" +
        "    - Continue with state B.\n" +
        "\n" +
        "In state B:\n" +
        "  If the current value is 0:\n" +
        "    - Write the value 1.\n" +
        "    - Move one slot to the left.\n" +
        "    - Continue with state A.\n" +
        "  If the current value is 1:\n" +
        "    - Write the value 1.\n" +
        "    - Move one slot to the right.\n" +
        "    - Continue with state A.\n" +
        "Running it until the number of steps required to take the listed diagnostic checksum would result in the following tape configurations (with the cursor marked in square brackets):\n" +
        "\n" +
        "... 0  0  0 [0] 0  0 ... (before any steps; about to run state A)\n" +
        "... 0  0  0  1 [0] 0 ... (after 1 step;     about to run state B)\n" +
        "... 0  0  0 [1] 1  0 ... (after 2 steps;    about to run state A)\n" +
        "... 0  0 [0] 0  1  0 ... (after 3 steps;    about to run state B)\n" +
        "... 0 [0] 1  0  1  0 ... (after 4 steps;    about to run state A)\n" +
        "... 0  1 [1] 0  1  0 ... (after 5 steps;    about to run state B)\n" +
        "... 0  1  1 [0] 1  0 ... (after 6 steps;    about to run state A)\n" +
        "The CPU can confirm that the Turing machine is working by taking a diagnostic checksum after a specific number of steps (given in the blueprint). Once the specified number of steps have been executed, the Turing machine should pause; once it does, count the number of times 1 appears on the tape. In the above example, the diagnostic checksum is 3.\n" +
        "\n" +
        "Recreate the Turing machine and save the computer! What is the diagnostic checksum it produces once it's working again?"){
    }
})
