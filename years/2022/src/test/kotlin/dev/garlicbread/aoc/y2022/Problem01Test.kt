package dev.garlicbread.aoc.y2022

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2022 Day 1")
internal class Problem01Test {

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
            Solver.suffix = "_1"
            val answer = Problem01().solvePartOne()
            assertThat(answer).isEqualTo(24000)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem01().solvePartOne()
            assertThat(answer).isEqualTo(69281)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.suffix = "_1"
            val answer = Problem01().solvePartTwo()
            assertThat(answer).isEqualTo(45000)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem01().solvePartTwo()
            assertThat(answer).isEqualTo(201524)
        }
    }
}
