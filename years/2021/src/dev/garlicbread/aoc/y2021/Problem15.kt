package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Point
import java.util.PriorityQueue

fun main() = solve(
    benchmark = false,
) { Problem15() }

class Problem15(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput().map { list ->
        list.map { risk ->
            risk.digitToInt()
        }
    }

    override fun solvePartOne(): Int {
        val graph = createGraph(1)
        return aStar(graph)
    }

    override fun solvePartTwo(): Int {
        val graph = createGraph(5)
        return aStar(graph)
    }

    private fun aStar(riskLevels: List<List<Int>>): Int {
        val dist = Array(riskLevels.size) { Array(riskLevels.first().size) { Int.MAX_VALUE } }.apply { this[0][0] = 0 }
        val toVisit = PriorityQueue<Point> { p1, p2 -> dist[p1.y][p1.x].compareTo(dist[p2.y][p2.x]) }
        val visited = mutableSetOf<Point>()
        toVisit.add(Point(0, 0))

        while (toVisit.isNotEmpty()) {
            val current = toVisit.poll().also { visited.add(it) }
            current.validNeighbours(riskLevels).forEach { neighbor ->
                if (!visited.contains(neighbor)) {
                    val newDistance = dist[current] + riskLevels[neighbor]
                    if (newDistance < dist[neighbor]) {
                        dist[neighbor] = newDistance
                        toVisit.add(neighbor)
                    }
                }
            }
        }

        return dist[dist.lastIndex][dist.last().lastIndex]
    }

    private fun createGraph(multiplier: Int): List<List<Int>> {
        val horizontal = input.map { row ->
            (1 until multiplier).fold(row) { acc, i ->
                acc + row.map { if (it + i > 9) ((it + i) % 10) + 1 else it + i; }
            }
        }
        val vertical = (1 until multiplier).fold(horizontal) { acc, i ->
            val allValuesIncremented = (horizontal.indices).map { y ->
                (0 until horizontal[0].size).map { x ->
                    val risk = horizontal[y][x]
                    if (risk + i > 9) ((risk + i) % 10) + 1 else risk + i
                }.toList()
            }
            acc + allValuesIncremented
        }
        return vertical.map { list -> list.map { risk -> risk } }
    }

    private operator fun Array<Array<Int>>.get(point: Point) = this[point.y][point.x]

    private operator fun Array<Array<Int>>.set(point: Point, value: Int) {
        this[point.y][point.x] = value
    }

    private operator fun List<List<Int>>.get(point: Point) = this[point.y][point.x]

    private fun Point.validNeighbours(riskLevels: List<List<Int>>): List<Point> {
        return neighbors().filter { (x, y) -> y in riskLevels.indices && x in riskLevels.first().indices }
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2021, day = 15, name = "")
    }
}
