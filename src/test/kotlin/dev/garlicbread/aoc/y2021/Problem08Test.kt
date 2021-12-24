package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem08Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem08() }

    @Test
    fun problem08_1() {
        runTest("_1", 26, 61229)
    }

    @Test
    fun problem08_2() {
        runTest("_2", 0, 5353)
    }
}