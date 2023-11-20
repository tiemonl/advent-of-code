package dev.garlicbread.aoc.y2022

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem02() }

class Problem02 : Puzzle<Int, Int>(
    year = 2022,
    day = 2,
) {
    override val input = rawInput.map { it.split(" ") }

    override fun solvePartOne(): Int {
        var score = 0
        val rounds = input.map {
            Round(
                when (it.first()) {
                    "A" -> Move.Rock
                    "B" -> Move.Paper
                    else -> Move.Scissors
                },
                when (it.last()) {
                    "X" -> Move.Rock
                    "Y" -> Move.Paper
                    else -> Move.Scissors
                },
            )
        }
        rounds.forEach { round ->
            val outcome = rockPaperScissors(round)
            score += round.userMove.score + outcome.score
        }
        return score
    }

    override fun solvePartTwo(): Int {
        var score = 0
        val rounds = input.map {
            DeterministicRound(
                when (it.first()) {
                    "A" -> Move.Rock
                    "B" -> Move.Paper
                    else -> Move.Scissors
                },
                when (it.last()) {
                    "X" -> Outcome.Lose
                    "Y" -> Outcome.Tie
                    else -> Outcome.Win
                },
            )
        }
        rounds.forEach { round ->
            val userMove = deterministicRockPaperScissors(round)
            score += userMove.score + round.outcome.score
        }
        return score
    }

    private fun rockPaperScissors(round: Round) = when (round.userMove) {
        Move.Rock -> when (round.opponentMove) {
            Move.Rock -> Outcome.Tie
            Move.Paper -> Outcome.Lose
            Move.Scissors -> Outcome.Win
        }

        Move.Paper -> when (round.opponentMove) {
            Move.Rock -> Outcome.Win
            Move.Paper -> Outcome.Tie
            Move.Scissors -> Outcome.Lose
        }

        Move.Scissors -> when (round.opponentMove) {
            Move.Rock -> Outcome.Lose
            Move.Paper -> Outcome.Win
            Move.Scissors -> Outcome.Tie
        }
    }

    private fun deterministicRockPaperScissors(round: DeterministicRound) = when (round.outcome) {
        Outcome.Win -> when (round.opponentMove) {
            Move.Rock -> Move.Paper
            Move.Paper -> Move.Scissors
            Move.Scissors -> Move.Rock
        }

        Outcome.Lose -> when (round.opponentMove) {
            Move.Rock -> Move.Scissors
            Move.Paper -> Move.Rock
            Move.Scissors -> Move.Paper
        }

        Outcome.Tie -> round.opponentMove
    }

    enum class Move(val score: Int) {
        Rock(score = 1),
        Paper(score = 2),
        Scissors(score = 3),
    }

    enum class Outcome(val score: Int) {
        Lose(score = 0),
        Tie(score = 3),
        Win(score = 6),
    }

    data class Round(val opponentMove: Move, val userMove: Move)

    data class DeterministicRound(val opponentMove: Move, val outcome: Outcome)
}
