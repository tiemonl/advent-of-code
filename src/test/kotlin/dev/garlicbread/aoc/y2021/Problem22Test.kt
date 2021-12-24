package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem22Test : PuzzleTest<Long, Long>() {
    override val puzzle = { Problem22() }

    @Test
    fun problem22_1() {
        runTest("_1", 39, 39)
    }

    @Test
    fun problem22_2() {
        runTest("_2", 590784, 39769202357779)
    }

    @Test
    fun problem22_3() {
        runTest("_3", 474140, 2758514936282235)
    }
}