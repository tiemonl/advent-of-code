package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 6")
internal class Problem06Test {

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
            val answer = Problem06().solvePartOne()
            assertThat(answer).isEqualTo(998996)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.suffix = "_2"
            val answer = Problem06().solvePartOne()
            assertThat(answer).isEqualTo(999999)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem06().solvePartOne()
            assertThat(answer).isEqualTo(400410)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.suffix = "_1"
            val answer = Problem06().solvePartTwo()
            assertThat(answer).isEqualTo(1001996)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.suffix = "_2"
            val answer = Problem06().solvePartTwo()
            assertThat(answer).isEqualTo(2000001)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem06().solvePartTwo()
            assertThat(answer).isEqualTo(15343601)
        }
    }
}
