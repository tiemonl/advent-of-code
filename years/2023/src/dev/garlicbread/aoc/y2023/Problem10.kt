package dev.garlicbread.aoc.y2023

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Direction
import dev.garlicbread.aoc.models.Point
import dev.garlicbread.aoc.utils.elementAt
import dev.garlicbread.aoc.utils.isSafe

fun main() = solve(
    benchmark = false,
) { Problem10() }

@AocProblem(year = 2023, day = 10, name = "Pipe Maze")
class Problem10(
    inputProvider: InputProvider = fileInputProvider<Problem10>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideStringListInput().map { it.toList() }

    override fun solvePartOne(): Any {
        val startingPoint =
            input.mapIndexed { index, chars -> Point(chars.indexOfFirst { it == 'S' }, index) }.first { it.x != -1 }
        val pipes = mutableListOf('S' to startingPoint)
        var nextMove: Pair<Point, Direction> = when {
            input.isSafe(startingPoint.up()) && input.elementAt(startingPoint.up()) in charArrayOf(
                '|',
                '7',
                'F'
            ) -> startingPoint.up() to Direction.North

            startingPoint.down().x >= 0 && startingPoint.down().y >= 0 && input[startingPoint.down().y][startingPoint.down().x] in charArrayOf(
                '|',
                'L',
                'J'
            ) -> startingPoint.down() to Direction.South

            startingPoint.left().x >= 0 && startingPoint.left().y >= 0 && input[startingPoint.left().y][startingPoint.left().x] in charArrayOf(
                '-',
                'L',
                'F'
            ) -> startingPoint.left() to Direction.West

            startingPoint.right().x >= 0 && startingPoint.right().y >= 0 && input[startingPoint.right().y][startingPoint.right().x] in charArrayOf(
                '-',
                '7',
                'J'
            ) -> startingPoint.right() to Direction.East

            else -> Pair(startingPoint, Direction.East)
        }
        while (input[nextMove.first.y][nextMove.first.x] != 'S') {
            pipes.add(input[nextMove.first.y][nextMove.first.x] to nextMove.first)
            val pipe = input[nextMove.first.y][nextMove.first.x]
            val currentPipe = pipe.direction()
            val opposite = currentPipe.toList().filterNot { it == nextMove.second.opposite() }.first()
            nextMove = nextMove.first.move(opposite) to opposite
        }
        return pipes.size / 2
    }

    override fun solvePartTwo(): Any {
        return 0
    }

    private fun Char.direction() = when (this) {
        '|' -> Pair(Direction.North, Direction.South)
        '-' -> Pair(Direction.East, Direction.West)
        'L' -> Pair(Direction.North, Direction.East)
        'J' -> Pair(Direction.North, Direction.West)
        '7' -> Pair(Direction.South, Direction.West)
        'F' -> Pair(Direction.South, Direction.East)
        else -> throw IllegalArgumentException()
    }

    private fun Direction.opposite() = when (this) {
        Direction.North -> Direction.South
        Direction.East -> Direction.West
        Direction.South -> Direction.North
        Direction.West -> Direction.East
    }

    //    private fun List<List<Char>>.floodFill(at: Point, c: Char) {
//        if (!isSafe(at)) return
//        val queue = ArrayDeque<Point>().apply { add(at) }
//        while (queue.isNotEmpty()) {
//            val next = queue.removeFirst()
//            if (this[next] == '.') {
//                this[next] = c
//                queue.addAll(next.cardinalNeighbors().filter { isSafe(it) })
//            }
//        }
//    }
}
