package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem08() }

class Problem08(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input: List<Pair<String, String>> =
        inputProvider.provideStringListInput().map { it.split(" | ") }.map { Pair(it[0], it[1]) }

    override fun solvePartOne(): Int {
        return input.sumOf { pair -> pair.second.split(" ").count { it.length in setOf(2, 3, 4, 7) } }
    }

    override fun solvePartTwo(): Int {
        return input.sumOf {
            deduceInt(it.second.split(" "), solveSegments(it.first.split(" ")))
        }
    }

    private fun deduceInt(codedNumbers: List<String>, decodedMap: Map<Set<Char>, Int>): Int {
        var number = ""
        codedNumbers.forEach {
            number += decodedMap[it.toSortedSet()]
        }
        return number.toInt()
    }

    private fun solveSegments(segments: List<String>): Map<Set<Char>, Int> {
        val decodedMap = mutableMapOf<Int, Set<Char>>()
        decodedMap[1] = segments.first { it.length == 2 }.toSortedSet()
        decodedMap[7] = segments.first { it.length == 3 }.toSortedSet()
        decodedMap[4] = segments.first { it.length == 4 }.toSortedSet()
        decodedMap[8] = segments.first { it.length == 7 }.toSortedSet()
        decodedMap[3] = segments.first { it.length == 5 && it.overlaps(decodedMap[1]!!) }.toSortedSet()
        decodedMap[9] =
            segments.first { it.length == 6 && it.toSet().containsAll(decodedMap[4]?.toSet()!!) }.toSortedSet()
        decodedMap[0] =
            segments.first { it.length == 6 && it.toSortedSet() != decodedMap[9] && it.overlaps(decodedMap[1]!!) }
                .toSortedSet()
        decodedMap[6] =
            segments.first { it.length == 6 && it.toSortedSet() !in setOf(decodedMap[0], decodedMap[9]) }.toSortedSet()
        decodedMap[5] = segments.first { it.length == 5 && decodedMap[6]!!.overlaps(it.toSortedSet()) }.toSortedSet()
        decodedMap[2] =
            segments.first { it.length == 5 && it.toSortedSet() !in setOf(decodedMap[3], decodedMap[5]) }.toSortedSet()

        return decodedMap.entries.associateBy({ it.value }) { it.key }
    }

    private fun String.overlaps(that: Set<Char>): Boolean = this.toSet().containsAll(that)
    private fun Set<Char>.overlaps(that: Set<Char>): Boolean = this.containsAll(that)

    companion object {
        val METADATA = PuzzleMetadata(year = 2021, day = 8, name = "")
    }
}
