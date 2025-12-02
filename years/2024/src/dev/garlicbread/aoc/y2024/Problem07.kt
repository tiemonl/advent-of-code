package dev.garlicbread.aoc.y2024

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import kotlin.math.pow

fun main() = solve(
    benchmark = true,
) { Problem07() }

@AocProblem(year = 2024, day = 7, name = "Bridge Repair")
class Problem07(
    inputProvider: InputProvider = fileInputProvider<Problem07>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideStringListInput().map { equation ->
        val (result, values) = equation.split(": ")
        Equation(
            result = result.toLong(),
            values = values.split(" ").map { it.toLong() }
        )
    }

    override fun solvePartOne(): Long {
        return input.sumOf { if (calibrate(it.result, it.values.reversed())) it.result else 0L }
    }

    override fun solvePartTwo(): Long {
        return input.filter { calibrate(it.result, it.values.reversed(), true) }.sumOf { it.result }
    }

    private fun deconcatenate(expected: Long, num: Long): Long? {
        val placeValue = 10.0.pow(num.toString().length).toLong()
        val deconcatenated: Long = expected / placeValue
        return if ((deconcatenated * placeValue + num) == expected) deconcatenated else null
    }

    private fun calibrate(expected: Long?, numbers: List<Long>, concat: Boolean = false): Boolean {
        if (expected == null) return false
        if (expected == 0L && numbers.isNotEmpty()) return false
        if (numbers.isEmpty()) return expected == 0L
        val sum = calibrate(expected - numbers.first(), numbers.drop(1), concat)
        val product = if (expected % numbers.first() == 0L) calibrate(
            expected / numbers.first(),
            numbers.drop(1),
            concat
        ) else false
        val concatenation =
            if (concat) calibrate(deconcatenate(expected, numbers.first()), numbers.drop(1), true) else false
        return sum || product || concatenation
    }

    data class Equation(
        val result: Long,
        val values: List<Long>
    )
}
