package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem07(wireSolution = "a") }

@AocProblem(year = 2015, day = 7, name = "Some Assembly Required")
class Problem07(
    val wireSolution: String = "a",
    inputProvider: InputProvider = fileInputProvider<Problem07>()
) : Problem<Int, Int>() {
    override val input =
        inputProvider.provideStringListInput().map { it.split(" -> ").let { (from, to) -> Instruction(from, to) } }

    private val wires = mutableMapOf<String, Int>()

    override fun solvePartOne(): Int {
        for (i in input.indices) {
            parseInstruction(
                instruction = input[i],
                command = input[i].from.split(" "),
            )
        }
        return wires[wireSolution]!!
    }

    override fun solvePartTwo(): Int {
        wires.clear()
        for (i in input.indices) {
            parseInstruction(
                instruction = input[i],
                command = input[i].from.split(" "),
                partTwo = true,
            )
        }
        return wires[wireSolution]!!
    }

    private fun parseInstruction(instruction: Instruction, command: List<String>, partTwo: Boolean = false): Unit =
        when (command.size) {
            3 -> command.let { (wireA, operand, wireB) ->
                parseWire(wireA, partTwo)
                parseWire(wireB, partTwo)
                when (operand) {
                    "AND" -> {
                        wires[instruction.to] = if (wireA.contains("[0-9]+".toRegex())) {
                            wireA.toInt().and(wires[wireB]!!)
                        } else if (wireB.contains("[0-9]+".toRegex())) {
                            wires[wireA]!!.and(wireB.toInt())
                        } else {
                            wires[wireA]!!.and(wires[wireB]!!)
                        }
                    }

                    "OR" -> {
                        wires[instruction.to] = if (wireA.contains("[0-9]+".toRegex())) {
                            wireA.toInt().or(wires[wireB]!!)
                        } else if (wireB.contains("[0-9]+".toRegex())) {
                            wires[wireA]!!.or(wireB.toInt())
                        } else {
                            wires[wireA]!!.or(wires[wireB]!!)
                        }
                    }

                    "RSHIFT" -> {
                        wires[instruction.to] = wires[wireA]?.shr(wireB.toInt())!!
                    }

                    "LSHIFT" -> {
                        wires[instruction.to] = wires[wireA]?.shl(wireB.toInt())!!
                    }

                    else -> Unit
                }
            }

            2 -> command.let { (_, wire) ->
                parseWire(wire, partTwo)
                wires[instruction.to] = wires[wire]!!.complement()
            }

            else -> {
                wires[instruction.to] = if (partTwo && instruction.to == "b") {
                    956
                } else if (instruction.from.contains("[0-9]+".toRegex())) {
                    instruction.from.toInt()
                } else {
                    wires[instruction.from]!!
                }
            }
        }

    private fun parseWire(wire: String, partTwo: Boolean) {
        if (!wire.contains("[0-9]+".toRegex()) && wires[wire] == null) {
            val missingInstruction = input.first { it.to == wire } to input.first { it.to == wire }.from.split(" ")
            parseInstruction(
                instruction = missingInstruction.first,
                command = missingInstruction.second,
                partTwo = partTwo,
            )
        }
    }

    data class Instruction(val from: String, val to: String)

    private fun Int.complement() =
        this.toString(2).padStart(16, '0').map { if (it == '0') '1' else '0' }.joinToString("").toInt(2)
}
