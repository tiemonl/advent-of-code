package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 14")
internal class Problem14Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem14(fileInputProvider<Problem14>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(1588)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem14(fileInputProvider<Problem14>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(2010)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem14(fileInputProvider<Problem14>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(2188189693529L)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem14(fileInputProvider<Problem14>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(2437698971143L)
        }
    }
}
