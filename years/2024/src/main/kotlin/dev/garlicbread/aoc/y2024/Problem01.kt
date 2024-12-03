package dev.garlicbread.aoc.y2024

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.transpose
import kotlin.math.abs

fun main() = solve(
    benchmark = true,
) { Problem01() }

class Problem01(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input =
        inputProvider.provideStringListInput().map { it.split("\\s+".toRegex()).map { it.toInt() } }.transpose()

    override fun solvePartOne(): Int {
        val sortedList1 = input[0].sorted()
        val sortedList2 = input[1].sorted()
        return sortedList1.zip(sortedList2).sumOf {
            abs(it.first - it.second)
        }
    }

    override fun solvePartTwo(): Int = input[0].sumOf { i ->
        i * input[1].count { it == i }
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2024, day = 1, name = "Historian Hysteria")
    }
}
