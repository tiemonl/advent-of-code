package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem07Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem07() }

    @Test
    fun problem07_1() {
        runTest("_1", 37, 168)
    }
}