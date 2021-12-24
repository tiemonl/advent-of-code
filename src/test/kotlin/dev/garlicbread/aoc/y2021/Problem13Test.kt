package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem13Test : PuzzleTest<Int, String>() {
    override val puzzle = { Problem13() }

    @Test
    fun problem13_1() {
        runTest(
            "_1",
            17,
            """
                |
                |XXXXX
                |X   X
                |X   X
                |X   X
                |XXXXX
            """.trimMargin()
        )
    }
}