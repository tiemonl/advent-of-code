package dev.garlicbread.aoc.models

import dev.garlicbread.aoc.utils.gcd
import kotlin.math.absoluteValue

data class Point(
    val x: Int,
    val y: Int
) {
    operator fun plus(point: Point) = Point(x + point.x, y + point.y)

    operator fun times(point: Point) = Point(x * point.x, y * point.y)

    fun slope(to: Point): Point {
        val dX = to.x - x
        val dY = to.y - y
        val gcd = gcd(dX.absoluteValue, dY.absoluteValue)
        return Point(dX / gcd, dY / gcd)
    }

    fun pointsInBetween(to: Point): List<Point> {
        val slope = this.slope(to)
        val points = mutableListOf(this)
        var curr = this
        while (!points.contains(to)) {
            curr += slope
            points.add(curr)
        }
        return points
    }
}