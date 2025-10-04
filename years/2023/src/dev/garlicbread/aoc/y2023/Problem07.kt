package dev.garlicbread.aoc.y2023

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem07() }

class Problem07(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput().map { cardBid ->
        cardBid.split(" ").let { (card, bid) ->
            CamelCard(
                hand = card,
                bid = bid.toInt(),
            )
        }
    }

    override fun solvePartOne() = input.sortedWith(
        compareBy({ it.hand.handType(it.joker).value }, { it })
    ).calculateScore()


    override fun solvePartTwo() = input.map { it.copy(joker = true) }.sortedWith(
        compareBy({ it.hand.handType(it.joker).value }, { it })
    ).calculateScore()


    data class CamelCard(
        val hand: String,
        val bid: Int,
        val joker: Boolean = false,
    ) : Comparable<CamelCard> {
        override fun compareTo(other: CamelCard): Int {
            this.hand.zip(other.hand).forEach { (mine, other) ->
                val diff = mine.score(joker) - other.score(joker)
                if (diff != 0) return diff
            }
            return 0
        }

        private fun Char.score(joker: Boolean) = when (this) {
            'A' -> 14
            'K' -> 13
            'Q' -> 12
            'J' -> if (joker) 1 else 11
            'T' -> 10
            '9' -> 9
            '8' -> 8
            '7' -> 7
            '6' -> 6
            '5' -> 5
            '4' -> 4
            '3' -> 3
            else -> 2
        }
    }

    sealed class Hands(val value: Int) {
        data object FiveOfAKind : Hands(7)
        data object FourOfAKind : Hands(6)
        data object FullHouse : Hands(5)
        data object ThreeOfAKind : Hands(4)
        data object TwoPair : Hands(3)
        data object OnePair : Hands(2)
        data object HighCard : Hands(1)
    }

    private fun String.handType(joker: Boolean): Hands = this.let { cards ->
        val jokerCount = if (joker) cards.count { it == 'J' } else 0
        if (joker && jokerCount == 5) {
            Hands.FiveOfAKind
        } else {
            val hand = if (joker) cards.filterNot { it == 'J' } else cards
            val groupedHand = hand.groupingBy { count -> count }.eachCount().values.sortedDescending().toMutableList()
                .apply { if (joker) this[0] += jokerCount }

            when (groupedHand) {
                listOf(5) -> Hands.FiveOfAKind
                listOf(4, 1) -> Hands.FourOfAKind
                listOf(3, 2) -> Hands.FullHouse
                listOf(3, 1, 1) -> Hands.ThreeOfAKind
                listOf(2, 2, 1) -> Hands.TwoPair
                listOf(2, 1, 1, 1) -> Hands.OnePair
                else -> Hands.HighCard
            }
        }
    }

    private fun List<CamelCard>.calculateScore() =
        this.mapIndexed { index, camelCard -> index.inc() * camelCard.bid }.sum()

    companion object {
        val METADATA = PuzzleMetadata(year = 2023, day = 7, name = "Camel Cards")
    }
}
