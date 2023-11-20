package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem13() }

class Problem13 : Puzzle<Int, Int>(
    year = 2015,
    day = 13,
) {
    // Alice would gain 54 happiness units by sitting next to Bob.
    override val input = rawInput.map { dinnerTable ->
        "\\b([A-Z].*?)\\b.*(gain|lose)\\b.*\\b([0-9]+).*?\\b([A-Z].*?)\\b.*".toRegex()
            .matchEntire(dinnerTable)?.destructured?.let { (person, gainLose, happiness, neighbor) ->
            DinnerTable(
                person = person,
                neighbor = neighbor,
                happiness = happiness.toInt().let { if (gainLose == "lose") it.times(-1) else it },
            )
        }
    }

    override fun solvePartOne(): Int {
        return 0
    }

    override fun solvePartTwo(): Int {
        return 0
    }

    data class DinnerTable(val person: String, val neighbor: String, val happiness: Int)
}
