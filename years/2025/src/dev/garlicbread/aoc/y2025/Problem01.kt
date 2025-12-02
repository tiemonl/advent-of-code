package dev.garlicbread.aoc.y2025

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import kotlin.math.absoluteValue

fun main() = solve(
    benchmark = false,
) { Problem01() }

@AocProblem(year = 2025, day = 1, name = "Secret Entrance")
class Problem01(
    inputProvider: InputProvider = fileInputProvider<Problem01>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideStringListInput()
        .map { if (it.first() == 'L') it.drop(1).toInt() * -1 else it.drop(1).toInt() }

    override fun solvePartOne() = input.fold(50 to 0) { (dial, zeroes), i ->
        val next = (dial + i).mod(100)
        val zero = if (dial == 0) 1 else 0
        next to zeroes + zero
    }.second

    override fun solvePartTwo() = input.fold(50 to 0) { (dial, zeroes), i ->
        val dialToZero = when {
            dial == 0 -> 100
            i > 0 -> 100 - dial
            else -> dial
        }
        val nextZeroes = if (i.absoluteValue >= dialToZero) {
            zeroes + (1 + (i.absoluteValue - dialToZero) / 100)
        } else {
            zeroes
        }
        (dial + i).mod(100) to nextZeroes
    }.second
}
