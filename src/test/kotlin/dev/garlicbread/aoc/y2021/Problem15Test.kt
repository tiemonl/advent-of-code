package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem15Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem15() }

    @Test
    fun problem15_1() {
        runTest("_1", 40, 315)
    }
}