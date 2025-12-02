package dev.garlicbread.aoc.core

abstract class Problem<T, U> {

    val metadata: ProblemMetadata by lazy {
        this::class.problemMetadata()
    }

    abstract val input: Any

    abstract fun solvePartOne(): T

    abstract fun solvePartTwo(): U
}
