package dev.garlicbread.aoc.models

enum class Direction(val point: Point) {
    North(Point(0, 1)),
    East(Point(1, 0)),
    South(Point(0, -1)),
    West(Point(-1, 0)),
}

enum class GridDirection(val point: Point) {
    North(Point(0, -1)),
    South(Point(0,1)),
    West(Point(-1, 0)),
    East(Point(1, 0)),
    NorthWest(Point(-1, -1)),
    NorthEast(Point(1, -1)),
    SouthWest(Point(-1, 1)),
    SouthEast(Point(1, 1)),
}
