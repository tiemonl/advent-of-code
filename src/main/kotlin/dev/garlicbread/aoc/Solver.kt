package dev.garlicbread.aoc

import java.nio.file.Files
import java.nio.file.Paths

object Solver {
    var suffix: String = ""
}

fun <T : Any, R : Any> solve(block: () -> Puzzle<T, R>) {
    val puzzle = block()
    val partOneResult = puzzle.solvePartOne().bold("33")
    val partTwoResult = puzzle.solvePartTwo().bold("33")
    println("Year ${puzzle.year}, Day ${puzzle.day}".bold())
    println("Part 1: $partOneResult")
    println("Part 2: $partTwoResult")
}

fun getInput(year: Int, day: Int): List<String> =
    Puzzle::class.java.classLoader.getResource("$year/input$day${Solver.suffix}.in")
        .toURI()
        .let { Paths.get(it) }
        .let { Files.readAllLines(it) }

private fun Any.bold(color: String = ""): String = style("$color;1")

private fun Any.style(color: String): String {
    return "\u001B[${color}m$this\u001B[0m"
}