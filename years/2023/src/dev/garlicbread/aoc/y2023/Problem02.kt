package dev.garlicbread.aoc.y2023

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.product

fun main() = solve(
    benchmark = false,
) { Problem02() }

@AocProblem(year = 2023, day = 2, name = "Cube Conundrum")
class Problem02(
    inputProvider: InputProvider = fileInputProvider<Problem02>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringListInput().map {
        it.split(": ").let { (game, sets) ->
            Game(
                id = game.split(" ").last().toInt(),
                set = sets.split("; ").flatMap { set ->
                    set.split(", ").map { cube ->
                        cube.split(" ").let { (amount, color) ->
                            Game.CubeSet(
                                color = color,
                                amount = amount.toInt()
                            )
                        }
                    }
                }
            )
        }
    }

    override fun solvePartOne(): Int {
        val limit = listOf(
            Game.CubeSet(color = "red", amount = 12),
            Game.CubeSet(color = "green", amount = 13),
            Game.CubeSet(color = "blue", amount = 14),
        )
        return input.sumOf {
            if (isGameValid(it.set, limit)) it.id else 0
        }
    }

    override fun solvePartTwo() = input.sumOf { cubes -> cubes.set.maxCubes().map { it.amount }.product() }

    private fun List<Game.CubeSet>.maxCubes(): List<Game.CubeSet> {
        val cubes = mutableMapOf<String, Int>()
        this.forEach { cube ->
            if (cube.amount > (cubes[cube.color] ?: 0))
                cubes[cube.color] = cube.amount
        }
        return cubes.map { Game.CubeSet(color = it.key, amount = it.value) }
    }

    private fun isGameValid(set: List<Game.CubeSet>, limit: List<Game.CubeSet>) = set.all { cube ->
        cube.amount <= limit.first { it.color == cube.color }.amount
    }

    data class Game(
        val id: Int,
        val set: List<CubeSet>
    ) {
        data class CubeSet(
            val color: String,
            val amount: Int
        )
    }
}
