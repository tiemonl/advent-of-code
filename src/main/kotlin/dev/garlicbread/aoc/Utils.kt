package dev.garlicbread.aoc

fun <T> List<List<T>>.transpose(): List<List<T>> {
        val result: MutableList<MutableList<T>> = (this.first().indices).map { mutableListOf<T>() }.toMutableList()
        this.forEach { columns -> result.zip(columns).forEach { (rows, cell) -> rows.add(cell) } }
        return result
    }