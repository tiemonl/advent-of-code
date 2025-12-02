package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.fileInputProvider
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 25")
internal class Problem25Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem25(fileInputProvider<Problem25>("_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(58)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem25(fileInputProvider<Problem25>())
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(482)
        }
    }
}
