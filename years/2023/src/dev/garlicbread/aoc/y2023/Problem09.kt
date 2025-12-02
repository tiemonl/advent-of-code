package dev.garlicbread.aoc.y2023

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem09() }

@AocProblem(year = 2023, day = 9, name = "Mirage Maintenance")
class Problem09(
    inputProvider: InputProvider = fileInputProvider<Problem09>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideStringListInput().map { it.split(" ").map { num -> num.toInt() } }

    override fun solvePartOne() = input.sumOf { numList ->
        numList.findPattern().reversed().sumOf { it.last() }
    }

    override fun solvePartTwo() = input.sumOf { numList ->
        numList.findPattern().map { it.first() }.foldRight(0) { num: Int, acc: Int -> num - acc }
    }

    private fun List<Int>.findPattern() = buildList<List<Int>> {
        add(this@findPattern)
        while (last().any { it != 0 }) {
            add(last().zipWithNext().map { it.second - it.first })
        }
    }
}
