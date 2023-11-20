package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 12")
internal class Problem12Test {

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
            val answer = Problem12().solvePartOne()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.suffix = "_2"
            val answer = Problem12().solvePartOne()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            Solver.suffix = "_3"
            val answer = Problem12().solvePartOne()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            Solver.suffix = "_4"
            val answer = Problem12().solvePartOne()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            Solver.suffix = "_5"
            val answer = Problem12().solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches example 6`() {
            Solver.suffix = "_6"
            val answer = Problem12().solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches example 7`() {
            Solver.suffix = "_7"
            val answer = Problem12().solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches example 8`() {
            Solver.suffix = "_8"
            val answer = Problem12().solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem12().solvePartOne()
            assertThat(answer).isEqualTo(119433)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.suffix = "_1"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.suffix = "_2"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            Solver.suffix = "_3"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            Solver.suffix = "_4"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            Solver.suffix = "_5"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches example 6`() {
            Solver.suffix = "_6"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches example 7`() {
            Solver.suffix = "_7"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches example 8`() {
            Solver.suffix = "_8"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 9")
        fun `Matches example 9`() {
            Solver.suffix = "_9"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(4)
        }

        @Test
        @DisplayName("Example Input 10")
        fun `Matches example 10`() {
            Solver.suffix = "_10"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 11")
        fun `Matches example 11`() {
            Solver.suffix = "_11"
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem12().solvePartTwo()
            assertThat(answer).isEqualTo(68466)
        }
    }
}
