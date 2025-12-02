package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.StringInputProvider
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 1")
internal class Problem01Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem01(StringInputProvider("(()(()("))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem01(StringInputProvider("()()"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem01(StringInputProvider("))((((("))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            val puzzle = Problem01(StringInputProvider(")())())"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(-3)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem01(fileInputProvider<Problem01>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(280)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem01(StringInputProvider("()())"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(5)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem01(StringInputProvider(")"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem01(fileInputProvider<Problem01>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(1797)
        }
    }
}
