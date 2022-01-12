package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve
import java.security.MessageDigest

fun main() = solve(
    benchmark = false
) { Problem04() }

class Problem04 : Puzzle<Int, Int>(
    year = 2015,
    day = 4
) {
    override val input = rawInput.first()

    var part1: Int = 0

    override fun solvePartOne(): Int {
        part1 = mineAdventCoins(
            input,
            0
        ) { it[0].toInt() == 0 && it[1].toInt() == 0 && it[2].toInt() in 0..15 }
        return part1
    }

    override fun solvePartTwo(): Int {
        return mineAdventCoins(
            input,
            part1
        ) { it[0].toInt() == 0 && it[1].toInt() == 0 && it[2].toInt() == 0 }
    }

    private fun mineAdventCoins(prefix: String, startWith: Int, predicate: (ByteArray) -> Boolean): Int {
        val digester: MessageDigest = MessageDigest.getInstance("MD5")

        for (n in startWith..Int.MAX_VALUE) {
            val digest = digester.digest((prefix + n).toByteArray()) ?: ByteArray(0)
            if (predicate(digest)) {
                return n
            }
        }
        throw error("No AdventCoin found")
    }
}
