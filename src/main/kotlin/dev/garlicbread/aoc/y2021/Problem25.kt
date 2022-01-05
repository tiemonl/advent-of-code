package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.models.Point
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = false
) { Problem25() }

class Problem25 : Puzzle<Int, Int>(
    year = 2021,
    day = 25
) {
    override val input = buildMap {
        rawInput.forEachIndexed { col, s ->
            s.forEachIndexed { row, cucumber ->
                this[Point(row, -col)] = cucumber
            }
        }
    }

    private val width = rawInput.first().length
    private val height = rawInput.size

    override fun solvePartOne(): Int {
        var grid = input
        var turns = 1
        do {
            grid = takeTurn(grid)
            turns++
        } while (isTurnPossible(grid))
        return turns
    }

    override fun solvePartTwo(): Int {
        return 0
    }

    private fun isTurnPossible(grid: Map<Point, Char>): Boolean {
        if (grid.filter { it.value == '>' }.filter {
            val right = it.key.right()
            grid[Point(right.x % width, right.y)] == '.'
        }.isNotEmpty()
        ) {
            return true
        }
        if (grid.filter { it.value == 'v' }.filter {
            val down = it.key.down()
            grid[Point(down.x, down.y % height)] == '.'
        }.isNotEmpty()
        ) {
            return true
        }
        return false
    }

    private fun takeTurn(grid: Map<Point, Char>): MutableMap<Point, Char> {
        val mutableGrid = grid.toMutableMap()
        val possibleEastMoves = mutableGrid.filter { it.value == '>' }.filter {
            val right = it.key.right()
            mutableGrid[Point(right.x % width, right.y)] == '.'
        }
        possibleEastMoves.forEach { cucumber ->
            val right = cucumber.key.right()
            mutableGrid[Point(right.x % width, right.y)] = '>'
            mutableGrid[cucumber.key] = '.'
        }
        val possibleSouthMoves = mutableGrid.filter { it.value == 'v' }.filter {
            val down = it.key.down()
            mutableGrid[Point(down.x, down.y % height)] == '.'
        }
        possibleSouthMoves.forEach { cucumber ->
            val down = cucumber.key.down()
            mutableGrid[Point(down.x, down.y % height)] = 'v'
            mutableGrid[cucumber.key] = '.'
        }
        return mutableGrid
    }
}
