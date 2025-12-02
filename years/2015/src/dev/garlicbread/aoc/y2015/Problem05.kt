package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem05() }

@AocProblem(year = 2015, day = 5, name = "Doesn't He Have Intern-Elves For This?")
class Problem05(
    inputProvider: InputProvider = fileInputProvider<Problem05>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringListInput()

    override fun solvePartOne() = input.count { it.isNice() }

    override fun solvePartTwo() = input.count { it.isNicer() }

    private fun String.isNice() =
        this.count { it in setOf('a', 'e', 'i', 'o', 'u') } >= 3 &&
                this.zipWithNext().any { it.first == it.second } &&
                this.windowed(2).none { it in setOf("ab", "cd", "pq", "xy") }

    private fun String.isNicer() =
        (0..this.length - 2).map { i ->
            this.substring(i + 2).contains(this.substring(i, i + 2))
        }.any { it } && this.windowed(3).any { it.first() == it.last() }
}
