package dev.garlicbread.aoc.y2021

import dev.garlicbread.aoc.core.FileInputProvider
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Puzzle
import dev.garlicbread.aoc.core.PuzzleMetadata
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.models.Point3d
import dev.garlicbread.aoc.utils.pairs

fun main() = solve(
    benchmark = false,
) { Problem19() }

class Problem19(
    inputProvider: InputProvider = FileInputProvider(METADATA)
) : Puzzle<Int, Int>(
    metadata = METADATA
) {
    override val input = parseInput(inputProvider.provideStringListInput().joinToString("\n"))
    private val scannerSectors = findScannersSectorsPairs(input)

    override fun solvePartOne(): Int {
        return scannerSectors.second.size
    }

    override fun solvePartTwo(): Int {
        return scannerSectors.first.pairs().maxOf { it.first.manhanttanDistance(it.second) }
    }

    private fun findScannersSectorsPairs(scanners: List<Set<Point3d>>): Pair<MutableSet<Point3d>, MutableSet<Point3d>> {
        val baseSector = scanners.first().toMutableSet()
        val foundScanners = mutableSetOf(Point3d(0, 0, 0))
        val unmappedSectors = ArrayDeque<Set<Point3d>>().apply { addAll(scanners.drop(1)) }
        while (unmappedSectors.isNotEmpty()) {
            val thisSector = unmappedSectors.removeFirst()
            when (val scannerBeacons = findScannerBeaconsIfIntersects(baseSector, thisSector)) {
                null -> unmappedSectors.add(thisSector)
                else -> {
                    baseSector.addAll(scannerBeacons.beacons)
                    foundScanners.add(scannerBeacons.scanner)
                }
            }
        }
        return Pair(foundScanners, baseSector)
    }

    private fun findScannerBeaconsIfIntersects(left: Set<Point3d>, right: Set<Point3d>): ScannerBeacons? =
        (0 until 6).firstNotNullOfOrNull { face ->
            (0 until 4).firstNotNullOfOrNull { rotation ->
                val rightReoriented = right.map { it.face(face).rotate(rotation) }.toSet()
                left.firstNotNullOfOrNull { sector1 ->
                    rightReoriented.firstNotNullOfOrNull { sector2 ->
                        val difference = sector1 - sector2
                        val moved = rightReoriented.map { it + difference }.toSet()
                        if (moved.intersect(left).size >= 12) {
                            ScannerBeacons(difference, moved)
                        } else {
                            null
                        }
                    }
                }
            }
        }

    private fun parseInput(input: String): List<Set<Point3d>> =
        input.split("\n\n").map { singleScanner ->
            singleScanner
                .lines()
                .drop(1)
                .map { Point3d.parse(it) }
                .toSet()
        }

    data class ScannerBeacons(
        val scanner: Point3d,
        val beacons: Set<Point3d>,
    )

    companion object {
        val METADATA = PuzzleMetadata(year = 2021, day = 19, name = "")
    }
}
