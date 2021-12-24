package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem10Test : PuzzleTest<Int, Long>() {
    override val puzzle = { Problem10() }

    @Test
    fun problem10_1() {
        runTest("_1", 26397, 288957)
    }
}