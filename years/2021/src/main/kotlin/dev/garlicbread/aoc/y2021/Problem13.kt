package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Point

fun main() = solve(
    benchmark = false,
) { Problem13() }

class Problem13(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, String>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput().joinToString("\n").split("\n\n")
    private lateinit var paper: Set<Point>
    private lateinit var folds: List<Fold>

    init {
        parseInput()
    }

    override fun solvePartOne(): Int {
        return paper.foldPaper(folds.first()).size
    }

    override fun solvePartTwo(): String {
        return printPaper(folds.fold(paper) { points, fold -> points.foldPaper(fold) })
    }

    private fun Set<Point>.foldPaper(fold: Fold): Set<Point> = map { point ->
        when (fold) {
            is Fold.X -> if (point.x > fold.at) point.copy(x = fold.at - (point.x - fold.at)) else point
            is Fold.Y -> if (point.y > fold.at) point.copy(y = fold.at - (point.y - fold.at)) else point
        }
    }.toSet()

    private fun parseInput() {
        paper = input[0].split("\n").map {
            val split = it.split(",")
            Point(split[0].toInt(), split[1].toInt())
        }.toSet()
        folds = input[1].split("\n").map {
            val split = it.split("=")
            when (split[0].last()) {
                'x' -> Fold.X(split[1].toInt())
                'y' -> Fold.Y(split[1].toInt())
                else -> error("Unrecognized fold axis")
            }
        }
    }

    private fun printPaper(foldedPaper: Set<Point>) =
        (0..foldedPaper.maxOf { it.y }).joinToString(prefix = "\n", separator = "\n") { y ->
            (0..foldedPaper.maxOf { it.x }).joinToString(separator = "") { x ->
                if (foldedPaper.any { p -> p.x == x && p.y == y }) "X" else " "
            }
        }

    sealed class Fold(val at: Int) {
        class X(at: Int) : Fold(at)
        class Y(at: Int) : Fold(at)
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2021, day = 13, name = "")
    }
}
