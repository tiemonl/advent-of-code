package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.median
import kotlin.math.abs
import kotlin.math.roundToInt

fun main() = solve(
    benchmark = false,
) { Problem07() }

class Problem07(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
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

    companion object {
        val METADATA = PuzzleMetadata(year = 2021, day = 7, name = "")
    }
}
