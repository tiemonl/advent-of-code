package dev.garlicbread.aoc.y2023

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2023 Day 4")
internal class Problem04Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem04(fileInputProvider<Problem04>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(13)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem04(fileInputProvider<Problem04>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(32001)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem04(fileInputProvider<Problem04>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(30)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem04(fileInputProvider<Problem04>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(5037841)
        }
    }
}
