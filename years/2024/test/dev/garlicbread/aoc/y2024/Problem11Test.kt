package dev.garlicbread.aoc.y2024

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2024 Day 11")
internal class Problem11Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem11(fileInputProvider<Problem11>("_1"), blinks = 1)
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(7)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem11(fileInputProvider<Problem11>("_2"), blinks = 6)
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(22)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem11(fileInputProvider<Problem11>("_2"), blinks = 25)
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(55312)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem11(fileInputProvider<Problem11>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(200446)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem11(fileInputProvider<Problem11>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(238317474993392)
        }
    }
}
