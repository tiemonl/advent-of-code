package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.combinationSum
import dev.garlicbread.aoc.utils.product
import dev.garlicbread.aoc.utils.transpose

fun main() = solve(
    benchmark = false,
) { Problem15() }

@AocProblem(year = 2015, day = 15, name = "Science for Hungry People")
class Problem15(
    inputProvider: InputProvider = fileInputProvider<Problem15>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringListInput().map { ingredient ->
        "(\\w+).* (-?\\d+).* (-?\\d+).* (-?\\d+).* (-?\\d+).* (-?\\d+).*".toRegex()
            .matchEntire(ingredient)!!.destructured.let { (name, capacity, durability, flavor, texture, calories) ->
                Ingredient(
                    name = name,
                    capacity = capacity.toInt(),
                    durability = durability.toInt(),
                    flavor = flavor.toInt(),
                    texture = texture.toInt(),
                    calories = calories.toInt()
                )
            }
    }

    private val size = input.size
    private val combinations = 100.combinationSum(size)


    override fun solvePartOne(): Int {
        val ingredients = input.map { it.partOne() }.transpose()
        return ingredientCombinations(ingredients).maxOf { it.product() }
    }

    override fun solvePartTwo(): Int {
        val ingredients = input.map { it.partTwo() }.transpose()
        return ingredientCombinations(ingredients).filter { it.last() == 500 }.maxOf { it.dropLast(1).product() }
    }

    private fun ingredientCombinations(ingredients: List<List<Int>>) = combinations.map { combinationSum ->
        ingredients.map { ingredient ->
            ingredient.zip(combinationSum)
        }.map { ration ->
            ration.sumOf {
                it.toList().product()
            }.coerceAtLeast(0)
        }
    }

    data class Ingredient(
        val name: String,
        val capacity: Int,
        val durability: Int,
        val flavor: Int,
        val texture: Int,
        val calories: Int,
    ) {
        fun partOne() = listOf(capacity, durability, flavor, texture)
        fun partTwo() = listOf(capacity, durability, flavor, texture, calories)
    }
}
