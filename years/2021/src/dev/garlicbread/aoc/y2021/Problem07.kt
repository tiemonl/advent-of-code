package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.median
import kotlin.math.abs
import kotlin.math.roundToInt

fun main() = solve(
    benchmark = false,
) { Problem07() }

@AocProblem(year = 2021, day = 7, name = "The Treachery of Whales")
class Problem07(
    inputProvider: InputProvider = fileInputProvider<Problem07>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringListInput().flatMap { it.split(",").map { it.toInt() } }

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
