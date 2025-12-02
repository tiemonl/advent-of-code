package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 20")
internal class Problem20Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem20(fileInputProvider<Problem20>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(35)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem20(fileInputProvider<Problem20>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(5268)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem20(fileInputProvider<Problem20>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(3351)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem20(fileInputProvider<Problem20>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(16875)
        }
    }
}
