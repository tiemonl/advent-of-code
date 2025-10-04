package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.allUnique

fun main() = solve(
    benchmark = false,
) { Problem06() }

class Problem06(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringInput()

    override fun solvePartOne(): Int = startOfPacket(4)

    override fun solvePartTwo(): Int = startOfPacket(14)

    private fun startOfPacket(window: Int): Int =
        input.indexOf(input.windowed(window, 1).first { it.allUnique() }) + window

    companion object {
        val METADATA = PuzzleMetadata(year = 2022, day = 6, name = "Tuning Trouble")
    }
}
