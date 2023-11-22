package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.transpose

fun main() = solve(
    benchmark = false,
) { Problem14() }

class Problem14(
    val totalTime: Int = 2503
) : Puzzle<Int, Int>(
    year = 2015,
    day = 14,
) {
    override val input = rawInput.map { reindeer ->
        "^.*\\b(\\d+)\\b.*\\b(\\d+)\\b.*\\b(\\d+)\\b.*\$".toRegex()
            .matchEntire(reindeer)!!.destructured.let { (speed, running, rest) ->
                Reindeer(
                    speed = speed.toInt(),
                    running = running.toInt(),
                    runningRest = running.toInt() + rest.toInt()
                )
            }
    }

    override fun solvePartOne() = input.maxOf { reindeer ->
        ((totalTime / reindeer.runningRest) * reindeer.running + (totalTime % reindeer.runningRest)
            .coerceAtMost(reindeer.running)) * reindeer.speed
    }

    override fun solvePartTwo() = input.map { reindeer ->
        (1..totalTime).scan(reindeer.speed) { acc, distance ->
            if ((distance % reindeer.runningRest) < reindeer.running) acc + reindeer.speed else acc
        }
    }.transpose().map { currentTime ->
        val max = currentTime.max()
        currentTime.map { distance ->
            if (distance == max) 1 else 0
        }
    }.transpose().maxOf { it.sum() }

    data class Reindeer(val speed: Int, val running: Int, val runningRest: Int)
}
