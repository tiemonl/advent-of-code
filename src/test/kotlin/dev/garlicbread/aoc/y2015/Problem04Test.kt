package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem04Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem04() }

    @Test
    fun problem04_1() {
        runTest("_1", 609043, 6742839)
    }
}