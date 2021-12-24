package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve
import dev.garlicbread.aoc.utils.md5

fun main() = solve(
    benchmark = false
) { Problem04() }

class Problem04 : Puzzle<Int, Int>(
    year = 2015,
    day = 4
) {
    override val input = rawInput.first()

    override fun solvePartOne(): Int {
        return findLowestHashThatStartsWithNZeros(input, 5)
    }

    override fun solvePartTwo(): Int {
        return findLowestHashThatStartsWithNZeros(input, 6)
    }

    private fun findLowestHashThatStartsWithNZeros(key: String, zeroes: Int): Int {
        var counter = 0
        var currentString = key + counter

        while (!currentString.md5().startsWith("0".repeat(zeroes))) {
            counter++
            currentString = key + counter
        }
        return counter
    }

}
