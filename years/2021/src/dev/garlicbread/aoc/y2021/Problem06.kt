package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem06() }

@AocProblem(year = 2021, day = 6, name = "Lanternfish")
class Problem06(
    inputProvider: InputProvider = fileInputProvider<Problem06>()
) : Problem<Long, Long>() {
    override val input = inputProvider.provideStringListInput().flatMap { it.split(",").map { value -> value.toInt() } }

    override fun solvePartOne(): Long {
        return findFishCountAfterDays(80)
    }

    override fun solvePartTwo(): Long {
        return findFishCountAfterDays(256)
    }

    private fun findFishCountAfterDays(days: Int): Long {
        var fishes = input.groupingBy { it }.eachCount().mapValues { it.value.toLong() }
        for (i in 1..days) {
            val tempFishes = mutableMapOf<Int, Long>()
            for (fish in fishes) {
                if (fish.key == 0) {
                    tempFishes[8] = tempFishes[8]?.plus(fish.value) ?: fish.value
                    tempFishes[6] = tempFishes[6]?.plus(fish.value) ?: fish.value
                } else {
                    tempFishes[fish.key - 1] = tempFishes[fish.key - 1]?.plus(fish.value) ?: fish.value
                }
            }
            fishes = tempFishes
        }
        return fishes.entries.sumOf { it.value }
    }
}
