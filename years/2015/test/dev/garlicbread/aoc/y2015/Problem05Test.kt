package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.StringInputProvider
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 5")
internal class Problem05Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem05(fileInputProvider<Problem05>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem05(fileInputProvider<Problem05>("_2"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem05(fileInputProvider<Problem05>("_3"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            val puzzle = Problem05(fileInputProvider<Problem05>("_4"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            val puzzle = Problem05(fileInputProvider<Problem05>("_5"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem05(fileInputProvider<Problem05>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(236)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem05(StringInputProvider("qjhvhtzxzqqjkmpb"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem05(StringInputProvider("xxyxx"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(1)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem05(StringInputProvider("uurcxstgmygtbstg"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            val puzzle = Problem05(StringInputProvider("ieodomkazucvgmuy"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem05(fileInputProvider<Problem05>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(51)
        }
    }
}
