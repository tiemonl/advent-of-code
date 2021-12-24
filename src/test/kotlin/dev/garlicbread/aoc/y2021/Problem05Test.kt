package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem05Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem05() }

    @Test
    fun problem05_1() {
        runTest("_1", 5, 12)
    }
}