package dev.garlicbread.aoc.y2017

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
) : Puzzle<Any, Any>(
    metadata = METADATA,
) {
    override val input = inputProvider.provideStringInput().map { it.digitToInt() }

    override fun solvePartOne() = solveCaptcha(1)

    override fun solvePartTwo() = solveCaptcha(input.size / 2)

    fun solveCaptcha(step: Int) = input.foldIndexed(0) { index, acc, i ->
        acc + if (i == input[(index + step).mod(input.size)]) i else 0
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2017, day = 1, name = "Inverse Captcha")
    }
}
