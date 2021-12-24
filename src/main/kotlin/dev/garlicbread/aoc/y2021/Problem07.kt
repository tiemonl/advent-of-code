package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve
import dev.garlicbread.aoc.utils.median
import kotlin.math.abs
import kotlin.math.roundToInt

fun main() = solve(
    benchmark = true
) { Problem07() }

class Problem07 : Puzzle<Int, Int>(
    year = 2021,
    day = 7
) {
    override val input = rawInput.flatMap { it.split(",").map { it.toInt() } }

    override fun solvePartOne(): Int {
        val median = median(input)
        return input.sumOf { abs(it - median) }
    }

    override fun solvePartTwo(): Int {
        val avg = input.average().roundToInt()
        val meanRange = listOf(avg.dec(), avg, avg.inc())
        return meanRange.minOf { mean -> input.sumOf { ((abs(it - mean)) * (abs(it - mean) + 1)) / 2 } }
    }
}