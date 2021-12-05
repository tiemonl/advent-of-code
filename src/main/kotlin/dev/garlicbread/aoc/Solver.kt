package dev.garlicbread.aoc

import java.nio.file.Files
import java.nio.file.Paths

fun <T : Any, R : Any> solve(block: () -> Puzzle<T, R>) {
    val puzzle = block()
    val partOneResult = puzzle.solvePartOne().bold("36")
    val partTwoResult = puzzle.solvePartTwo().bold("36")
    println("Year ${puzzle.year}, Day ${puzzle.day}".bold())
    println("Part 1: $partOneResult")
    println("Part 2: $partTwoResult")
}

fun getInput(year: Int, day: Int, sample: Boolean = false): List<String> {
    val resource = if (!sample) "$year/puzzle/input$day.in" else "$year/sample/input$day.sample"
    return Puzzle::class.java.classLoader.getResource(resource)
        .toURI()
        .let { Paths.get(it) }
        .let { Files.readAllLines(it) }
}

private fun Any.bold(color: String = ""): String = style("$color;1")

private fun Any.style(color: String): String {
    return "\u001B[${color}m$this\u001B[0m"
}