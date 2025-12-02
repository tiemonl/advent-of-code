package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 12")
internal class Problem12Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem12(fileInputProvider<Problem12>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(10)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem12(fileInputProvider<Problem12>("_2"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(19)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem12(fileInputProvider<Problem12>("_3"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(226)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem12(fileInputProvider<Problem12>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(3856)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem12(fileInputProvider<Problem12>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(36)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem12(fileInputProvider<Problem12>("_2"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(103)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem12(fileInputProvider<Problem12>("_3"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(3509)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem12(fileInputProvider<Problem12>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(116692)
        }
    }
}
