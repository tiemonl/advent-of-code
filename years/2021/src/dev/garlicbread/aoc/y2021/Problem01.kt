package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem01() }

class Problem01(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
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

    companion object {
        val METADATA = PuzzleMetadata(year = 2024, day = 1, name = "Sonar Sweep")
    }
}
