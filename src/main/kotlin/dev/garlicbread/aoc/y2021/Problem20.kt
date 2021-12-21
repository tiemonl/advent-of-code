package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.models.Point
import dev.garlicbread.aoc.solve
import kotlin.math.sqrt

fun main() = solve(
    benchmark = false
) { Problem20() }

class Problem20 : Puzzle<Int, Int>(
    year = 2021,
    day = 20,
    sample = false
) {
    override val input = TrenchMap(
        algorithm = rawInput.first().map { if (it == '#') 1 else 0 },
        image = rawInput.drop(2).flatMapIndexed { y, line ->
            line.mapIndexed { x, char -> Point(x, y) to if (char == '#') 1 else 0 }
        }.toMap()
    )

    override fun solvePartOne() = enhance(2).values.count { it == 1 }

    override fun solvePartTwo() = enhance(50).values.count { it == 1 }

    private fun enhance(times: Int) =
        (1..times).fold(input.image to if (input.algorithm.first() == 0) 1 else 0) { (updatedImage, defaultValue), _ ->
            updatedImage.applyAlgorithm(defaultValue) to if (defaultValue == 0) input.algorithm.first() else input.algorithm.last()
        }.first

    private fun Map<Point, Int>.applyAlgorithm(defaultValue: Int): Map<Point, Int> = buildMap {
        val size = sqrt(this@applyAlgorithm.size.toDouble()).toInt()
        for (col in -1..size) {
            for (row in -1..size) {
                this[Point(row + 1, col + 1)] =
                    input.algorithm[neighbors(Point(row, col), this@applyAlgorithm, defaultValue)]
            }
        }
    }

    private fun neighbors(point: Point, image: Map<Point, Int>, defaultValue: Int) = buildString {
        for (col in -1..1) {
            for (row in -1..1) {
                append(
                    image[Point(point.x + row, point.y + col)] ?: defaultValue
                )
            }
        }
    }.toInt(2)

    data class TrenchMap(
        val algorithm: List<Int>,
        val image: Map<Point, Int>
    )
}