package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve { Problem0() } // TODO: change class name call

// TODO: change class name to match problem number and day number
class Problem0 : Puzzle<Int, Int>(
    year = 2021,
    day = 0,
    sample = false
) {
    override val input = rawInput.map { it.toInt() }

    override fun solvePartOne(): Int {
        return 0
    }

    override fun solvePartTwo(): Int {
        return 0
    }
}