package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve
import dev.garlicbread.aoc.utils.median
import kotlin.math.abs

fun main() = solve(
    benchmark = true
) { Problem07() }

class Problem07 : Puzzle<Int, Int>(
    year = 2021,
    day = 7,
    sample = false
) {
    override val input = rawInput.flatMap { it.split(",").map { it.toInt() } }

    override fun solvePartOne(): Int {
        val median = median(input)
        return input.sumOf { abs(it - median) }
    }

    override fun solvePartTwo(): Int {
        val mean = input.average().toInt()
        // return (0..input.maxOf { it }).minOf { dest -> input.sumOf { ((abs(it-dest))*(abs(it -dest).inc()))/2 } }
        return input.sumOf { ((abs(it - mean)) * (abs(it - mean) + 1)) / 2 }
    }
}