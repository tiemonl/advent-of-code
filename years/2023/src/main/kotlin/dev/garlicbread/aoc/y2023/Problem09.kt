package dev.garlicbread.aoc.y2023

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem09() }

class Problem09(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Any, Any>(
    metadata = METADATA,
) {
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

    companion object {
        val METADATA = PuzzleMetadata(year = 2023, day = 9, name = "Mirage Maintenance")
    }
}
