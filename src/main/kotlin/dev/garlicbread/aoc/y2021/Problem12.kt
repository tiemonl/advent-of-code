package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = true
) { Problem12() }

class Problem12 : Puzzle<Int, Int>(
    year = 2021,
    day = 12,
    sample = false
) {
    override val input = rawInput.map { it.split("-") }.map { Pair(it.first(), it.last()) }

    override fun solvePartOne(): Int {
        return findPassages()
    }

    override fun solvePartTwo(): Int {
        return findPassages(isPart2 = true)
    }

    private fun findPassages(isPart2: Boolean = false): Int {
        val startingPoints = input.filter { "start" in it.toList() }
        val paths = mutableSetOf<List<String>>()
        startingPoints.forEach {
            val path = mutableListOf<String>()
            val to = if (it.first != "start") it.first else it.second
            path.add("start")
            paths.addAll(findPath(to, path, isPart2))
        }
        return paths.size
    }

    private fun findPath(
        from: String,
        currentPath: List<String> = emptyList(),
        isPart2: Boolean = false
    ): Set<List<String>> {
        val paths = mutableSetOf<List<String>>()
        val path = currentPath.toMutableList()
        path.add(from)
        val possiblePaths = input.filter { from in it.toList() && "start" !in it.toList() }
        possiblePaths.forEach { to ->
            val step = if (to.first != from) to.first else to.second
            if (step == "end") {
                path.add(step)
                paths.add(path)
                path.removeLast()
            } else if (!step.isUpper() && !path.contains(step)) {
                paths.addAll(findPath(step, path, isPart2))
            } else if (step.isUpper()) {
                paths.addAll(findPath(step, path, isPart2))
            } else if (isPart2 && !step.isUpper() &&
                path.filter { !it.isUpper() }.groupingBy { it }.eachCount().filterValues { it >= 2 }.isEmpty()
            ) {
                paths.addAll(findPath(step, path, isPart2))
            }
        }
        return paths
    }

    private fun String.isUpper() = this.uppercase() == this
}