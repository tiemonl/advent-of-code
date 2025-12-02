package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.countMatches

fun main() = solve(
    benchmark = false,
) { Problem08() }

@AocProblem(year = 2015, day = 8, name = "Matchsticks")
class Problem08(
    inputProvider: InputProvider = fileInputProvider<Problem08>()
) : Problem<Int, Int>() {
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
}
