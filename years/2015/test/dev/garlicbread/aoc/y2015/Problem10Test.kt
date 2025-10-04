package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.PuzzleMetadata
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 10")
internal class Problem10Test {

    val metadata = PuzzleMetadata(year = 2015, day = 10)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val answer = Problem10(repetitions = 5, FileInputProvider(metadata, "_1")).solvePartOne()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem10(inputProvider = FileInputProvider(metadata)).solvePartOne()
            assertThat(answer).isEqualTo(492982)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val answer = Problem10(repetitions = 5, FileInputProvider(metadata, "_1")).solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem10(inputProvider = FileInputProvider(metadata)).solvePartTwo()
            assertThat(answer).isEqualTo(6989950)
        }
    }
}
