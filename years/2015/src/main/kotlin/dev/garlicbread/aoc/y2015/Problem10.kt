package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem10() }

class Problem10(
    val repetitions: Int = 0,
) : Puzzle<Int, Int>(
    year = 2015,
    day = 10,
) {
    override val input = rawInput.first().toList()

    override fun solvePartOne() =
        (1..if (repetitions != 0) repetitions else 40).fold(input) { acc, _ -> lookAndSay(acc) }.size

    override fun solvePartTwo() =
        (1..if (repetitions != 0) repetitions else 50).fold(input) { acc, _ -> lookAndSay(acc) }.size

    private fun lookAndSay(num: List<Char>) = buildString {
        var currentChar: Char? = null
        var count = 0
        for (char in num) {
            if (currentChar == char) {
                count++
            } else {
                currentChar?.let { append("$count$it") }
                currentChar = char
                count = 1
            }
        }
        currentChar?.let { append("$count$it") }
    }.toList()
}
