package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem05() }

class Problem05(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<String, String>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput()

    override fun solvePartOne(): String = operateCrane(parseInput(), true)
        .map { it.last() }.joinToString("")

    override fun solvePartTwo(): String = operateCrane(parseInput(), false)
        .map { it.last() }.joinToString("")

    private fun parseInput() = input.joinToString("\n").split("\n\n").let { (crates, instructions) ->
        Crane(
            crates.toCrates(),
            instructions.split("\n").map { it.toInstruction() },
        )
    }

    private fun operateCrane(crane: Crane, reverse: Boolean): List<MutableList<Char>> {
        crane.instructions.forEach { instruction ->
            val pop = crane.crates[instruction.from].takeLast(instruction.amount)
            repeat(instruction.amount) { crane.crates[instruction.from].removeLast() }
            crane.crates[instruction.to].addAll(if (reverse) pop.reversed() else pop)
        }
        return crane.crates
    }

    private fun String.toCrates(): List<MutableList<Char>> {
        val rows = this.split("\n").reversed()
        val crates = (1..rows.first().chunked(4).size).map { mutableListOf<Char>() }
        rows.forEachIndexed { index, row ->
            if (index != 0) {
                row.chunked(4).forEachIndexed { i, crate ->
                    if (crate.trim().isNotEmpty()) {
                        crates[i].add(crate.trim().drop(1).dropLast(1).first())
                    }
                }
            }
        }
        return crates
    }

    private fun String.toInstruction(): Instruction = this.split(" from ").let { (move, cranes) ->
        Instruction(
            amount = move.split(" ").last().toInt(),
            from = cranes.take(1).toInt() - 1,
            to = cranes.takeLast(1).toInt() - 1,
        )
    }

    data class Crane(
        val crates: List<MutableList<Char>>,
        val instructions: List<Instruction>,
    )

    data class Instruction(
        val amount: Int,
        val from: Int,
        val to: Int,
    )

    companion object {
        val METADATA = PuzzleMetadata(year = 2022, day = 5, name = "Supply Stacks")
    }
}
