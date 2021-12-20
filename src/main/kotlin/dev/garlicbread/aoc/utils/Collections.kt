package dev.garlicbread.aoc.utils

fun <T> Collection<T>.pairs(): List<Pair<T,T>> =
    this.flatMapIndexed { index, a ->
        this.drop(index).map { b -> a to b }
    }
