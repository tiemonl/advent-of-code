package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem10() }

@AocProblem(year = 2015, day = 10, name = "Elves Look, Elves Say")
class Problem10(
    val repetitions: Int = 0,
    inputProvider: InputProvider = fileInputProvider<Problem10>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringInput().toList()

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
