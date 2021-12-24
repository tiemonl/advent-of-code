package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem11Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem11() }

    @Test
    fun problem11_1() {
        runTest("_1", 1656, 195)
    }
}