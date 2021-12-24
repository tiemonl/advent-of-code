package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem09Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem09() }

    @Test
    fun problem09_1() {
        runTest("_1", 15, 1134)
    }
}