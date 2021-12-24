package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.models.Point
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = true
) { Problem05() }


class Problem05 : Puzzle<Int, Int>(
    year = 2021,
    day = 5
) {
    override val input = parseInput()

    override fun solvePartOne(): Int {
        val straights = findNonDiagonalLines()
        val spots = mutableListOf<Point>()
        straights.forEach { straight ->
            spots.addAll(straight.first.pointsInBetween(straight.second))
        }
        return spots.groupingBy { it }.eachCount().filter { it.value >= 2 }.entries.size
    }

    override fun solvePartTwo(): Int {
        val slopes45degree = listOf(Point(1, 1), Point(1, -1), Point(-1, 1), Point(-1, -1))
        val vents = mutableListOf<Pair<Point, Point>>()
        vents.addAll(findNonDiagonalLines())
        vents.addAll(input.filter { line -> slopes45degree.contains(line.first.slope(line.second)) })
        val spots = mutableListOf<Point>()
        vents.forEach { vent ->
            spots.addAll(vent.first.pointsInBetween(vent.second))
        }
        return spots.groupingBy { it }.eachCount().filter { it.value >= 2 }.entries.size
    }

    private fun parseInput(): List<Pair<Point, Point>> {
        val lists = mutableListOf<Pair<Point, Point>>()
        rawInput.map { it.split(" -> ") }.forEach {
            val first = it.first().split(",")
            val second = it.last().split(",")
            lists.add(
                Pair(
                    Point(first.first().toInt(), first.last().toInt()),
                    Point(second.first().toInt(), second.last().toInt())
                )
            )
        }
        return lists.toList()
    }

    private fun findNonDiagonalLines() = input.filter { it.first.x == it.second.x || it.first.y == it.second.y }
}