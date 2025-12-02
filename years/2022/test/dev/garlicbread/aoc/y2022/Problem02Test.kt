package dev.garlicbread.aoc.y2022

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2022 Day 2")
internal class Problem02Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem02(fileInputProvider<Problem02>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(15)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem02(fileInputProvider<Problem02>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(14297)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem02(fileInputProvider<Problem02>("_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(12)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem02(fileInputProvider<Problem02>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(10498)
        }
    }
}
