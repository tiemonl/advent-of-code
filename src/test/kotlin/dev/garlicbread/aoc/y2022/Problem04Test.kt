package dev.garlicbread.aoc.y2022

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2022 Day 4")
internal class Problem04Test {

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
            val answer = Problem04().solvePartOne()
            assertThat(answer).isEqualTo(2)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem04().solvePartOne()
            assertThat(answer).isEqualTo(509)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.suffix = "_1"
            val answer = Problem04().solvePartTwo()
            assertThat(answer).isEqualTo(4)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem04().solvePartTwo()
            assertThat(answer).isEqualTo(870)
        }
    }
}
