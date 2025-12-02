package dev.garlicbread.aoc.y2024

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = true,
) { Problem11() }

@AocProblem(year = 2024, day = 11, name = "Plutonian Pebbles")
class Problem11(
    inputProvider: InputProvider = fileInputProvider<Problem11>(),
    var blinks: Int = -1
) : Problem<Any, Any>() {
    override val input = buildMap<Long, Long> {
        inputProvider.provideStringInput().split(" ").forEach { insertStone(this, it.toLong()) }
    }

    override fun solvePartOne(): Any {
        val blink = if (blinks == -1) 25 else blinks
        var map = input
        (1..blink).map {
            map = applyRule(map)
        }
        return map.values.sumOf { it }
    }

    override fun solvePartTwo(): Any {
        val blink = if (blinks == -1) 75 else blinks
        var map = input
        (1..blink).map {
            map = applyRule(map)
        }
        return map.values.sumOf { it }
    }

    private fun insertStone(map: MutableMap<Long, Long>, stone: Long, amount: Long = 1L) =
        if (map.containsKey(stone)) map[stone] = map.getValue(stone) + amount else map.put(stone, amount)

    private fun applyRule(map: Map<Long, Long>): Map<Long, Long> {
        return buildMap {
            map.forEach { (key, value) ->
                when {
                    key == 0L -> insertStone(this, 1, value)
                    key.toString().length % 2 == 0 -> {
                        val (first, second) = key.toString().chunked(key.toString().length / 2).map { it.toLong() }
                        insertStone(this, first, value)
                        insertStone(this, second, value)
                    }

                    else -> insertStone(this, key * 2024, value)
                }
            }
        }
    }
}
