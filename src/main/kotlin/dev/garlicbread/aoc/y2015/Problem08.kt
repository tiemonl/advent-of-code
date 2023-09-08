package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve
import dev.garlicbread.aoc.utils.countMatches

fun main() = solve(
    benchmark = false,
) { Problem08() }

class Problem08 : Puzzle<Int, Int>(
    year = 2015,
    day = 8,
) {
    override val input = rawInput

    override fun solvePartOne(): Int {
        var literal = 0
        var memory = 0
        input.map {
            literal += it.length
            memory += (it.length - 2 - (it.countMatches("\\\\x[0-9A-Fa-f]{2}".toRegex()) * 3) - it.countMatches("\\\"") - it.countMatches("\\\\"))
        }
        return literal - memory
    }

    override fun solvePartTwo(): Int {
        var literal = 0
        var memory = 0
        input.map {
            literal += it.length
            memory += (it.length + 4 + it.countMatches("\\\\x[0-9A-Fa-f]{2}".toRegex()) + (it.countMatches("\\\"") * 2) + (it.countMatches("\\\\") * 2))
        }
        return memory - literal
    }
}
