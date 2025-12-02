package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem01() }

@AocProblem(year = 2015, day = 1, name = "Not Quite Lisp")
class Problem01(
    inputProvider: InputProvider = fileInputProvider<Problem01>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringInput()

    override fun solvePartOne(): Int {
        return input.count { it == '(' } - input.count { it == ')' }
    }

    override fun solvePartTwo(): Int {
        var level = 0
        input.forEachIndexed { index, c ->
            when (c) {
                '(' -> level++
                ')' -> level--
            }
            if (level == -1) return index + 1
        }
        return 0
    }
}
