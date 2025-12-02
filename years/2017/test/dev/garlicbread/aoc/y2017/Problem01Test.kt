package dev.garlicbread.aoc.y2017

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2017 Day 1")
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
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_2"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(4)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_3"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_4"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(9)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem01(fileInputProvider<Problem01>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(1216)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_5"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches example 6`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_6"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches example 7`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_7"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(4)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches example 8`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_8"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(12)
        }

        @Test
        @DisplayName("Example Input 9")
        fun `Matches example 9`() {
            val puzzle = Problem01(fileInputProvider<Problem01>("_9"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(4)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem01(fileInputProvider<Problem01>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(1072)
        }
    }
}
