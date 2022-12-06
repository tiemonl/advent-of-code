package dev.garlicbread.aoc.y2022

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2022 Day 6")
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
            assertThat(answer).isEqualTo(7)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.suffix = "_2"
            val answer = Problem06().solvePartOne()
            assertThat(answer).isEqualTo(5)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            Solver.suffix = "_3"
            val answer = Problem06().solvePartOne()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            Solver.suffix = "_4"
            val answer = Problem06().solvePartOne()
            assertThat(answer).isEqualTo(10)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            Solver.suffix = "_5"
            val answer = Problem06().solvePartOne()
            assertThat(answer).isEqualTo(11)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem06().solvePartOne()
            assertThat(answer).isEqualTo(1198)
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
            assertThat(answer).isEqualTo(19)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.suffix = "_2"
            val answer = Problem06().solvePartTwo()
            assertThat(answer).isEqualTo(23)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            Solver.suffix = "_3"
            val answer = Problem06().solvePartTwo()
            assertThat(answer).isEqualTo(23)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            Solver.suffix = "_4"
            val answer = Problem06().solvePartTwo()
            assertThat(answer).isEqualTo(29)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            Solver.suffix = "_5"
            val answer = Problem06().solvePartTwo()
            assertThat(answer).isEqualTo(26)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem06().solvePartTwo()
            assertThat(answer).isEqualTo(3120)
        }
    }
}
