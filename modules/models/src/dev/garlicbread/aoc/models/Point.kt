package dev.garlicbread.aoc.models

data class Point(
    val x: Int,
    val y: Int,
) {
    operator fun plus(point: Point) = Point(x + point.x, y + point.y)

    operator fun times(point: Point) = Point(x * point.x, y * point.y)

    operator fun times(by: Int) = Point(x * by, y * by)

    fun move(dx: Int, dy: Int) = Point(x + dx, y + dy)

    fun move(direction: Direction) = this + direction.point

    fun moveBy(direction: Direction, amount: Int) = this + direction.point * amount

    fun up() = move(Direction.North)

    fun left() = move(Direction.West)

    fun right() = move(Direction.East)

    fun down() = move(Direction.South)

    fun neighbors(diagonal: Boolean = false) = listOf(up(), right(), down(), left()) +
        if (diagonal) listOf(up().right(), right().down(), down().left(), left().up()) else emptyList()
}
