package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.PuzzleMetadata
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 12")
internal class Problem12Test {

    val metadata = PuzzleMetadata(year = 2015, day = 12)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_1"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_2"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_3"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_4"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_5"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches example 6`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_6"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches example 7`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_7"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches example 8`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_8"))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem12(FileInputProvider(metadata))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(119433)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_1"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches example 2`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_2"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches example 3`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_3"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches example 4`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_4"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches example 5`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_5"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches example 6`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_6"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches example 7`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_7"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches example 8`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_8"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 9")
        fun `Matches example 9`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_9"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(4)
        }

        @Test
        @DisplayName("Example Input 10")
        fun `Matches example 10`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_10"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        @DisplayName("Example Input 11")
        fun `Matches example 11`() {
            val puzzle = Problem12(FileInputProvider(metadata, "_11"))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem12(FileInputProvider(metadata))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(68466)
        }
    }
}
