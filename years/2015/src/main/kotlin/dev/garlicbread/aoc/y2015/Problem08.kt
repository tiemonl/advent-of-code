package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.countMatches

fun main() = solve(
    benchmark = false,
) { Problem08() }

class Problem08(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput()

    override fun solvePartOne(): Int {
        var literal = 0
        var memory = 0
        input.map {
            literal += it.length
            memory += (
                    it.length - 2 - (it.countMatches("\\\\x[0-9A-Fa-f]{2}".toRegex()) * 3) - it.countMatches("\\\"") - it.countMatches(
                        "\\\\",
                    )
                    )
        }
        return literal - memory
    }

    override fun solvePartTwo(): Int {
        var literal = 0
        var memory = 0
        input.map {
            literal += it.length
            memory += (
                    it.length + 4 + it.countMatches("\\\\x[0-9A-Fa-f]{2}".toRegex()) + (it.countMatches("\\\"") * 2) + (
                            it.countMatches(
                                "\\\\",
                            ) * 2
                            )
                    )
        }
        return memory - literal
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2015, day = 8, name = "Matchsticks")
    }
}
