package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Direction
import dev.garlicbread.aoc.models.Point

fun main() = solve(
    benchmark = false,
) { Problem03() }

@AocProblem(year = 2015, day = 3, name = "Perfectly Spherical Houses in a Vacuum")
class Problem03(
    inputProvider: InputProvider = fileInputProvider<Problem03>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringInput().map {
        when (it) {
            '^' -> Direction.North
            'v' -> Direction.South
            '<' -> Direction.West
            '>' -> Direction.East
            else -> error("Direction $it not found")
        }
    }

    private val startingPoint = Point(0, 0)

    override fun solvePartOne(): Int {
        var current = startingPoint

        return buildSet<Point> {
            add(current)
            input.forEach {
                current = current.move(it)
                add(current)
            }
        }.count()
    }

    override fun solvePartTwo(): Int {
        var currentSanta = startingPoint
        var currentRoboSanta = startingPoint

        return buildSet<Point> {
            add(startingPoint)
            input.forEachIndexed { i, direction ->
                if (i % 2 == 0) {
                    currentSanta = currentSanta.move(direction)
                    add(currentSanta)
                } else {
                    currentRoboSanta = currentRoboSanta.move(direction)
                    add(currentRoboSanta)
                }
            }
        }.count()
    }
}
