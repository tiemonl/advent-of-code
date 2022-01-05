package dev.garlicbread.aoc.models

enum class Direction(val point: Point) {
    North(Point(0, 1)),
    East(Point(1, 0)),
    South(Point(0, -1)),
    West(Point(-1, 0));
}
