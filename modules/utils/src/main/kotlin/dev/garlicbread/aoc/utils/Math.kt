package dev.garlicbread.aoc.utils

fun gcd(a: Int, b: Int, vararg numbers: Int): Int = when {
    numbers.isEmpty() -> if (b == 0) a else gcd(b, a % b)
    else -> gcd(gcd(a, b), numbers.first(), *numbers.drop(1).toIntArray())
}

fun gcd(a: Long, b: Long, vararg numbers: Long): Long = when {
    numbers.isEmpty() -> if (b == 0L) a else gcd(b, a % b)
    else -> gcd(gcd(a, b), numbers.first(), *numbers.drop(1).toLongArray())
}

fun lcm(a: Long, b: Long): Long = a * (b / gcd(a, b))

fun lcm(numbers: List<Long>): Long {
    var result = numbers.first()
    (1 until numbers.size).map {
        result = lcm(result, numbers[it])
    }
    return result.toLong()
}

fun median(list: List<Int>) = list.sorted().let {
    if (it.size % 2 == 0) {
        (it[it.size / 2] + it[(it.size - 1) / 2]) / 2
    } else {
        it[it.size / 2]
    }
}

fun median(list: List<Long>) = list.sorted().let {
    if (it.size % 2 == 0) {
        (it[it.size / 2] + it[(it.size - 1) / 2]) / 2
    } else {
        it[it.size / 2]
    }
}

fun gauss(n: Int) = (n * (n + 1)) / 2

fun IntRange.intersects(other: IntRange): Boolean =
    first <= other.last && last >= other.first

fun IntRange.intersect(other: IntRange): IntRange =
    maxOf(first, other.first)..minOf(last, other.last)

fun IntRange.size(): Int =
    last - first + 1

fun Int.combinationSum(digitsToSumUp: Int): List<List<Int>> =
    if (digitsToSumUp == 1) {
        listOf(listOf(this))
    } else {
        (0..this).flatMap { value ->
            (this - value).combinationSum(digitsToSumUp - 1).map { listOf(value) + it }
        }
    }