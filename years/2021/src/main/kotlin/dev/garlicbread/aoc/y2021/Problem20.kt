package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem20() }

class Problem20 : Puzzle<Int, Int>(
    year = 2021,
    day = 20,
) {
    override val input = TrenchMap(
        algorithm = rawInput.first().map { if (it == '#') '1' else '0' },
        image = rawInput.drop(2).map { row -> row.map { if (it == '#') '1' else '0' }.joinToString("") },
    )

    override fun solvePartOne() = enhance(2)

    override fun solvePartTwo() = enhance(50)

    private fun enhance(steps: Int) = (0 until steps).fold(input.image) { image, step ->
        val outside = when (input.algorithm.first() == '1') {
            true -> if (step % 2 == 0) input.algorithm.last() else input.algorithm.first()
            false -> '0'
        }
        (-1..image.size).map { y ->
            (-1..image.first().length).map { x ->
                (-1..1).flatMap { dy -> (-1..1).map { dx -> dy to dx } }
                    .map { (dy, dx) -> y + dy to x + dx }
                    .joinToString("") { (y, x) -> (image.getOrNull(y)?.getOrNull(x) ?: outside).toString() }
                    .toInt(2).let { input.algorithm[it] }
            }.joinToString("")
        }
    }.sumOf { row -> row.count { it == '1' } }

    data class TrenchMap(
        val algorithm: List<Char>,
        val image: List<String>,
    )
}
