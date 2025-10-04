package dev.garlicbread.aoc.utils

import dev.garlicbread.aoc.models.Point
import kotlin.math.absoluteValue


fun Point.slope(to: Point): Point {
    val dX = to.x - x
    val dY = to.y - y
    val gcd = gcd(dX.absoluteValue, dY.absoluteValue)
    return Point(dX / gcd, dY / gcd)
}

fun Point.pointsInBetween(to: Point): List<Point> {
    val slope = this.slope(to)
    val points = mutableListOf(this)
    var curr = this
    while (!points.contains(to)) {
        curr += slope
        points.add(curr)
    }
    return points
}

