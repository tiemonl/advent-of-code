package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 24")
internal class Problem24Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem24(fileInputProvider<Problem24>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(99299513899971)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem24(fileInputProvider<Problem24>())
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(93185111127911)
        }
    }
}
