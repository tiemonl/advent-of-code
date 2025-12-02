package dev.garlicbread.aoc.y2017

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem01() }

@AocProblem(year = 2017, day = 1, name = "Inverse Captcha")
class Problem01(
    inputProvider: InputProvider = fileInputProvider<Problem01>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideStringInput().map { it.digitToInt() }

    override fun solvePartOne() = solveCaptcha(1)

    override fun solvePartTwo() = solveCaptcha(input.size / 2)

    fun solveCaptcha(step: Int) = input.foldIndexed(0) { index, acc, i ->
        acc + if (i == input[(index + step).mod(input.size)]) i else 0
    }
}
