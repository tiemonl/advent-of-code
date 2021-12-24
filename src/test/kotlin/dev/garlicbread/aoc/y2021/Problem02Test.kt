package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem02Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem02() }

    @Test
    fun problem02_1() {
        runTest("_1", 150, 900)
    }
}