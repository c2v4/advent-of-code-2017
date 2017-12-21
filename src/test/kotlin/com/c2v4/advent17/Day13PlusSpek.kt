package com.c2v4.advent17

import org.assertj.core.api.Assertions
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object Day13PlusSpek : Spek({
    given("Now, you need to pass through the firewall without being caught - easier said than done.\n" +
        "You can't control the speed of the packet, but you can delay it any number of picoseconds. For each picosecond you delay the packet before beginning your trip, all security scanners move one step. You're not in the firewall during this time; you don't enter layer 0 until you stop delaying the packet.\n") {
        on("0: 3\n" +
            "1: 2\n" +
            "4: 4\n" +
            "6: 4") {
            it("\"In the example above, if you delay 10 picoseconds (picoseconds 0 - 9), you won't get caught:\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"State after delaying:\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[ ] [S] ... ... [ ] ... [ ]\\n\" +\n" +
                "        \"[ ] [ ]         [ ]     [ ]\\n\" +\n" +
                "        \"[S]             [S]     [S]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"Picosecond 10:\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"( ) [S] ... ... [ ] ... [ ]\\n\" +\n" +
                "        \"[ ] [ ]         [ ]     [ ]\\n\" +\n" +
                "        \"[S]             [S]     [S]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"( ) [ ] ... ... [ ] ... [ ]\\n\" +\n" +
                "        \"[S] [S]         [S]     [S]\\n\" +\n" +
                "        \"[ ]             [ ]     [ ]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"Picosecond 11:\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[ ] ( ) ... ... [ ] ... [ ]\\n\" +\n" +
                "        \"[S] [S]         [S]     [S]\\n\" +\n" +
                "        \"[ ]             [ ]     [ ]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[S] (S) ... ... [S] ... [S]\\n\" +\n" +
                "        \"[ ] [ ]         [ ]     [ ]\\n\" +\n" +
                "        \"[ ]             [ ]     [ ]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"Picosecond 12:\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[S] [S] (.) ... [S] ... [S]\\n\" +\n" +
                "        \"[ ] [ ]         [ ]     [ ]\\n\" +\n" +
                "        \"[ ]             [ ]     [ ]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[ ] [ ] (.) ... [ ] ... [ ]\\n\" +\n" +
                "        \"[S] [S]         [S]     [S]\\n\" +\n" +
                "        \"[ ]             [ ]     [ ]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"Picosecond 13:\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[ ] [ ] ... (.) [ ] ... [ ]\\n\" +\n" +
                "        \"[S] [S]         [S]     [S]\\n\" +\n" +
                "        \"[ ]             [ ]     [ ]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[ ] [S] ... (.) [ ] ... [ ]\\n\" +\n" +
                "        \"[ ] [ ]         [ ]     [ ]\\n\" +\n" +
                "        \"[S]             [S]     [S]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"Picosecond 14:\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[ ] [S] ... ... ( ) ... [ ]\\n\" +\n" +
                "        \"[ ] [ ]         [ ]     [ ]\\n\" +\n" +
                "        \"[S]             [S]     [S]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[ ] [ ] ... ... ( ) ... [ ]\\n\" +\n" +
                "        \"[S] [S]         [ ]     [ ]\\n\" +\n" +
                "        \"[ ]             [ ]     [ ]\\n\" +\n" +
                "        \"                [S]     [S]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"Picosecond 15:\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[ ] [ ] ... ... [ ] (.) [ ]\\n\" +\n" +
                "        \"[S] [S]         [ ]     [ ]\\n\" +\n" +
                "        \"[ ]             [ ]     [ ]\\n\" +\n" +
                "        \"                [S]     [S]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[S] [S] ... ... [ ] (.) [ ]\\n\" +\n" +
                "        \"[ ] [ ]         [ ]     [ ]\\n\" +\n" +
                "        \"[ ]             [S]     [S]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"Picosecond 16:\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[S] [S] ... ... [ ] ... ( )\\n\" +\n" +
                "        \"[ ] [ ]         [ ]     [ ]\\n\" +\n" +
                "        \"[ ]             [S]     [S]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \" 0   1   2   3   4   5   6\\n\" +\n" +
                "        \"[ ] [ ] ... ... [ ] ... ( )\\n\" +\n" +
                "        \"[S] [S]         [S]     [S]\\n\" +\n" +
                "        \"[ ]             [ ]     [ ]\\n\" +\n" +
                "        \"                [ ]     [ ]\\n\" +\n" +
                "        \"Because all smaller delays would get you caught, the fewest number of picoseconds you would need to delay to get through safely is 10.") {
                Assertions.assertThat(scanner2("0: 3\n" +
                    "1: 2\n" +
                    "4: 4\n" +
                    "6: 4")).isEqualTo(10)
            }
        }
    }
})
