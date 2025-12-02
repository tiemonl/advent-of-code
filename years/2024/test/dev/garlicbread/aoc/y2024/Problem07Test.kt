package dev.garlicbread.aoc.y2024

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2024 Day 7")
internal class Problem07Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem07(fileInputProvider<Problem07>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(3749)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem07(fileInputProvider<Problem07>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(5837374519342)
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
            assertThat(answer).isEqualTo(11387)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem07(fileInputProvider<Problem07>("_2"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem07(fileInputProvider<Problem07>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(492383931650959)
        }
    }
}
