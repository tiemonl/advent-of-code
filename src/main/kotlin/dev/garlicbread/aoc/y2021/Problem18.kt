package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve

fun main() = solve(
    benchmark = false
) { Problem18() }

class Problem18 : Puzzle<Int, Int>(
    year = 2021,
    day = 18,
    sample = false
) {
    override val input = rawInput.map { parse(it) }

    override fun solvePartOne() = input.reduce { acc, i ->
        SnailFishNumber.SnailPair(acc, i).apply { reduce() }
    }.magnitude()


    override fun solvePartTwo(): Int {
        var max = 0
        for (i in 0..rawInput.map { parse(it) }.size.dec()) {
            for (j in 0..rawInput.map { parse(it) }.size.dec()) {
                if (i != j) {
                    val temp = SnailFishNumber.SnailPair(rawInput.map { parse(it) }[i], rawInput.map { parse(it) }[j])
                        .apply { reduce() }.magnitude()
                    max = if (temp > max) temp else max
                }
            }
        }
        return max
    }

    private fun parse(str: String): SnailFishNumber {
        if (str.startsWith("[")) {
            var bracketCount = 0
            var commaIndex = 0
            for ((i, j) in str.withIndex()) {
                if (j == '[') bracketCount++
                else if (j == ']') bracketCount--
                else if (j == ',' && bracketCount == 1) {
                    commaIndex = i
                    break
                }
            }

            val left = str.take(commaIndex).drop(1)
            val right = str.drop(commaIndex + 1).dropLast(1)

            return SnailFishNumber.SnailPair(parse(left), parse(right))
        } else {
            return SnailFishNumber.Regular(str.toInt())
        }
    }

    sealed class SnailFishNumber(var parent: SnailPair? = null) {
        operator fun plus(other: SnailFishNumber) = SnailPair(this, other)
        abstract fun magnitude(): Int
        abstract fun addToLeftMost(value: Int)
        abstract fun addToRightMost(value: Int)
        abstract fun split(): Boolean
        abstract fun explode(depth: Int = 0): Pair<Int, Int>?

        fun reduce() {
            do {
                val exploded = explode() != null
                val split = if (!exploded) split() else false
            } while (exploded || split)
        }

        data class SnailPair(var left: SnailFishNumber, var right: SnailFishNumber) : SnailFishNumber() {
            init {
                left.parent = this
                right.parent = this
            }

            override fun magnitude() = 3 * left.magnitude() + 2 * right.magnitude()

            override fun addToLeftMost(value: Int) = left.addToLeftMost(value)

            override fun addToRightMost(value: Int) = right.addToRightMost(value)


            override fun split(): Boolean {
                if (left is Regular) {
                    (left as Regular).value.let {
                        if (it >= 10) {
                            left = SnailPair(Regular(it / 2), Regular((it + 1) / 2))
                            return true
                        }
                    }
                }
                if (left.split()) {
                    return true
                }
                if (right is Regular) {
                    (right as Regular).value.let {
                        if (it >= 10) {
                            right = SnailPair(Regular(it / 2), Regular((it + 1) / 2))
                            return true
                        }
                    }
                }
                return right.split()
            }

            override fun explode(depth: Int): Pair<Int, Int>? {
                if (depth == 4) {
                    return (left as Regular).value to (right as Regular).value
                }
                left.explode(depth + 1)?.let { (first, second) ->
                    if (first != -1 && second != -1) {
                        this.left = Regular(0)
                        this.right.addToLeftMost(second)
                        return first to -1
                    }
                    if (second != -1) {
                        this.right.addToLeftMost(second)
                        return -1 to -1
                    }
                    return first to -1
                }
                right.explode(depth + 1)?.let { (first, second) ->
                    if (first != -1 && second != -1) {
                        this.right = Regular(0)
                        this.left.addToRightMost(first)
                        return -1 to second
                    }
                    if (first != -1) {
                        this.left.addToRightMost(first)
                        return -1 to -1
                    }
                    return -1 to second
                }
                return null
            }

            override fun toString() = "[$left,$right]"
        }

        data class Regular(var value: Int) : SnailFishNumber() {
            override fun magnitude() = value

            override fun addToLeftMost(value: Int) = run { this.value += value }

            override fun addToRightMost(value: Int) = run { this.value += value }

            override fun split() = false

            override fun explode(depth: Int): Pair<Int, Int>? = null

            override fun toString() = "$value"
        }
    }

}