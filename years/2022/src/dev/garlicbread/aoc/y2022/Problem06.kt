package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.allUnique

fun main() = solve(
    benchmark = false,
) { Problem06() }

@AocProblem(year = 2022, day = 6, name = "Tuning Trouble")
class Problem06(
    inputProvider: InputProvider = fileInputProvider<Problem06>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringInput()

    override fun solvePartOne(): Int = startOfPacket(4)

    override fun solvePartTwo(): Int = startOfPacket(14)

    private fun startOfPacket(window: Int): Int =
        input.indexOf(input.windowed(window, 1).first { it.allUnique() }) + window
}
