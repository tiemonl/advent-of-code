package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve
import dev.garlicbread.aoc.utils.median
import java.util.*

fun main() = solve(
    benchmark = true
) { Problem10() }

class Problem10 : Puzzle<Int, Long>(
    year = 2021,
    day = 10
) {
    override val input = rawInput

    override fun solvePartOne(): Int {
        val unexpectedChar = mutableListOf<Int>()
        input.forEach {
            val stack = Stack<Char>()
            for (char in it.toList()) {
                if (char in setOf('(', '[', '{', '<')) stack.push(char)
                else if (char in setOf(')', ']', '}', '>') && stack.peek() == getOppositeChar(char)) stack.pop()
                else {
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
                if (char in setOf('(', '[', '{', '<')) stack.push(char)
                else if (char in setOf(')', ']', '}', '>') && stack.peek() == getOppositeChar(char)) stack.pop()
                else {
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
        var score = calculateScore(unfinishedLineEndings)
        return median(score)
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
        if (char == ')') '(' else if (char == '}') '{' else if (char == ']') '[' else if (char == '>') '<'
        else if (char == '(') ')' else if (char == '{') '}' else if (char == '[') ']' else '>'

    private fun getCharValue(char: Char) =
        if (char == ')') 3 else if (char == '}') 1197 else if (char == ']') 57 else 25137

    private fun getCharValuePart2(char: Char) =
        if (char == ')') 1 else if (char == '}') 3 else if (char == ']') 2 else 4
}