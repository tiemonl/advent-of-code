package dev.garlicbread.aoc.core

abstract class Puzzle<T, U>(val year: Int, val day: Int, val name: String = "") {
    val rawInput = Solver.inputProvider(year, day)

    abstract val input: Any

    abstract fun solvePartOne(): T

    abstract fun solvePartTwo(): U
}
