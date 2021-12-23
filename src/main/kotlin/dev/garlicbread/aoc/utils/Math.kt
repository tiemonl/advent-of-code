package dev.garlicbread.aoc.utils

fun gcd(a: Int, b: Int, vararg numbers: Int): Int = when {
    numbers.isEmpty() -> if (b == 0) a else gcd(b, a % b)
    else -> gcd(gcd(a, b), numbers.first(), *numbers.drop(1).toIntArray())
}

fun median(list: List<Int>) = list.sorted().let {
    if (it.size % 2 == 0)
        (it[it.size / 2] + it[(it.size - 1) / 2]) / 2
    else
        it[it.size / 2]
}

fun median(list: List<Long>) = list.sorted().let {
    if (it.size % 2 == 0)
        (it[it.size / 2] + it[(it.size - 1) / 2]) / 2
    else
        it[it.size / 2]
}

fun gauss(n: Int) = (n * (n + 1)) / 2

fun IntRange.intersects(other: IntRange): Boolean =
    first <= other.last && last >= other.first

fun IntRange.intersect(other: IntRange): IntRange =
    maxOf(first, other.first)..minOf(last, other.last)

fun IntRange.size(): Int =
    last - first + 1