package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 25")
internal class Problem25Test {

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
            val answer = Problem25().solvePartOne()
            assertThat(answer).isEqualTo(58)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem25().solvePartOne()
            assertThat(answer).isEqualTo(482)
        }
    }
}
