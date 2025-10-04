package dev.garlicbread.aoc.utils

import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

fun String.md5() =
    "%032x".format(BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray(StandardCharsets.UTF_8))))

fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)

fun String.countMatches(pattern: String) = this.split(pattern)
    .dropLastWhile { it.isEmpty() }
    .toTypedArray().size - 1

fun String.countMatches(pattern: Regex) = this.split(pattern)
    .dropLastWhile { it.isEmpty() }
    .toTypedArray().size - 1
