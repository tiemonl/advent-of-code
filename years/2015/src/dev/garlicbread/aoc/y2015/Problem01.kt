package dev.garlicbread.aoc.y2015

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

    companion object {
        val METADATA = PuzzleMetadata(year = 2015, day = 1, name = "Not Quite Lisp")
    }
}
