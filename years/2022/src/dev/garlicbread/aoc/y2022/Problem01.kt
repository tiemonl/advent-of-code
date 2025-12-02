package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem01() }

@AocProblem(year = 2022, day = 1, name = "Calorie Counting")
class Problem01(
    inputProvider: InputProvider = fileInputProvider<Problem01>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringListInput().joinToString("\n")
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
