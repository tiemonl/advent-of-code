package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Point

fun main() = solve(
    benchmark = false,
) { Problem11() }

class Problem11 : Puzzle<Int, Int>(
    year = 2021,
    day = 11,
) {
    override val input = rawInput.map { it.toList().map { char -> char.digitToInt() } }

    override fun solvePartOne(): Int {
        var grid = parse(input)
        var glowingSquids = 0
        for (i in 1..100) {
            val turn = grid.map { Grid(it.position, (it.energy + 1).rem(10)) }
            grid = checkSurroundings(turn)
            glowingSquids += grid.count { it.energy == 0 }
        }
        return glowingSquids
    }

    override fun solvePartTwo(): Int {
        var grid = parse(input)
        var steps = 0
        while (!grid.all { it.energy == 0 }) {
            val turn = grid.map { Grid(it.position, (it.energy + 1).rem(10)) }
            grid = checkSurroundings(turn)
            steps++
        }
        return steps
    }

    private fun parse(grid: List<List<Int>>): List<Grid> {
        val fullGrid = mutableListOf<Grid>()
        grid.forEachIndexed { row, list ->
            list.forEachIndexed { col, i ->
                fullGrid.add(Grid(Point(row, col), i))
            }
        }
        return fullGrid
    }

    private fun checkSurroundings(cleanGrid: List<Grid>): List<Grid> {
        val grid = cleanGrid.map { Grid(it.position, it.energy, hold = it.energy == 0, visited = it.visited) }
        val zeroes = grid.filter { it.energy == 0 && !it.visited }
        zeroes.forEach { cell ->
            grid.firstOrNull { it.position == cell.position && it.energy == 0 && it.hold }?.visited = true
            for (row in -1..1) {
                for (col in -1..1) {
                    grid.firstOrNull {
                        it.position == Point(
                            cell.position.x + row,
                            cell.position.y + col,
                        ) && !it.visited && !it.hold
                    }?.apply {
                        energy = energy.inc().rem(10)
                        hold = energy == 0
                    }
                }
            }
        }
        return if (grid.any { it.energy == 0 && !it.visited }) {
            checkSurroundings(grid)
        } else {
            grid
        }
    }

    data class Grid(
        val position: Point,
        var energy: Int,
        var hold: Boolean = false,
        var visited: Boolean = false,
    )
}
