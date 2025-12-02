package dev.garlicbread.aoc.y2025

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2025 Day 1")
internal class Problem01Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem01(fileInputProvider<Problem01>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(1177)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem01(fileInputProvider<Problem01>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(6768)
        }
    }
}
