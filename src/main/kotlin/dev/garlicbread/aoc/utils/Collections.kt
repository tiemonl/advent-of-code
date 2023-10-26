package dev.garlicbread.aoc.utils

fun <T> Collection<T>.pairs(): List<Pair<T, T>> =
    this.flatMapIndexed { index, a ->
        this.drop(index).map { b -> a to b }
    }

fun <E> List<E>.permutations(builtSequence: List<E> = listOf()): List<List<E>> =
    if (isEmpty()) {
        listOf(builtSequence)
    } else {
        flatMap { (this - it).permutations(builtSequence + it) }
    }
