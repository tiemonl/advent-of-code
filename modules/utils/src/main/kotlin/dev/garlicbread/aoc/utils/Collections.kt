package dev.garlicbread.aoc.utils

import dev.garlicbread.aoc.models.Point

fun <T> Collection<T>.pairs(): List<Pair<T, T>> =
    this.flatMapIndexed { index, a ->
        this.drop(index).map { b -> a to b }
    }

fun <T> List<List<T>>.transpose(): List<List<T>> {
    val result: MutableList<MutableList<T>> = (this.first().indices).map { mutableListOf<T>() }.toMutableList()
    this.forEach { columns -> result.zip(columns).forEach { (rows, cell) -> rows.add(cell) } }
    return result
}

fun <E> List<E>.permutations(builtSequence: List<E> = listOf()): List<List<E>> =
    if (isEmpty()) {
        listOf(builtSequence)
    } else {
        flatMap { (this - it).permutations(builtSequence + it) }
    }

fun Iterable<Int>.product() = this.reduce { acc, value -> acc * value }

fun <T> List<List<T>>.isSafe(point: Point) = point.y in this.indices && point.x in this[point.y].indices

fun <T> List<List<T>>.elementAt(point: Point): T = this[point.y][point.x]

fun Array<CharArray>.isSafe(at: Point) =
    at.y in this.indices && at.x in this[at.y].indices