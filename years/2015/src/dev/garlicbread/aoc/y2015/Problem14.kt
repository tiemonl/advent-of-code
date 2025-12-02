package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.transpose

fun main() = solve(
    benchmark = false,
) { Problem14() }

@AocProblem(year = 2015, day = 14, name = "Reindeer Olympics")
class Problem14(
    val totalTime: Int = 2503,
    inputProvider: InputProvider = fileInputProvider<Problem14>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringListInput().map { reindeer ->
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
