package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 7")
internal class Problem07Test {

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
        fun `Matches wire d`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "d").solvePartOne()
            assertThat(answer).isEqualTo(72)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches wire e`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "e").solvePartOne()
            assertThat(answer).isEqualTo(507)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches wire f`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "f").solvePartOne()
            assertThat(answer).isEqualTo(492)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches wire g`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "g").solvePartOne()
            assertThat(answer).isEqualTo(114)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches wire h`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "h").solvePartOne()
            assertThat(answer).isEqualTo(65412)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches wire i`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "i").solvePartOne()
            assertThat(answer).isEqualTo(65079)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches wire x`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "x").solvePartOne()
            assertThat(answer).isEqualTo(123)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches wire y`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "y").solvePartOne()
            assertThat(answer).isEqualTo(456)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem07().solvePartOne()
            assertThat(answer).isEqualTo(956)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches wire d`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "d").solvePartOne()
            assertThat(answer).isEqualTo(72)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches wire e`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "e").solvePartOne()
            assertThat(answer).isEqualTo(507)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches wire f`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "f").solvePartOne()
            assertThat(answer).isEqualTo(492)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches wire g`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "g").solvePartOne()
            assertThat(answer).isEqualTo(114)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches wire h`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "h").solvePartOne()
            assertThat(answer).isEqualTo(65412)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches wire i`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "i").solvePartOne()
            assertThat(answer).isEqualTo(65079)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches wire x`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "x").solvePartOne()
            assertThat(answer).isEqualTo(123)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches wire y`() {
            Solver.suffix = "_1"
            val answer = Problem07(wireSolution = "y").solvePartOne()
            assertThat(answer).isEqualTo(456)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem07().solvePartTwo()
            assertThat(answer).isEqualTo(40149)
        }
    }
}
