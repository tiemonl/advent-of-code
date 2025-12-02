package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 9")
internal class Problem09Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem09(fileInputProvider<Problem09>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(15)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem09(fileInputProvider<Problem09>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(532)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem09(fileInputProvider<Problem09>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(1134)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem09(fileInputProvider<Problem09>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(1110780)
        }
    }
}
