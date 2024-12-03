package dev.garlicbread.aoc.y2023

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.product
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = solve(
    benchmark = false,
) { Problem06() }

class Problem06(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Any, Any>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput().let { (timeList, distanceList) ->
        val timeUnits = "\\d+".toRegex().findAll(timeList).map { it.value.toLong() }.toList()
        val distanceUnits = "\\d+".toRegex().findAll(distanceList).map { it.value.toLong() }.toList()
        timeUnits.mapIndexed { index, time ->
            BoatRace(
                time = time, distance = distanceUnits[index]
            )
        }
    }

    override fun solvePartOne() = input.map { race ->
        race.possibleWins().toInt()
    }.product()

    override fun solvePartTwo(): Long {
        val time = input.map { it.time }.joinToString("") { it.toString() }.toLong()
        val distance = input.map { it.distance }.joinToString("") { it.toString() }.toLong()
        return BoatRace(time, distance).possibleWins()
    }

    data class BoatRace(
        val time: Long,
        val distance: Long,
    ) {
        fun possibleWins(): Long {
            val low = (time.toDouble() - sqrt(time.toDouble().pow(2) - 4 * distance.toDouble())) / 2
            val high = (time.toDouble() + sqrt(time.toDouble().pow(2) - 4 * distance.toDouble())) / 2
            return ceil(high.dec()).toLong() - floor(low.inc()).toLong() + 1
        }
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2023, day = 6, name = "Wait For It")
    }
}
