package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem20Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem20() }

    @Test
    fun problem20_1() {
        runTest("_1", 35, 3351)
    }
}