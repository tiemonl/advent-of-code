package dev.garlicbread.aoc.y2023

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.PuzzleMetadata
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2023 Day 8")
internal class Problem08Test {

    val metadata = PuzzleMetadata(year = 2023, day = 8)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem08(FileInputProvider(metadata, "_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(2)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem08(FileInputProvider(metadata, "_2"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem08(FileInputProvider(metadata))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(12737)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem08(FileInputProvider(metadata, "_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(2)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem08(FileInputProvider(metadata, "_2"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem08(FileInputProvider(metadata, "_3"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem08(FileInputProvider(metadata))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(9064949303801)
        }
    }
}
