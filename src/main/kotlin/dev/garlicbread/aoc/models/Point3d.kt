package dev.garlicbread.aoc.models

import kotlin.math.absoluteValue

data class Point3d(
    val x: Int,
    val y: Int,
    val z: Int
) {
    operator fun plus(other: Point3d): Point3d =
        Point3d(x + other.x, y + other.y, z + other.z)

    operator fun minus(other: Point3d): Point3d =
        Point3d(x - other.x, y - other.y, z - other.z)

    fun manhanttanDistance(other: Point3d): Int =
        (this.x - other.x).absoluteValue + (this.y - other.y).absoluteValue + (this.z - other.z).absoluteValue

    fun face(facing: Int): Point3d =
        when (facing) {
            0 -> this
            1 -> Point3d(x, -y, -z)
            2 -> Point3d(x, -z, y)
            3 -> Point3d(-y, -z, x)
            4 -> Point3d(y, -z, -x)
            5 -> Point3d(-x, -z, -y)
            else -> error("Invalid facing")
        }

    fun rotate(rotating: Int): Point3d =
        when (rotating) {
            0 -> this
            1 -> Point3d(-y, x, z)
            2 -> Point3d(-x, -y, z)
            3 -> Point3d(y, -x, z)
            else -> error("Invalid rotation")
        }

    companion object {
        fun parse(input: String) = input.split(",").let { Point3d(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
    }
}
