package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem17Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem17() }

    @Test
    fun problem17_1() {
        runTest("_1", 45, 112)
    }
}