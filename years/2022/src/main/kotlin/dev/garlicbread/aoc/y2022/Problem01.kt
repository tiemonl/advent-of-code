package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem01() }

class Problem01 : Puzzle<Int, Int>(
    year = 2022,
    day = 1,
) {
    override val input = rawInput.joinToString("\n")
        .split("\n\n")
        .map {
            buildList {
                addAll(it.split("\n").map { it.toInt() })
            }
        }

    override fun solvePartOne(): Int {
        return input.maxOf { it.sum() }
    }

    override fun solvePartTwo(): Int {
        return input.groupBy { it.sum() }.map { it.key }.toList().sortedDescending().take(3).sum()
    }
}
