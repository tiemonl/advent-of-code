package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.median
import java.util.Stack

fun main() = solve(
    benchmark = false,
) { Problem10() }

class Problem10(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Long>(
    metadata = METADATA
) {
    override val input = inputProvider.provideStringListInput()

    override fun solvePartOne(): Int {
        val unexpectedChar = mutableListOf<Int>()
        input.forEach {
            val stack = Stack<Char>()
            for (char in it.toList()) {
                if (char in setOf('(', '[', '{', '<')) {
                    stack.push(char)
                } else if (char in setOf(')', ']', '}', '>') && stack.peek() == getOppositeChar(char)) {
                    stack.pop()
                } else {
                    unexpectedChar.add(getCharValue(char))
                    break
                }
            }
        }
        return unexpectedChar.sumOf { it }
    }

    override fun solvePartTwo(): Long {
        val unfinishedLineEndings = mutableListOf<String>()
        input.forEach {
            val stack = Stack<Char>()
            var syntaxError = false
            for (char in it.toList()) {
                if (char in setOf('(', '[', '{', '<')) {
                    stack.push(char)
                } else if (char in setOf(')', ']', '}', '>') && stack.peek() == getOppositeChar(char)) {
                    stack.pop()
                } else {
                    syntaxError = true
                    break
                }
            }
            var lineEnd = ""
            while (stack.isNotEmpty() && !syntaxError) {
                lineEnd += getOppositeChar(stack.pop())
            }
            if (lineEnd.isNotEmpty()) unfinishedLineEndings.add(lineEnd)
        }
        return median(calculateScore(unfinishedLineEndings))
    }

    private fun calculateScore(unfinishedLineEndings: List<String>): List<Long> {
        val scores = mutableListOf<Long>()
        unfinishedLineEndings.forEach {
            var score = 0L
            it.toList().forEach { char ->
                score *= 5L
                score += getCharValuePart2(char)
            }
            scores.add(score)
        }
        return scores
    }

    private fun getOppositeChar(char: Char) =
        when (char) {
            ')' -> '('
            '}' -> '{'
            ']' -> '['
            '>' -> '<'
            '(' -> ')'
            '{' -> '}'
            '[' -> ']'
            else -> '>'
        }

    private fun getCharValue(char: Char) =
        when (char) {
            ')' -> 3
            '}' -> 1197
            ']' -> 57
            else -> 25137
        }

    private fun getCharValuePart2(char: Char) =
        when (char) {
            ')' -> 1
            '}' -> 3
            ']' -> 2
            else -> 4
        }

    companion object {
        val METADATA = PuzzleMetadata(year = 2021, day = 10, name = "")
    }
}
