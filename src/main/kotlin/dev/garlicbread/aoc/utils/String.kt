package dev.garlicbread.aoc.utils

import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)

fun String.countMatches(pattern: String) = this.split(pattern)
    .dropLastWhile { it.isEmpty() }
    .toTypedArray().size - 1

fun String.countMatches(pattern: Regex) = this.split(pattern)
    .dropLastWhile { it.isEmpty() }
    .toTypedArray().size - 1
