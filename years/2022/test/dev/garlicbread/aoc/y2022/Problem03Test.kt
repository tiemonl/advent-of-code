package dev.garlicbread.aoc.y2022

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2022 Day 3")
internal class Problem03Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem03(fileInputProvider<Problem03>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(157)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem03(fileInputProvider<Problem03>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(7746)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem03(fileInputProvider<Problem03>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(70)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem03(fileInputProvider<Problem03>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(2604)
        }
    }
}
