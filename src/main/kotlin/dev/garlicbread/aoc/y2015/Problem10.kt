package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = false,
) { Problem10() }

class Problem10(
    val repetitions: Int = 0,
) : Puzzle<Int, Int>(
    year = 2015,
    day = 10,
) {
    override val input = rawInput.first()

    private val regex = "(\\d)\\1*".toRegex()

    private val list = lookAndSay(input)

    override fun solvePartOne() = list.elementAt(if (repetitions != 0) repetitions else 40).length

    override fun solvePartTwo() = list.elementAt(if (repetitions != 0) repetitions else 50).length

    private fun lookAndSay(s: String) = generateSequence(s) {
        buildString {
            regex.findAll(it).toList().map { match ->
                append(match.value.length)
                append(match.value[0])
            }
        }
    }.take(60)
}
