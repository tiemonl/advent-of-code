package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = true
) { Problem03() }

class Problem03 : Puzzle<Int, Int>(
    year = 2021,
    day = 3
) {
    override val input = rawInput

    override fun solvePartOne(): Int {
        val lengthOfBinary = input[0].length
        var gamma = ""
        var epsilon = ""
        for (i in 0..lengthOfBinary.dec()) {
            gamma += if (input.count { it[i] == '1' } > input.size / 2) "1" else "0"
            epsilon += (1 - gamma[i].digitToInt()).toString()
        }
        return epsilon.toInt(2).times(gamma.toInt(2))
    }

    override fun solvePartTwo(): Int {
        val lengthOfBinary = input[0].length
        val oxygen = input.toMutableList()
        val co2 = input.toMutableList()
        for (i in 0..lengthOfBinary.dec()) {
            if (oxygen.size > 1) {
                val ones = oxygen.count { it[i] == '1' }
                val charToRemove = if (ones - (oxygen.size - ones) >= 0) '0' else '1'
                oxygen.removeAll(oxygen.filter { it[i] == charToRemove })
            }
            if (co2.size > 1) {
                val zeros = co2.count { it[i] == '0' }
                val charToRemove = if (zeros - (co2.size - zeros) <= 0) '1' else '0'
                co2.removeAll(co2.filter { it[i] == charToRemove })
            }
            if (oxygen.size == 1 && co2.size == 1) break
        }
        return oxygen.first().toInt(2) * co2.first().toInt(2)
    }
}