package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem18Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem18() }

    @Test
    fun problem18_1() {
        runTest("_1", 4140, 3993)
    }
}