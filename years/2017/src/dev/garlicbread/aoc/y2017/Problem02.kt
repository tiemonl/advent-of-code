package dev.garlicbread.aoc.y2017

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = true,
) { Problem02() }

@AocProblem(year = 2017, day = 2, name = "Corruption Checksum")
class Problem02(
    inputProvider: InputProvider = fileInputProvider<Problem02>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideNestedIntListInput()

    override fun solvePartOne(): Int {
        return input.sumOf { it.max() - it.min() }
    }

    override fun solvePartTwo(): Any {
        return input.fold(0) { acc, list ->
            var total = 0
            for (i in 0..<list.size.dec()) {
                for (j in i + 1..<list.size) {
                    if (i == j) continue
                    if (list[i].mod(list[j]) == 0) {
                        total = (list[i] / list[j])
                    } else if (list[j].mod(list[i]) == 0) {
                        total = (list[j] / list[i])
                    }
                }
            }
            acc + total
        }
    }
}
