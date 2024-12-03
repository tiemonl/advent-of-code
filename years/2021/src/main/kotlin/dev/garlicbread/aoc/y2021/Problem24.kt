package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem24() }

class Problem24(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Long, Long>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput()

    private val parameters = input.chunked(18).map { line ->
        Parameters(
            line[5].substringAfterLast(" ").toInt(),
            line[15].substringAfterLast(" ").toInt(),
        )
    }

    override fun solvePartOne() = findModelNumber(largest = true)

    override fun solvePartTwo() = findModelNumber(largest = false)

    private fun findModelNumber(largest: Boolean): Long {
        val stack = ArrayDeque<StackItem>()
        val digits = Array(14) { 0 }

        parameters.forEachIndexed { digitIndex, parameters ->
            if (parameters.xAddend >= 10) {
                stack.add(StackItem(digitIndex, parameters.yAddend))
            } else {
                val popped = stack.removeLast()
                val addend = popped.addend + parameters.xAddend
                val digit = (if (largest) 9 downTo 1 else 1..9).first { it + addend in 1..9 }
                digits[popped.digitIndex] = digit
                digits[digitIndex] = digit + addend
            }
        }

        return digits.fold(0L) { acc, d -> acc * 10 + d }
    }

    data class StackItem(val digitIndex: Int, val addend: Int)

    data class Parameters(val xAddend: Int, val yAddend: Int)

    companion object {
        val METADATA = PuzzleMetadata(year = 2021, day = 24, name = "")
    }
}
