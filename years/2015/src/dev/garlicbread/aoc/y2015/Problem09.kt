package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.permutations

fun main() = solve(
    benchmark = false,
) { Problem09() }

class Problem09(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput().flatMap {
        it.split(" to ", " = ").let { (from, to, distance) ->
            listOf(
                Location(from, to, distance.toInt()),
                Location(to, from, distance.toInt()),
            )
        }
    }

    override fun solvePartOne() = createRoutes().minOf { it.value }

    override fun solvePartTwo() = createRoutes().maxOf { it.value }

    private fun createRoutes() = buildMap {
        val towns = input.distinctBy { it.from }.map { it.from }
        val routes = towns.permutations()
        routes.map { route ->
            var distance = 0
            for (town in 0 until route.size - 1) {
                distance += input.first { location -> location.from == route[town] && location.to == route[town + 1] }.distance
            }
            put(route, distance)
        }
    }

    data class Location(
        val from: String,
        val to: String,
        val distance: Int,
    )

    companion object {
        val METADATA = PuzzleMetadata(year = 2015, day = 9, name = "All in a Single Night")
    }
}
