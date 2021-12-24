package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem01Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem01() }

    @Test
    fun problem01_1() {
        runTest("_1", -1, 5)
    }
}