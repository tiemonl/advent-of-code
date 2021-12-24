package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = false
) { Problem01() }

class Problem01 : Puzzle<Int, Int>(
    year = 2015,
    day = 1
) {
    override val input = rawInput.first()

    override fun solvePartOne(): Int {
        return input.count { it == '(' } - input.count { it == ')' }
    }

    override fun solvePartTwo(): Int {
        var level = 0
        input.forEachIndexed { index, c ->
            when (c) {
                '(' -> level++
                ')' -> level--
            }
            if (level == -1) return index + 1
        }
        return 0
    }
}
