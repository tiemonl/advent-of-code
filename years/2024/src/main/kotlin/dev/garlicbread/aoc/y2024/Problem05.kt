package dev.garlicbread.aoc.y2024

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = true,
) { Problem05() }

class Problem05(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Any, Any>(
    metadata = METADATA,
) {
    override val input = inputProvider.provideStringListInput().joinToString("\n").split("\n\n").let { (rules, pages) ->
        Manual(
            rules.split("\n").map { it.split("|").let { (left, right) -> Pair(left.toInt(), right.toInt()) } },
            pages.split("\n").map { it.split(",").map { page -> page.toInt() } }
        )
    }

    override fun solvePartOne(): Any {
        return input.pages.sumOf {
            if (verifyUpdate(input.rules, it)) it[it.size / 2] else 0
        }
    }

    override fun solvePartTwo(): Any {
        val fixedPages = input.pages
            .filterNot { verifyUpdate(input.rules, it) }
            .map { orderPage(input.rules, it) }
        return fixedPages.sumOf { it[it.size / 2] }
    }

    private fun verifyUpdate(rules: List<Pair<Int, Int>>, page: List<Int>): Boolean {
        return rules.all {
            if (page.contains(it.first) && page.contains(it.second)) {
                page.indexOf(it.first) < page.indexOf(it.second)
            } else true
        }
    }

    private fun orderPage(rules: List<Pair<Int, Int>>, page: List<Int>): List<Int> {
        val newPage = page.toMutableList()
        rules.forEach { rule ->
            if (newPage.contains(rule.first) && newPage.contains(rule.second)) {
                if (newPage.indexOf(rule.first) > newPage.indexOf(rule.second)) {
                    val index = newPage.indexOf(rule.first)
                    newPage.removeAt(index)
                    newPage.add(newPage.indexOf(rule.second), rule.first)
                }
            }
        }
        return if (verifyUpdate(rules, newPage)) newPage else orderPage(rules, newPage)
    }

    data class Manual(
        val rules: List<Pair<Int, Int>>,
        val pages: List<List<Int>>
    )

    companion object {
        val METADATA = PuzzleMetadata(year = 2024, day = 5, name = "Print Queue")
    }
}
