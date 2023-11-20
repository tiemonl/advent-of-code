package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 16")
internal class Problem16Test {

    @BeforeEach
    fun setUp() {
        Solver.suffix = ""
        Solver.inputProvider = Solver.defaultInputProvider
    }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.inputProvider = { _, _ -> listOf("D2FE28") }
            val answer = Problem16().solvePartOne()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.inputProvider = { _, _ -> listOf("38006F45291200") }
            val answer = Problem16().solvePartOne()
            assertThat(answer).isEqualTo(9)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            Solver.inputProvider = { _, _ -> listOf("EE00D40C823060") }
            val answer = Problem16().solvePartOne()
            assertThat(answer).isEqualTo(14)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            Solver.inputProvider = { _, _ -> listOf("8A004A801A8002F478") }
            val answer = Problem16().solvePartOne()
            assertThat(answer).isEqualTo(16)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            Solver.inputProvider = { _, _ -> listOf("620080001611562C8802118E34") }
            val answer = Problem16().solvePartOne()
            assertThat(answer).isEqualTo(12)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches example 6`() {
            Solver.inputProvider = { _, _ -> listOf("C0015000016115A2E0802F182340") }
            val answer = Problem16().solvePartOne()
            assertThat(answer).isEqualTo(23)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches example 7`() {
            Solver.inputProvider = { _, _ -> listOf("A0016C880162017C3686B18A3D4780") }
            val answer = Problem16().solvePartOne()
            assertThat(answer).isEqualTo(31)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem16().solvePartOne()
            assertThat(answer).isEqualTo(960)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.inputProvider = { _, _ -> listOf("C200B40A82") }
            val answer = Problem16().solvePartTwo()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.inputProvider = { _, _ -> listOf("04005AC33890") }
            val answer = Problem16().solvePartTwo()
            assertThat(answer).isEqualTo(54)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            Solver.inputProvider = { _, _ -> listOf("880086C3E88112") }
            val answer = Problem16().solvePartTwo()
            assertThat(answer).isEqualTo(7)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            Solver.inputProvider = { _, _ -> listOf("CE00C43D881120") }
            val answer = Problem16().solvePartTwo()
            assertThat(answer).isEqualTo(9)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            Solver.inputProvider = { _, _ -> listOf("D8005AC2A8F0") }
            val answer = Problem16().solvePartTwo()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches example 6`() {
            Solver.inputProvider = { _, _ -> listOf("F600BC2D8F") }
            val answer = Problem16().solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches example 7`() {
            Solver.inputProvider = { _, _ -> listOf("9C005AC2F8F0") }
            val answer = Problem16().solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches example 8`() {
            Solver.inputProvider = { _, _ -> listOf("9C0141080250320F1802104A08") }
            val answer = Problem16().solvePartTwo()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem16().solvePartTwo()
            assertThat(answer).isEqualTo(12301926782560)
        }
    }
}
