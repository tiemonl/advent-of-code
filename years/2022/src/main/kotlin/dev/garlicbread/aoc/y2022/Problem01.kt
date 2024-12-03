package dev.garlicbread.aoc.y2022

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

    companion object {
        val METADATA = PuzzleMetadata(year = 2022, day = 1, name = "Calorie Counting")
    }
}
