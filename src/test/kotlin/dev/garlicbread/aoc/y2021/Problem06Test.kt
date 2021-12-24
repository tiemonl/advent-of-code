package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem06Test : PuzzleTest<Long, Long>() {
    override val puzzle = { Problem06() }

    @Test
    fun problem06_1() {
        runTest("_1", 5934, 26984457539)
    }
}