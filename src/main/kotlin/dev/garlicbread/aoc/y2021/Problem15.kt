package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve
import java.util.*

fun main() = solve(
    benchmark = false
) { Problem15() }

class Problem15 : Puzzle<Int, Int>(
    year = 2021,
    day = 15,
    sample = false
) {
    override val input = rawInput.map { list ->
        list.map { risk ->
            risk.digitToInt()
        }
    }

    override fun solvePartOne(): Int {
        val graph = createGraph(1)
        return aStar(graph.first(), graph.last(), graph)
    }

    override fun solvePartTwo(): Int {
        val graph = createGraph(5)
        return aStar(graph.first(), graph.last(), graph)
    }

    private fun aStar(start: Location, end: Location, graph: List<Location>): Int {
        val costSoFar = mutableMapOf<Location, Int>().withDefault { Int.MAX_VALUE }
        costSoFar[start] = 0

        val openSet = PriorityQueue<Location>(end.x * end.y, compareBy { point -> costSoFar.getValue(point) })
        openSet.add(start)

        while (openSet.isNotEmpty()) {
            val current = openSet.remove()
            if (current == end) return costSoFar.getValue(end)

            current.neighbors(graph)
                .forEach { neighbor ->
                    val tentative = costSoFar.getValue(current) + neighbor.risk
                    if (tentative < costSoFar.getValue(neighbor)) {
                        costSoFar[neighbor] = tentative
                        openSet.add(neighbor)
                    }
                }
        }
        error("Path not found")
    }

    private fun createGraph(multiplier: Int): List<Location> {
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
        return vertical.flatMapIndexed { row, list -> list.mapIndexed { col, risk -> Location(row, col, risk) } }
    }

    private fun Location.neighbors(graph: List<Location>): List<Location> {
        val routes = mutableListOf<Location>()
        graph.firstOrNull { search -> this.x == search.x + 1 && this.y == search.y }?.let { right ->
            routes.add(right)
        }
        graph.firstOrNull { search -> this.x == search.x - 1 && this.y == search.y }?.let { left ->
            routes.add(left)
        }
        graph.firstOrNull { search -> this.x == search.x && this.y == search.y + 1 }?.let { up ->
            routes.add(up)
        }
        graph.firstOrNull { search -> this.x == search.x && this.y == search.y - 1 }?.let { down ->
            routes.add(down)
        }
        return routes
    }


    data class Location(val x: Int, val y: Int, val risk: Int)
}