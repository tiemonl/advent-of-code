package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem12Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem12() }

    @Test
    fun problem12_1() {
        runTest("_1", 10, 36)
    }

    @Test
    fun problem12_2() {
        runTest("_2", 19, 103)
    }

    @Test
    fun problem12_3() {
        runTest("_3", 226, 3509)
    }
}