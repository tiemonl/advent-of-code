package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem03() }

class Problem03(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput()

    override fun solvePartOne(): Int {
        val diff = mutableListOf<Char>()
        input.forEach { compartment ->
            val rucksacks = compartment.chunked(compartment.length / 2)
            diff.addAll(rucksacks.first().toSet().intersect(rucksacks.last().toSet()))
        }
        return getScore(diff)
    }

    override fun solvePartTwo(): Int {
        val diff = mutableListOf<Char>()
        input.chunked(3).forEach { compartment ->
            diff.addAll(compartment[0].toSet().intersect(compartment[1].toSet()).intersect(compartment[2].toSet()))
        }
        return getScore(diff)
    }

    private fun getScore(items: List<Char>): Int {
        var score = 0
        items.forEach { letter ->
            if (letter in 'A'..'Z') {
                score += (letter - 'A' + 27)
            }
            if (letter in 'a'..'z') {
                score += (letter - 'a' + 1)
            }
        }
        return score
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2022, day = 3, name = "Rucksack Reorganization")
    }
}
