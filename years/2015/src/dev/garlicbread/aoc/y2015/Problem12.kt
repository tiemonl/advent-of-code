package dev.garlicbread.aoc.y2015

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull

fun main() = solve(
    benchmark = false,
) { Problem12() }

@AocProblem(year = 2015, day = 12, name = "JSAbacusFramework.io")
class Problem12(
    inputProvider: InputProvider = fileInputProvider<Problem12>()
) : Problem<Int, Int>() {
    override val input = inputProvider.provideStringInput()

    override fun solvePartOne(): Int {
        return input
            .replace("[^-?0-9]+".toRegex(), " ")
            .trimStart()
            .split(" ")
            .sumOf { if (it.isNotBlank()) Integer.parseInt(it) else 0 }
    }

    override fun solvePartTwo(): Int {
        val json = Json.parseToJsonElement(input)
        return sumNoRed(json)
    }

    private fun sumNoRed(json: JsonElement): Int = when (json) {
        is JsonPrimitive -> json.contentOrNull?.toIntOrNull() ?: 0
        is JsonObject -> if (JsonPrimitive("red") in json.values) 0 else json.values.sumOf { sumNoRed(it) }
        is JsonArray -> json.sumOf { sumNoRed(it) }
    }
}
