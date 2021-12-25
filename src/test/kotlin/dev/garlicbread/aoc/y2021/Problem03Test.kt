package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem03Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem03() }

    @Test
    fun problem03_1() {
        runTest("_1", 198, 230)
    }
}