package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.md5

fun main() = solve(
    benchmark = false,
) { Problem04() }

class Problem04(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringInput()

    override fun solvePartOne(): Int = generateSequence(1) { it + 1 }.first { "$input$it".md5().startsWith("00000") }

    override fun solvePartTwo(): Int = generateSequence(1) { it + 1 }.first { "$input$it".md5().startsWith("000000") }

    companion object {
        val METADATA = PuzzleMetadata(year = 2015, day = 4, name = "The Ideal Stocking Stuffer")
    }
}
