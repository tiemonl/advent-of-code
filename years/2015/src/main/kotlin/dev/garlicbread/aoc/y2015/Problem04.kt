package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.md5

fun main() = solve(
    benchmark = false,
) { Problem04() }

class Problem04 : Puzzle<Int, Int>(
    year = 2015,
    day = 4,
) {
    override val input = rawInput.first()

    override fun solvePartOne(): Int = generateSequence(1) { it + 1 }.first { "$input$it".md5().startsWith("00000") }

    override fun solvePartTwo(): Int = generateSequence(1) { it + 1 }.first { "$input$it".md5().startsWith("000000") }
}
