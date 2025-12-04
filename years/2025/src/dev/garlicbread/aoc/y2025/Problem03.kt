package dev.garlicbread.aoc.y2025

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem03() }

@AocProblem(year = 2025, day = 3, name = "Lobby")
class Problem03(
    inputProvider: InputProvider = fileInputProvider<Problem03>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideNestedIntListInput()

    override fun solvePartOne() = input.sumOf {
        largestSubsequenceNumber(it, 2)
            .joinToString("")
            .toLong()
    }

    override fun solvePartTwo() = input.sumOf {
        largestSubsequenceNumber(it, 12)
            .joinToString("")
            .toLong()
    }

    fun largestSubsequenceNumber(digits: List<Int>, n: Int): List<Int> {
        if (n == 1) return listOf(digits.max())
        val highDigit = digits.dropLast(n - 1).withIndex().maxBy { it.value }
        return listOf(highDigit.value) + largestSubsequenceNumber(digits.drop(highDigit.index.inc()), n.dec())
    }
}
