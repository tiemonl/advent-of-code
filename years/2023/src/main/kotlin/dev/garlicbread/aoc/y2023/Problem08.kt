package dev.garlicbread.aoc.y2023

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.lcm

fun main() = solve(
    benchmark = false,
) { Problem08() }

class Problem08 : Puzzle<Int, Long>(
    year = 2023,
    day = 8,
    name = "Haunted Wasteland",
) {
    override val input = rawInput.joinToString("\n").split("\n\n").let { (instruction, mapList) ->
        val map = mutableMapOf<String, Pair<String, String>>()
        mapList.split("\n").forEach {
            it.split(" = ").let { (key, direction) ->
                direction.removeSurrounding("(", ")").split(", ").let { (left, right) ->
                    map[key] = Pair(left, right)
                }
            }
        }
        Wasteland(
            instruction = instruction.toList(),
            map = map.toMap(),
        )
    }

    override fun solvePartOne() = "AAA".findEndPoint()

    override fun solvePartTwo() = lcm(input.map.keys.filter { it.endsWith("A") }.map { it.findEndPoint().toLong() })

    private fun String.findEndPoint(): Int {
        var step = this
        var steps = 0
        while (!step.endsWith("Z")) {
            val direction = input.instruction[steps % input.instruction.size]
            steps++
            when (direction) {
                'L' -> step = input.map[step]!!.first
                'R' -> step = input.map[step]!!.second
            }
        }
        return steps
    }

    data class Wasteland(
        val instruction: List<Char>,
        val map: Map<String, Pair<String, String>>,
    )
}
