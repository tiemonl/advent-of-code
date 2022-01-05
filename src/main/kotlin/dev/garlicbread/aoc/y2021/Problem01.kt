package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = true
) { Problem01() }

class Problem01 : Puzzle<Int, Int>(
    year = 2021,
    day = 1
) {
    override val input = rawInput.map { it.toInt() }

    override fun solvePartOne(): Int {
        var increases = 0
        for (i in 1..input.size.dec()) {
            if (input[i] > input[i - 1]) {
                increases++
            }
        }
        return increases
    }

    override fun solvePartTwo(): Int {
        var increases = 0
        for (i in 3..input.size.dec()) {
            val sumA = input[i - 1] + input[i - 2] + input[i - 3]
            val sumB = input[i] + input[i - 1] + input[i - 2]
            if (sumB > sumA) {
                increases++
            }
        }
        return increases
    }
}
