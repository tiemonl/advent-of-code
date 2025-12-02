package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem01() }

@AocProblem(year = 2021, day = 1, name = "Sonar Sweep")
class Problem01(
    inputProvider: InputProvider = fileInputProvider<Problem01>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideIntListInput()

    override fun solvePartOne(): Int {
        return input.zipWithNext().count { it.second > it.first }
    }

    override fun solvePartTwo(): Int {
        var increases = 0
        for (i in 3..input.size.dec()) {
            val sumA = input[i - 1] + input[i - 2] + input[i - 3]
            val sumB = input[i] + input[i - 1] + input[i - 2]
            if (sumB > sumA) {
                increases++
            }
        }
        return increases
    }

}
