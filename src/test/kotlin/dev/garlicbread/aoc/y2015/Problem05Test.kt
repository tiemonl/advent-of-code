package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 5")
internal class Problem05Test {

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
            Solver.inputProvider = { _, _ -> listOf("dvszwmarrgswjxmb") }
            val answer = Problem05().solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.inputProvider = { _, _ -> listOf("haegwjzuvuyypxyu") }
            val answer = Problem05().solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            Solver.inputProvider = { _, _ -> listOf("jchzalrnumimnmhp") }
            val answer = Problem05().solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            Solver.inputProvider = { _, _ -> listOf("ugknbfddgicrmopn") }
            val answer = Problem05().solvePartOne()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            Solver.inputProvider = { _, _ -> listOf("aaa") }
            val answer = Problem05().solvePartOne()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem05().solvePartOne()
            assertThat(answer).isEqualTo(236)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.inputProvider = { _, _ -> listOf("qjhvhtzxzqqjkmpb") }
            val answer = Problem05().solvePartTwo()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.inputProvider = { _, _ -> listOf("xxyxx") }
            val answer = Problem05().solvePartTwo()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            Solver.inputProvider = { _, _ -> listOf("uurcxstgmygtbstg") }
            val answer = Problem05().solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            Solver.inputProvider = { _, _ -> listOf("ieodomkazucvgmuy") }
            val answer = Problem05().solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem05().solvePartTwo()
            assertThat(answer).isEqualTo(51)
        }
    }
}
