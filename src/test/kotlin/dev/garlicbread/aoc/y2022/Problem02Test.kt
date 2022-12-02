package dev.garlicbread.aoc.y2022

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2022 Day 2")
internal class Problem02Test {

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
            val answer = Problem02().solvePartOne()
            assertThat(answer).isEqualTo(15)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem02().solvePartOne()
            assertThat(answer).isEqualTo(14297)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.suffix = "_1"
            val answer = Problem02().solvePartTwo()
            assertThat(answer).isEqualTo(12)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem02().solvePartTwo()
            assertThat(answer).isEqualTo(10498)
        }
    }
}
