package dev.garlicbread.aoc.y2023

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2023 Day 7")
internal class Problem07Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem07(fileInputProvider<Problem07>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(6440)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem07(fileInputProvider<Problem07>("_2"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(6592)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem07(fileInputProvider<Problem07>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(253638586)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem07(fileInputProvider<Problem07>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(5905)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem07(fileInputProvider<Problem07>("_2"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(6839)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem07(fileInputProvider<Problem07>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(253253225)
        }
    }
}
