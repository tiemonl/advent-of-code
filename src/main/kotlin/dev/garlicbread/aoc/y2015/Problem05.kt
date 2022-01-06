package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = false
) { Problem05() }

class Problem05 : Puzzle<Int, Int>(
    year = 2015,
    day = 5
) {
    override val input = rawInput

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
