package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem16() }

class Problem16 : Puzzle<Int, Long>(
    year = 2021,
    day = 16,
) {
    override val input = rawInput.first().hexToBinary()

    override fun solvePartOne(): Int {
        return parse(input).sumOfVersions()
    }

    override fun solvePartTwo(): Long {
        return parse(input).value()
    }

    private fun parse(packet: String): Packet {
        val type = packet.drop(3).take(3).toInt(2)
        val rest = packet.drop(6)
        return when (type) {
            4 -> {
                rest.chunked(5)
                    .let { it.takeWhile { g -> g.first() == '1' } + it.first { g -> g.first() == '0' } }
                    .let { Packet.Literal("${packet.take(6)}${it.joinToString("")}") }
            }

            else -> {
                when (rest.first()) {
                    '1' -> {
                        val subpacketCount = rest.drop(1).take(11).toInt(2)
                        val subpackets = buildList<Packet> {
                            repeat(subpacketCount) {
                                parse(rest.drop(12 + sumOf { it.binary.length })).also { add(it) }
                            }
                        }
                        Packet.Operator("${packet.take(18)}${subpackets.joinToString("") { it.binary }}", subpackets)
                    }

                    else -> {
                        val totalLength = rest.drop(1).take(15).toInt(2)
                        val subpackets = buildList<Packet> {
                            while (totalLength - sumOf { it.binary.length } > 0) {
                                parse(rest.drop(16 + sumOf { it.binary.length })).also { add(it) }
                            }
                        }
                        Packet.Operator("${packet.take(22)}${subpackets.joinToString("") { it.binary }}", subpackets)
                    }
                }
            }
        }
    }

    sealed class Packet(val binary: String) {
        abstract fun sumOfVersions(): Int
        abstract fun value(): Long
        val type = binary.drop(3).take(3).toInt(2)

        class Literal(binary: String) : Packet(binary) {
            override fun sumOfVersions() = binary.take(3).toInt(2)
            override fun value() = binary.drop(6)
                .chunked(5)
                .joinToString("") { it.drop(1) }
                .toLong(2)
        }

        class Operator(binary: String, private val subpackets: List<Packet>) : Packet(binary) {
            override fun sumOfVersions() = binary.take(3).toInt(2) + subpackets.sumOf { it.sumOfVersions() }
            override fun value(): Long = when (type) {
                0 -> subpackets.sumOf { it.value() }
                1 -> subpackets.fold(1) { acc, packet -> acc.times(packet.value()) }
                2 -> subpackets.minOf { it.value() }
                3 -> subpackets.maxOf { it.value() }
                5 -> if (subpackets[0].value() > subpackets[1].value()) 1L else 0L
                6 -> if (subpackets[0].value() < subpackets[1].value()) 1L else 0L
                7 -> if (subpackets[0].value() == subpackets[1].value()) 1L else 0L
                else -> error("type $type not supported")
            }
        }
    }

    private fun String.hexToBinary() = this.map { it.digitToInt(16).toString(2).padStart(4, '0') }.joinToString("")
}
