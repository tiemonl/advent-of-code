package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.PuzzleTest
import org.junit.jupiter.api.Test

internal class Problem19Test : PuzzleTest<Int, Int>() {
    override val puzzle = { Problem19() }

    @Test
    fun problem19_1() {
        runTest("_1", 79, 3621)
    }
}