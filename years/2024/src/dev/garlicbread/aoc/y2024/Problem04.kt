package dev.garlicbread.aoc.y2024

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.GridDirection
import dev.garlicbread.aoc.models.Point
import dev.garlicbread.aoc.utils.isSafe

fun main() =
    solve(
        benchmark = true,
    ) { Problem04() }

class Problem04(
    inputProvider: InputProvider = FileInputProvider(METADATA),
) : Puzzle<Any, Any>(
    metadata = METADATA,
) {
    override val input = inputProvider.provideStringListInput().map { it.map { char -> char } }

    override fun solvePartOne(): Any {
        var wordMatches = 0
        for (x in input.indices) {
            for (y in input[x].indices) {
                if (input[x][y] == 'X') {
                    wordMatches += checkXmas(Point(0, 0).neighbors(diagonal = true), Point(x, y))
                }
            }
        }
        return wordMatches
    }

    private fun checkXmas(neighbors: List<Point>, point: Point): Int {
        return neighbors.count { dir -> checkXmas(point, dir) }
    }

    private fun checkXmas(point: Point, direction: Point): Boolean {
        val mPoint = point + direction
        val aPoint = mPoint + direction
        val sPoint = aPoint + direction
        return input.isSafe(mPoint) &&
                input.isSafe(aPoint) &&
                input.isSafe(sPoint) &&
                input[mPoint.x][mPoint.y] == 'M' &&
                input[aPoint.x][aPoint.y] == 'A' &&
                input[sPoint.x][sPoint.y] == 'S'
    }

    override fun solvePartTwo(): Any {
        val diagonalRightDirections =
            listOf(
                GridDirection.NorthEast.point,
                GridDirection.SouthWest.point,
            )
        val diagonalLeftDirections =
            listOf(
                GridDirection.NorthWest.point,
                GridDirection.SouthEast.point,
            )
        var count = 0
        for (x in input.indices) {
            for (y in input[x].indices) {
                if (input[x][y] == 'A') {
                    val xmasRight =
                        diagonalRightDirections.map {
                            it + Point(x, y)
                        }
                    val xmasLeft =
                        diagonalLeftDirections.map {
                            it + Point(x, y)
                        }
                    if (xmasRight.count { point -> input.isSafe(point) && input[point.x][point.y] == 'M' } == 1 &&
                        xmasRight.count { point -> input.isSafe(point) && input[point.x][point.y] == 'S' } == 1 &&
                        xmasLeft.count { point -> input.isSafe(point) && input[point.x][point.y] == 'M' } == 1 &&
                        xmasLeft.count { point -> input.isSafe(point) && input[point.x][point.y] == 'S' } == 1
                    ) {
                        count++
                    }
                }
            }
        }
        return count
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2024, day = 4, name = "Ceres Search")
    }
}
