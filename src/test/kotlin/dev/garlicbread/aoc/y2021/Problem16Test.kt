package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem16Test : PuzzleTest<Int, Long>() {
    override val puzzle = { Problem16() }

    @Test
    fun problem16_part1_tests() {
        testPartOne("D2FE28", 6)
        testPartOne("38006F45291200", 9)
        testPartOne("EE00D40C823060", 14)
        testPartOne("8A004A801A8002F478", 16)
        testPartOne("620080001611562C8802118E34", 12)
        testPartOne("C0015000016115A2E0802F182340", 23)
        testPartOne("A0016C880162017C3686B18A3D4780", 31)
    }

    @Test
    fun problem16_part2_tests() {
        testPartTwo("C200B40A82", 3L)
        testPartTwo("04005AC33890", 54L)
        testPartTwo("880086C3E88112", 7L)
        testPartTwo("CE00C43D881120", 9L)
        testPartTwo("D8005AC2A8F0", 1L)
        testPartTwo("F600BC2D8F", 0L)
        testPartTwo("9C005AC2F8F0", 0L)
        testPartTwo("9C0141080250320F1802104A08", 1L)
    }
}