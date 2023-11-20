package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem04() }

class Problem04 : Puzzle<Int, Int>(
    year = 2022,
    day = 4,
) {
    override val input = rawInput.map {
        it.split(",").let { (firstRange, secondRange) ->
            Pair(
                firstRange.split("-").let { (min, max) -> IntRange(min.toInt(), max.toInt()) },
                secondRange.split("-").let { (min, max) -> IntRange(min.toInt(), max.toInt()) },
            )
        }
    }

    override fun solvePartOne(): Int = input.count { sections ->
        (sections.first.first <= sections.second.first && sections.first.last >= sections.second.last) ||
            (sections.second.first <= sections.first.first && sections.second.last >= sections.first.last)
    }

    override fun solvePartTwo(): Int = input.count { sections ->
        sections.second.any { it in sections.first } || sections.first.any { it in sections.second }
    }
}
