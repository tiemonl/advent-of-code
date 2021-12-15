package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = true
) { Problem14() }

class Problem14 : Puzzle<Long, Long>(
    year = 2021,
    day = 14,
    sample = false
) {
    override val input = rawInput.joinToString("\n").split("\n\n")
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
        repeat(30) { // keep input from last time and start with ten steps already completed
            polymer = fillPolymer(polymer, score)
        }
        return getScore()
    }

    private fun fillPolymer(polymer: Map<String, Long>, score: MutableMap<Char, Long>): MutableMap<String, Long> {
        val newPolymer = mutableMapOf<String, Long>()
        polymer.forEach { (pair, count) ->
            val rule = rules.first{ it.first == pair}.second
            val firstPair = "${pair.first()}${rule}"
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
}