package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.transpose

fun main() = solve(
    benchmark = false,
) { Problem04() }

class Problem04 : Puzzle<Int, Int>(
    year = 2021,
    day = 4,
) {
    override val input = rawInput.joinToString("\n").split("\n\n")
    private val draw = mutableListOf<Int>()
    private val bingoBoards = mutableListOf<Bingo>()

    override fun solvePartOne(): Int {
        var result = 0
        parseBoards()
        for (i in 0 until draw.size) {
            val boards = drawNumber(draw[i])
            if (boards.isNotEmpty()) {
                result = calculateScore(boards.first(), draw[i])
                break
            }
        }
        return result
    }

    override fun solvePartTwo(): Int {
        lateinit var lastWinningBingoBoard: Pair<Bingo, Int>
        parseBoards()
        for (i in 0 until draw.size) {
            val bingo = drawNumber(draw[i])
            if (bingo.isNotEmpty()) {
                bingo.forEach {
                    bingoBoards.remove(it)
                    lastWinningBingoBoard = Pair(it, draw[i])
                }
            }
            if (bingoBoards.isEmpty()) {
                break
            }
        }
        return calculateScore(lastWinningBingoBoard.first, lastWinningBingoBoard.second)
    }

    private fun parseBoards() {
        draw.clear()
        bingoBoards.clear()
        draw.addAll(input.first().split(",").map { it.toInt() })
        input.drop(1).map { board ->
            board.split("\n").map { row ->
                row.split(" ").filter { it.isNotBlank() }.map { it.toInt() }
            }
        }.forEach { board ->
            bingoBoards.add(Bingo(board.map { row -> row.map { Cell(it) } }))
        }
    }

    private fun drawNumber(number: Int): List<Bingo> {
        val winningBoards = mutableListOf<Bingo>()
        bingoBoards.forEach { bingo ->
            bingo.board.flatten().firstOrNull { it.number == number }?.mark()
            if (checkWin(bingo)) winningBoards.add(bingo)
        }
        return winningBoards.toList()
    }

    private fun calculateScore(bingo: Bingo, finalDraw: Int) =
        finalDraw * bingo.board.flatten().filter { !it.isMarked }.sumOf { it.number }

    private fun checkWin(bingo: Bingo) =
        bingo.board.asSequence().map { row -> row.all { it.isMarked } }.any { it } ||
            bingo.transposedBoard.asSequence().map { col -> col.all { it.isMarked } }.any { it }

    data class Bingo(
        val board: List<List<Cell>>,
        val transposedBoard: List<List<Cell>> = board.transpose(),
    )

    data class Cell(
        val number: Int,
        var isMarked: Boolean = false,
    ) {
        fun mark() {
            isMarked = true
        }
    }
}
