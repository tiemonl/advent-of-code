package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.Puzzle
import dev.garlicbread.aoc.solve
import dev.garlicbread.aoc.utils.intersect
import dev.garlicbread.aoc.utils.intersects
import dev.garlicbread.aoc.utils.size

fun main() = solve(
    benchmark = false
) { Problem22() }

class Problem22 : Puzzle<Long, Long>(
    year = 2021,
    day = 22
) {
    override val input = rawInput.map { Cuboid.parse(it) }
    private val part1Cube = Cuboid(true, -50..50, -50..50, -50..50)

    override fun solvePartOne(): Long {
        return reboot(input.filter { it.intersects(part1Cube) })
    }

    override fun solvePartTwo(): Long {
        return reboot(input)
    }

    private fun reboot(cubesToUse: List<Cuboid>): Long {
        val volumes = mutableListOf<Cuboid>()

        cubesToUse.forEach { cube ->
            volumes.addAll(volumes.mapNotNull { it.intersect(cube) })
            if (cube.on) volumes.add(cube)
        }

        return volumes.sumOf { it.volume() }
    }

    class Cuboid(val on: Boolean, val x: IntRange, val y: IntRange, val z: IntRange) {

        fun volume(): Long =
            (x.size().toLong() * y.size().toLong() * z.size().toLong()) * if (on) 1 else -1

        fun intersect(other: Cuboid): Cuboid? =
            if (!intersects(other)) null
            else Cuboid(!on, x.intersect(other.x), y.intersect(other.y), z.intersect(other.z))

        fun intersects(other: Cuboid): Boolean =
            x.intersects(other.x) && y.intersects(other.y) && z.intersects(other.z)

        companion object {
            private val pattern =
                """^(on|off) x=(-?\d+)\.\.(-?\d+),y=(-?\d+)\.\.(-?\d+),z=(-?\d+)\.\.(-?\d+)$""".toRegex()

            fun parse(input: String): Cuboid {
                val (s, x1, x2, y1, y2, z1, z2) = pattern.matchEntire(input)?.destructured
                    ?: error("Cannot parse input: $input")
                return Cuboid(
                    s == "on",
                    x1.toInt()..x2.toInt(),
                    y1.toInt()..y2.toInt(),
                    z1.toInt()..z2.toInt(),
                )
            }
        }
    }
}
