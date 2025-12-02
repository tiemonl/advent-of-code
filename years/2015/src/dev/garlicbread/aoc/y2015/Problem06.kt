package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Point

fun main() = solve(
    benchmark = false,
) { Problem06() }

@AocProblem(year = 2015, day = 6, name = "Probably a Fire Hazard")
class Problem06(
    inputProvider: InputProvider = fileInputProvider<Problem06>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringListInput().map { it.toInstruction() }

    override fun solvePartOne(): Int {
        return input.fold(Array(1000) { BooleanArray(1000) }) { acc, instruction ->
            acc.apply {
                (instruction.range.first.x..instruction.range.second.x).map { x ->
                    (instruction.range.first.y..instruction.range.second.y).map { y ->
                        when (instruction) {
                            is Instruction.On -> this[x][y] = true
                            is Instruction.Toggle -> this[x][y] = !this[x][y]
                            is Instruction.Off -> this[x][y] = false
                        }
                    }
                }
            }
        }.sumOf { row -> row.count { it } }
    }

    override fun solvePartTwo(): Int {
        return input.fold(Array(1000) { IntArray(1000) }) { acc, instruction ->
            acc.apply {
                (instruction.range.first.x..instruction.range.second.x).map { x ->
                    (instruction.range.first.y..instruction.range.second.y).map { y ->
                        when (instruction) {
                            is Instruction.On -> ++this[x][y]
                            is Instruction.Toggle -> this[x][y] += 2
                            is Instruction.Off -> this[x][y] = if (this[x][y] > 0) --this[x][y] else 0
                        }
                    }
                }
            }
        }.sumOf { row -> row.sum() }
    }

    private fun String.toInstruction(): Instruction {
        return split(" ").reversed().let { (end, _, start, instruction) ->
            val s = start.split(",")
            val e = end.split(",")
            val range = Pair(Point(s.first().toInt(), s.last().toInt()), Point(e.first().toInt(), e.last().toInt()))
            when (instruction) {
                "on" -> Instruction.On(range)
                "toggle" -> Instruction.Toggle(range)
                "off" -> Instruction.Off(range)
                else -> error("Unknown instruction: $instruction")
            }
        }
    }

    sealed class Instruction(val range: Pair<Point, Point>) {
        class On(range: Pair<Point, Point>) : Instruction(range)
        class Toggle(range: Pair<Point, Point>) : Instruction(range)
        class Off(range: Pair<Point, Point>) : Instruction(range)
    }
}
