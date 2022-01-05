package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = false
) { Problem21() }

class Problem21 : Puzzle<Int, Long>(
    year = 2021,
    day = 21
) {
    override val input = rawInput.map { it.substringAfterLast(": ").toInt() }

    private val diceOutcomes: Map<Int, Long> = mapOf(3 to 1, 4 to 3, 5 to 6, 6 to 7, 7 to 6, 8 to 3, 9 to 1)

    private val cache = mutableMapOf<GameState, WinCount>()

    override fun solvePartOne(): Int {
        var player1 = Player(input[0])
        var player2 = Player(input[1])
        val dice = Dice()
        while (true) {
            player1 = player1.turn(dice.roll())
            if (player1.score >= 1000) break
            player2 = player2.turn(dice.roll())
            if (player2.score >= 1000) break
        }
        return minOf(player1.score, player2.score) * dice.rolls
    }

    override fun solvePartTwo(): Long {
        return playWithDiracDice(GameState(Player(input.first()), Player(input.last()))).max()
    }

    private fun playWithDiracDice(gameState: GameState): WinCount {
        return when {
            gameState.p1State.score >= 21 -> WinCount(1, 0)
            gameState.p2State.score >= 21 -> WinCount(0, 1)
            else -> cache.getOrPut(gameState) {
                diceOutcomes.map { (forward, freq) -> playWithDiracDice(gameState.next(forward)) * freq }
                    .reduce { acc, count -> acc + count }
            }
        }
    }

    data class Player(val place: Int, val score: Int = 0) {
        fun turn(roll: Int): Player {
            val nextPlace = (place + roll - 1) % 10 + 1

            return Player(
                place = nextPlace,
                score = score + nextPlace
            )
        }
    }

    data class WinCount(val player1: Long, val player2: Long) {
        operator fun plus(other: WinCount): WinCount =
            WinCount(player1 + other.player1, player2 + other.player2)

        operator fun times(other: Long): WinCount =
            WinCount(player1 * other, player2 * other)

        fun max(): Long =
            maxOf(player1, player2)
    }

    data class Dice(var value: Int = 0, var rolls: Int = 0) {
        fun roll(): Int {
            rolls += 3
            value = (value + 3 - 1) % 100 + 1
            return 3 * value - 3
        }
    }

    data class GameState(val p1State: Player, val p2State: Player, val p1Turn: Boolean = true) {
        fun next(rollSum: Int): GameState {
            return GameState(
                if (p1Turn) p1State.turn(rollSum) else p1State,
                if (!p1Turn) p2State.turn(rollSum) else p2State,
                !p1Turn
            )
        }
    }
}
