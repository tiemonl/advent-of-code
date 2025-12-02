package dev.garlicbread.aoc.y2024

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem03() }

@AocProblem(year = 2024, day = 3, name = "Mull It Over")
class Problem03(
    inputProvider: InputProvider = fileInputProvider<Problem03>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideStringInput()

    val mulRegex = Regex("""mul\((\d+),(\d+)\)""")

    override fun solvePartOne(): Any {
        val muls = mulRegex.findAll(input).map {
            val (x, y) = it.destructured
            Pair(x.toInt(), y.toInt())
        }.toList()
        return muls.sumOf { it.first * it.second }
    }

    override fun solvePartTwo(): Any {
        var isEnabled = true
        val pairs = mutableListOf<Pair<Int, Int>>()
        Regex("""mul\((\d+),(\d+)\)|do\(\)|don't\(\)""").findAll(input).forEach { matchResult ->
            when {
                matchResult.value == "do()" -> isEnabled = true
                matchResult.value == "don't()" -> isEnabled = false
                matchResult.value.startsWith("mul") && isEnabled -> {
                    val (x, y) = mulRegex.matchEntire(matchResult.value)!!.destructured
                    pairs.add(Pair(x.toInt(), y.toInt()))
                }
            }
        }
        return pairs.sumOf { it.first * it.second }
    }
}
