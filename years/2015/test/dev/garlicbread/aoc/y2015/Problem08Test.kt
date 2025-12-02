package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 8")
internal class Problem08Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem08(fileInputProvider<Problem08>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(12)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem08(fileInputProvider<Problem08>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(1350)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem08(fileInputProvider<Problem08>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(19)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem08(fileInputProvider<Problem08>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(2085)
        }
    }
}
