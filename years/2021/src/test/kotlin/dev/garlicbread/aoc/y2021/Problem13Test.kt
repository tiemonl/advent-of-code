package dev.garlicbread.aoc.y2021

import com.google.common.truth.Truth.assertThat
import dev.garlicbread.aoc.core.Solver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("2021 Day 13")
internal class Problem13Test {

    @BeforeEach
    fun setUp() {
        Solver.suffix = ""
        Solver.inputProvider = Solver.defaultInputProvider
    }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.suffix = "_1"
            val answer = Problem13().solvePartOne()
            assertThat(answer).isEqualTo(17)
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem13().solvePartOne()
            assertThat(answer).isEqualTo(807)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        @DisplayName("Example Input 1")
        fun `Matches example 1`() {
            Solver.suffix = "_1"
            val answer = Problem13().solvePartTwo()
            assertThat(answer).isEqualTo(
                """
                |
                |XXXXX
                |X   X
                |X   X
                |X   X
                |XXXXX
                """.trimMargin(),
            )
        }

        @Test
        @DisplayName("Actual Input")
        fun `Matches actual`() {
            val answer = Problem13().solvePartTwo()
            assertThat(answer).isEqualTo(
                """
                |
                |X     XX  X  X XXXX  XX  X  X XXXX   XX
                |X    X  X X  X X    X  X X  X X       X
                |X    X    XXXX XXX  X    X  X XXX     X
                |X    X XX X  X X    X XX X  X X       X
                |X    X  X X  X X    X  X X  X X    X  X
                |XXXX  XXX X  X XXXX  XXX  XX  XXXX  XX 
                """.trimMargin(),
            )
        }
    }
}
