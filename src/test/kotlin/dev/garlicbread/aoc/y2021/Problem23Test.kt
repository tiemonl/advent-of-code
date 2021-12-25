package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem23Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem23() }

    @Test
    fun problem23_1() {
        runTest("_1", 12521, 44169)
    }
}