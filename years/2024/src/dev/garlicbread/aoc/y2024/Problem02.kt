package dev.garlicbread.aoc.y2024

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem02() }

@AocProblem(year = 2024, day = 2, name = "Red-Nosed Reports")
class Problem02(
    inputProvider: InputProvider = fileInputProvider<Problem02>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideNestedIntListInput()

    override fun solvePartOne(): Any {
        return input.count {
            isSafe(it)
        }
    }

    override fun solvePartTwo(): Any {
        val (safe, unsafe) = input.partition { isSafe(it) }
        val unsafeRemoved = unsafe.count {
            it.indices.any { i ->
                val newList = it.filterIndexed { index, _ -> index != i }
                isSafe(newList)
            }
        }
        return safe.size + unsafeRemoved
    }

    private fun isSafe(report: List<Int>): Boolean {
        val increase = report[1] - report[0] > 0
        return report.windowed(2, 1, false).all { if (increase) it[1] - it[0] in 1..3 else it[0] - it[1] in 1..3 }
    }
}
