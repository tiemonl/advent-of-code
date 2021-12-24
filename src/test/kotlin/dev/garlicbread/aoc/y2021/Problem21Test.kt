package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem21Test : PuzzleTest<Int, Long>() {
    override val puzzle = { Problem21() }

    @Test
    fun problem21_1() {
        runTest("_1", 739785, 444356092776315)
    }
}