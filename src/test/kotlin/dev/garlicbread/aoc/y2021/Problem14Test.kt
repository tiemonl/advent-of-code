package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem14Test : PuzzleTest<Long, Long>() {
    override val puzzle = { Problem14() }

    @Test
    fun problem14_1() {
        runTest("_1", 1588, 2188189693529L)
    }
}