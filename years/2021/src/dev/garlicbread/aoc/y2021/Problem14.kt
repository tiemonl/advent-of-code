package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem14() }

class Problem14(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Long, Long>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput().joinToString("\n").split("\n\n")
    private lateinit var polymer: MutableMap<String, Long>
    private lateinit var score: MutableMap<Char, Long>
    private lateinit var rules: List<Pair<String, Char>>

    init {
        parseInput()
    }

    override fun solvePartOne(): Long {
        repeat(10) {
            polymer = fillPolymer(polymer, score)
        }
        return getScore()
    }

    override fun solvePartTwo(): Long {
        parseInput()
        repeat(40) {
            polymer = fillPolymer(polymer, score)
        }
        return getScore()
    }

    private fun fillPolymer(polymer: Map<String, Long>, score: MutableMap<Char, Long>): MutableMap<String, Long> {
        val newPolymer = mutableMapOf<String, Long>()
        polymer.forEach { (pair, count) ->
            val rule = rules.first { it.first == pair }.second
            val firstPair = "${pair.first()}$rule"
            val secondPair = "${rule}${pair.last()}"
            newPolymer[firstPair] = newPolymer.getOrDefault(firstPair, 0).plus(count)
            newPolymer[secondPair] = newPolymer.getOrDefault(secondPair, 0).plus(count)
            score[rule] = score.getOrDefault(rule, 0).plus(count)
        }
        return newPolymer
    }

    private fun getScore() = score.maxOf { it.value } - score.minOf { it.value }

    private fun parseInput() {
        polymer = input[0].windowed(2).groupingBy { it }.eachCount().mapValues { it.value.toLong() }.toMutableMap()
        score = input[0].groupingBy { it }.eachCount().mapValues { it.value.toLong() }.toMutableMap()
        rules = input[1].split("\n").map {
            val split = it.split(" -> ")
            Pair(split[0], split[1].first())
        }
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2021, day = 14, name = "")
    }
}
