package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Point
import dev.garlicbread.aoc.utils.gauss

fun main() = solve(
    benchmark = false,
) { Problem17() }

class Problem17 : Puzzle<Int, Int>(
    year = 2021,
    day = 17,
) {
    override val input = Regex("""target area: x=(\d+)\.\.(\d+), y=(-\d+)\.\.(-\d+)""").matchEntire(rawInput.first())!!
        .destructured.let { (minX, maxX, minY, maxY) ->
            Pair(
                Point(minX.toInt(), minY.toInt()),
                Point(maxX.toInt(), maxY.toInt()),
            )
        }

    override fun solvePartOne(): Int {
        return gauss((-input.first.y - 1))
    }

    override fun solvePartTwo(): Int {
        val minY = input.first.y
        val maxY = -input.first.y - 1
        val minX = (1..input.first.x).first { gauss(it) >= input.first.x }
        val maxX = input.second.x
        return buildList {
            (minX..maxX).forEach { x ->
                (minY..maxY).forEach { y ->
                    add(Point(x, y))
                }
            }
        }.count { doesProbeHitTarget(it) }
    }

    private fun doesProbeHitTarget(point: Point): Boolean {
        var current = Point(0, 0)
        var velocity = point
        while (!input.overshot(current)) {
            current = Point(
                current.x + velocity.x,
                current.y + velocity.y,
            )
            velocity = Point(
                velocity.x + if (velocity.x > 0) -1 else if (velocity.x < 0) 1 else 0,
                velocity.y - 1,
            )
            if (input.contains(current)) {
                return true
            }
        }
        return false
    }

    private fun Pair<Point, Point>.overshot(point: Point) =
        point.x > IntRange(this.first.x, this.second.x).last || point.y < IntRange(this.first.y, this.second.y).first

    private fun Pair<Point, Point>.contains(point: Point) =
        point.x in IntRange(this.first.x, this.second.x) && point.y in IntRange(this.first.y, this.second.y)
}
