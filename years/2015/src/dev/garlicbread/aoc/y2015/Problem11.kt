package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve

fun main() = solve(
    benchmark = false,
) { Problem11() }

@AocProblem(year = 2015, day = 11, name = "Corporate Policy")
class Problem11(
    inputProvider: InputProvider = fileInputProvider<Problem11>()
) : Problem<String, String>() {
    override val input = inputProvider.provideStringInput()
    private val alphabet = "abcdefghijklmnopqrstuvwxyz"

    override fun solvePartOne(): String {
        return solvePassword(input)
    }

    override fun solvePartTwo(): String {
        val expiredPass = solvePassword(input).inc()
        return solvePassword(expiredPass)
    }

    private fun isValidPassword(pass: String): Boolean =
        threeInARow(pass) && twoSetsOfTwo(pass) && !containsIllegalChars(pass)

    private fun twoSetsOfTwo(pass: String): Boolean =
        pass.windowed(2).filter { str -> str[0] == str[1] }.distinct().size > 1

    private fun threeInARow(pass: String): Boolean = pass.windowed(3).any { alphabet.contains(it) }

    private fun containsIllegalChars(pass: String): Boolean = pass.any { it in "iol" }

    private fun solvePassword(pass: String): String {
        var password = pass
        while (!isValidPassword(password)) {
            password = password.inc()
        }
        return password
    }

    private fun String.inc(): String {
        val lastChar = alphabet.indexOf((this.last())).inc().mod(alphabet.length)
        return this.dropLast(1).let { if (lastChar == 0) it.inc() else it }.plus(alphabet[lastChar])
    }
}
