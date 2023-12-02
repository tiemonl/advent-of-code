package dev.garlicbread.aoc.y2023

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem01() }

class Problem01 : Puzzle<Int, Int>(
    year = 2023,
    day = 1,
    name = "Trebuchet?!",
) {
    override val input = rawInput

    private val validDigits = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
    )

    override fun solvePartOne() = input.sumOf { it.calibrate(acceptWords = false) }

    override fun solvePartTwo() = input.sumOf { it.calibrate(acceptWords = true) }

    private fun String.calibrate(acceptWords: Boolean): Int {
        val currentValue = if (acceptWords) {
            var temp = this
            validDigits.keys.forEach { key ->
                val replacement = key.replaceRange(1 until key.length - 1, validDigits[key].toString())
                temp = temp.replace(key, replacement)
            }
            temp
        } else this
        val first = currentValue.first { it.isDigit() }.digitToInt()
        val last = currentValue.last { it.isDigit() }.digitToInt()
        return first * 10 + last
    }
}
