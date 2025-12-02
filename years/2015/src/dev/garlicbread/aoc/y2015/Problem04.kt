package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.md5

fun main() = solve(
    benchmark = false,
) { Problem04() }

@AocProblem(year = 2015, day = 4, name = "The Ideal Stocking Stuffer")
class Problem04(
    inputProvider: InputProvider = fileInputProvider<Problem04>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringInput()

    override fun solvePartOne(): Int = generateSequence(1) { it + 1 }.first { "$input$it".md5().startsWith("00000") }

    override fun solvePartTwo(): Int = generateSequence(1) { it + 1 }.first { "$input$it".md5().startsWith("000000") }
}
