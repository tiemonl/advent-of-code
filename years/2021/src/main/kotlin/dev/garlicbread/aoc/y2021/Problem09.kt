package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Point

fun main() = solve(
    benchmark = false,
) { Problem09() }

class Problem09 : Puzzle<Int, Int>(
    year = 2021,
    day = 9,
) {
    override val input = rawInput.map { it.toCharArray().map { char -> char.digitToInt() } }

    override fun solvePartOne(): Int {
        val lowPoints = getLowPoints()
        return lowPoints.sumOf { it.second }.plus(lowPoints.size)
    }

    override fun solvePartTwo(): Int {
        val lowPoints = getLowPoints()
        val basinSizes = mutableListOf<Int>()
        lowPoints.forEach { point ->
            basinSizes.add(getBasinPoints(point.first.x, point.first.y).size)
        }
        return basinSizes.sortedDescending().take(3).reduce { acc, i -> acc * i }
    }

    private fun getLowPoints(): List<Pair<Point, Int>> {
        val lowPoints = mutableListOf<Pair<Point, Int>>()
        for (row in 0..input.size.dec()) {
            for (col in 0..input[row].size.dec()) {
                if (isLowPoint(row, col)) {
                    lowPoints.add(Pair(Point(row, col), input[row][col]))
                }
            }
        }
        return lowPoints
    }

    private fun isLowPoint(row: Int, col: Int): Boolean {
        if (row - 1 >= 0 && input[row - 1][col] <= input[row][col]) return false
        if (row + 1 <= input.size.dec() && input[row + 1][col] <= input[row][col]) return false
        if (col - 1 >= 0 && input[row][col - 1] <= input[row][col]) return false
        return !(col + 1 <= input[row].size.dec() && input[row][col + 1] <= input[row][col])
    }

    private fun getBasinPoints(row: Int, col: Int): Set<Point> {
        val basinSize = mutableSetOf(Point(row, col))
        if (row - 1 >= 0 && input[row - 1][col] != 9 && input[row - 1][col] > input[row][col]) {
            basinSize.addAll(getBasinPoints(row - 1, col))
        }
        if (row + 1 <= input.size.dec() && input[row + 1][col] != 9 && input[row + 1][col] > input[row][col]) {
            basinSize.addAll(getBasinPoints(row + 1, col))
        }
        if (col - 1 >= 0 && input[row][col - 1] != 9 && input[row][col - 1] > input[row][col]) {
            basinSize.addAll(getBasinPoints(row, col - 1))
        }
        if (col + 1 <= input[row].size.dec() && input[row][col + 1] != 9 && input[row][col + 1] > input[row][col]) {
            basinSize.addAll(getBasinPoints(row, col + 1))
        }
        return basinSize
    }
}
