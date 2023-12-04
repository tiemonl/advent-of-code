package dev.garlicbread.aoc.y2023

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve
import kotlin.math.pow

fun main() = solve(
    benchmark = false,
) { Problem04() }

class Problem04 : Puzzle<Int, Int>(
    year = 2023,
    day = 4,
    name = "Scratchcards",
) {
    override val input = rawInput.mapIndexed { index, game ->
        val scratchCard = game.split(": ").last().split(" | ")
        ScratchCard(
            id = index.inc(),
            winningNumbers = scratchCard.first().split(" ")
                .mapNotNull { it.takeIf { it.trim(); it.isNotBlank() }?.toInt() },
            pickedNumbers = scratchCard.last().split(" ")
                .mapNotNull { it.takeIf { it.trim(); it.isNotBlank() }?.toInt() },
        )
    }

    override fun solvePartOne() = input.sumOf {
        val correct = it.pickedNumbers.intersect(it.winningNumbers.toSet())
        if (correct.isNotEmpty()) 2.0.pow(correct.size - 1).toInt() else 0
    }

    override fun solvePartTwo() = input.sumOf { card ->
        val correct = card.pickedNumbers.intersect(card.winningNumbers.toSet()).size
        if (correct > 0) {
            for (x in card.id.inc()..card.id + correct) {
                input.filter { it.id == x }.forEach { it.amount += card.amount }
            }
        }
        card.amount
    }

    data class ScratchCard(
        val id: Int,
        val winningNumbers: List<Int>,
        val pickedNumbers: List<Int>,
        var amount: Int = 1,
    )
}
