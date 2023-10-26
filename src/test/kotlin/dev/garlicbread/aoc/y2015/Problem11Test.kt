package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 11")
internal class Problem11Test {

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
            val answer = Problem11().solvePartOne()
            assertThat(answer).isEqualTo("abcdffaa")
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            Solver.suffix = "_2"
            val answer = Problem11().solvePartOne()
            assertThat(answer).isEqualTo("ghjaabcc")
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem11().solvePartOne()
            assertThat(answer).isEqualTo("cqjxxyzz")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem11().solvePartTwo()
            assertThat(answer).isEqualTo("cqkaabcc")
        }
    }
}
