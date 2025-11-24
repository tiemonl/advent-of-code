package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Point

fun main() = solve(
    benchmark = false,
) { Problem02() }

class Problem02(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput().map { it.toCommand() }

    override fun solvePartOne(): Int {
        return input.fold(Point(0, 0)) { acc, command ->
            when (command) {
                is Command.Down -> acc + Point(0, command.amount)
                is Command.Forward -> acc + Point(command.amount, 0)
                is Command.Up -> acc + Point(0, -command.amount)
            }
        }.let { it.x * it.y }
    }

    override fun solvePartTwo(): Int {
        return input.fold(Pair(Point(0, 0), 0)) { (location, aim), command ->
            when (command) {
                is Command.Down -> location to aim + command.amount
                is Command.Forward -> location + Point(command.amount, aim * command.amount) to aim
                is Command.Up -> location to aim - command.amount
            }
        }.let { it.first.x * it.first.y }
    }

    private fun String.toCommand(): Command {
        return split(" ").let { (direction, value) ->
            val amount = value.toInt()
            when (direction) {
                "forward" -> Command.Forward(amount)
                "down" -> Command.Down(amount)
                "up" -> Command.Up(amount)
                else -> error("Unknown direction: $direction")
            }
        }
    }

    sealed class Command(val amount: Int) {
        class Forward(amount: Int) : Command(amount)
        class Down(amount: Int) : Command(amount)
        class Up(amount: Int) : Command(amount)
    }

    companion object {
        val METADATA = PuzzleMetadata(year = 2021, day = 2, name = "Dive!")
    }
}
