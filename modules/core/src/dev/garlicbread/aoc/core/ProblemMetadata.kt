package dev.garlicbread.aoc.core

import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

data class ProblemMetadata(
    val year: Int,
    val day: Int,
    val name: String = ""
)

fun KClass<*>.problemMetadata(): ProblemMetadata {
    val ann = findAnnotation<AocProblem>()
        ?: error("Missing @AocPuzzle on $qualifiedName")
    return ProblemMetadata(
        year = ann.year,
        day = ann.day,
        name = ann.name
    )
}

inline fun <reified T : Any> problemMetadata(): ProblemMetadata =
    T::class.problemMetadata()