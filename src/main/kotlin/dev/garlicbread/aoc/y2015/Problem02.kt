package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = false
) { Problem02() }

class Problem02 : Puzzle<Int, Int>(
    year = 2015,
    day = 2
) {
    override val input = rawInput.map { Present.parse(it) }

    override fun solvePartOne(): Int {
        return input.sumOf { it.surfaceArea() + it.wrappingSlack() }
    }

    override fun solvePartTwo(): Int {
        return input.sumOf { it.ribbon() + it.bow() }
    }

    data class Present(val width: Int, val height: Int, val length: Int) {
        fun surfaceArea() = 2 * (width * height) + 2 * (width * length) + 2 * (height * length)
        fun wrappingSlack() = minOf(width * height, width * length, height * length)
        fun bow() = width * height * length
        fun ribbon() = (width + height + length - maxOf(width, height, length)) * 2

        companion object {
            fun parse(input: String): Present {
                return input.split("x").let { (w, h, l) ->
                    Present(w.toInt(), h.toInt(), l.toInt())
                }
            }
        }
    }
}
