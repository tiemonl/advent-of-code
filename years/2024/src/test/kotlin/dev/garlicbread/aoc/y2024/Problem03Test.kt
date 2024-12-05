package dev.garlicbread.aoc.y2024

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.PuzzleMetadata
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2024 Day 3")
internal class Problem03Test() {

    val metadata = PuzzleMetadata(year = 2024, day = 3)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem03(FileInputProvider(metadata, "_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(161)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem03(FileInputProvider(metadata))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(173517243)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem03(FileInputProvider(metadata, "_2"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(48)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem03(FileInputProvider(metadata))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(100450138)
        }
    }
}