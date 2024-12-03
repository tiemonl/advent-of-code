package dev.garlicbread.aoc.y2015

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.PuzzleMetadata
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2015 Day 7")
internal class Problem07Test {

    val metadata = PuzzleMetadata(year = 2015, day = 7)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches wire d`() {
            val answer = Problem07(wireSolution = "d", FileInputProvider(metadata, "_1")).solvePartOne()
            assertThat(answer).isEqualTo(72)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches wire e`() {
            val answer = Problem07(wireSolution = "e", FileInputProvider(metadata, "_1")).solvePartOne()
            assertThat(answer).isEqualTo(507)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches wire f`() {
            val answer = Problem07(wireSolution = "f", FileInputProvider(metadata, "_1")).solvePartOne()
            assertThat(answer).isEqualTo(492)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches wire g`() {
            val answer = Problem07(wireSolution = "g", FileInputProvider(metadata, "_1")).solvePartOne()
            assertThat(answer).isEqualTo(114)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches wire h`() {
            val answer = Problem07(wireSolution = "h", FileInputProvider(metadata, "_1")).solvePartOne()
            assertThat(answer).isEqualTo(65412)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches wire i`() {
            val answer = Problem07(wireSolution = "i", FileInputProvider(metadata, "_1")).solvePartOne()
            assertThat(answer).isEqualTo(65079)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches wire x`() {
            val answer = Problem07(wireSolution = "x", FileInputProvider(metadata, "_1")).solvePartOne()
            assertThat(answer).isEqualTo(123)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches wire y`() {
            val answer = Problem07(wireSolution = "y", FileInputProvider(metadata, "_1")).solvePartOne()
            assertThat(answer).isEqualTo(456)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem07(inputProvider = FileInputProvider(metadata))
            val answer = puzzle.solvePartOne()
            assertThat(answer).isEqualTo(956)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches wire d`() {
            val answer = Problem07(wireSolution = "d", FileInputProvider(metadata, "_1")).solvePartTwo()
            assertThat(answer).isEqualTo(72)
        }

        @Test
        @DisplayName("Example Input 2")
        fun `Matches wire e`() {
            val answer = Problem07(wireSolution = "e", FileInputProvider(metadata, "_1")).solvePartTwo()
            assertThat(answer).isEqualTo(507)
        }

        @Test
        @DisplayName("Example Input 3")
        fun `Matches wire f`() {
            val answer = Problem07(wireSolution = "f", FileInputProvider(metadata, "_1")).solvePartTwo()
            assertThat(answer).isEqualTo(492)
        }

        @Test
        @DisplayName("Example Input 4")
        fun `Matches wire g`() {
            val answer = Problem07(wireSolution = "g", FileInputProvider(metadata, "_1")).solvePartTwo()
            assertThat(answer).isEqualTo(114)
        }

        @Test
        @DisplayName("Example Input 5")
        fun `Matches wire h`() {
            val answer = Problem07(wireSolution = "h", FileInputProvider(metadata, "_1")).solvePartTwo()
            assertThat(answer).isEqualTo(65412)
        }

        @Test
        @DisplayName("Example Input 6")
        fun `Matches wire i`() {
            val answer = Problem07(wireSolution = "i", FileInputProvider(metadata, "_1")).solvePartTwo()
            assertThat(answer).isEqualTo(65079)
        }

        @Test
        @DisplayName("Example Input 7")
        fun `Matches wire x`() {
            val answer = Problem07(wireSolution = "x", FileInputProvider(metadata, "_1")).solvePartTwo()
            assertThat(answer).isEqualTo(123)
        }

        @Test
        @DisplayName("Example Input 8")
        fun `Matches wire y`() {
            val answer = Problem07(wireSolution = "y", FileInputProvider(metadata, "_1")).solvePartTwo()
            assertThat(answer).isEqualTo(456)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val puzzle = Problem07(inputProvider = FileInputProvider(metadata))
            val answer = puzzle.solvePartTwo()
            assertThat(answer).isEqualTo(40149)
        }
    }
}
