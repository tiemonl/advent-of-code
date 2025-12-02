package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem04() }

@AocProblem(year = 2022, day = 4, name = "Camp Cleanup")
class Problem04(
    inputProvider: InputProvider = fileInputProvider<Problem04>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringListInput().map {
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
