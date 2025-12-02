package dev.garlicbread.aoc.core

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AocProblem(
    val year: Int,
    val day: Int,
    val name: String
)