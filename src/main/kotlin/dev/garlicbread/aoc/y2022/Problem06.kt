package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve
import dev.garlicbread.aoc.utils.allUnique

fun main() = solve(
    benchmark = false
) { Problem06() }

class Problem06 : Puzzle<Int, Int>(
    year = 2022,
    day = 6
) {
    override val input = rawInput.joinToString("")

    override fun solvePartOne(): Int = startOfPacket(4)

    override fun solvePartTwo(): Int = startOfPacket(14)

    private fun startOfPacket(window: Int): Int = input.indexOf(input.windowed(window, 1).first { it.allUnique() }) + window
}
