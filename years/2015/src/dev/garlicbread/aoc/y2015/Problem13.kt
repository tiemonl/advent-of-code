package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.permutations

fun main() = solve(
    benchmark = false,
) { Problem13() }

@AocProblem(year = 2015, day = 13, name = "Knights of the Dinner Table")
class Problem13(
    inputProvider: InputProvider = fileInputProvider<Problem13>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringListInput().map { dinnerTable ->
        "\\b([A-Z].*?)\\b.*(gain|lose)\\b.*\\b([0-9]+).*?\\b([A-Z].*?)\\b.*".toRegex()
            .matchEntire(dinnerTable)!!.destructured.let { (person, gainLose, happiness, neighbor) ->
                DinnerTable(
                    person = person,
                    neighbor = neighbor,
                    happiness = happiness.toInt().let { if (gainLose == "lose") it.times(-1) else it },
                )
            }
    }

    private val seating = input.map { it.person }.distinct().permutations()

    override fun solvePartOne() = seating.map { it + it.first() }.maxHappiness()

    override fun solvePartTwo() = seating.maxHappiness()

    data class DinnerTable(val person: String, val neighbor: String, val happiness: Int)

    private fun List<List<String>>.maxHappiness() = this.maxOf { seats ->
        seats.zipWithNext().sumOf { (person1, person2) ->
            input.first { it.person == person1 && it.neighbor == person2 }.happiness +
                    input.first { it.person == person2 && it.neighbor == person1 }.happiness
        }
    }
}
