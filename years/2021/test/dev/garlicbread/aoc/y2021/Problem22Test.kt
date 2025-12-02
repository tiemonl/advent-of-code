package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 22")
internal class Problem22Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem22(fileInputProvider<Problem22>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(39)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem22(fileInputProvider<Problem22>("_2"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(590784)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem22(fileInputProvider<Problem22>("_3"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(474140)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem22(fileInputProvider<Problem22>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(648023)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem22(fileInputProvider<Problem22>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(39)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem22(fileInputProvider<Problem22>("_2"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(39769202357779)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem22(fileInputProvider<Problem22>("_3"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(2758514936282235)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem22(fileInputProvider<Problem22>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(1285677377848549)
        }
    }
}
