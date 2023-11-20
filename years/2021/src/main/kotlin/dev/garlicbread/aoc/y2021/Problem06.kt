package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem06() }

class Problem06 : Puzzle<Long, Long>(
    year = 2021,
    day = 6,
) {
    override val input = rawInput.flatMap { it.split(",").map { value -> value.toInt() } }

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
