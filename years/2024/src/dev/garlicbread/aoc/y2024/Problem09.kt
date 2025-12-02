package dev.garlicbread.aoc.y2024

import dev.garlicbread.aoc.core.AocProblem
import dev.garlicbread.aoc.core.InputProvider
import dev.garlicbread.aoc.core.Problem
import dev.garlicbread.aoc.core.fileInputProvider
import dev.garlicbread.aoc.core.solve
import dev.garlicbread.aoc.utils.swap

fun main() = solve(
    benchmark = false,
) { Problem09() }

@AocProblem(year = 2024, day = 9, name = "Disk Fragmenter")
class Problem09(
    inputProvider: InputProvider = fileInputProvider<Problem09>()
) : Problem<Any, Any>() {
    override val input = inputProvider.provideStringInput()

    override fun solvePartOne(): Long {
        val test = fragmentDiskMap(formatDiskMap(input))
        val cleanList = test.filterNot { it == "." }
        return cleanList.calculateCheckSum()
    }

    override fun solvePartTwo(): Any {
        val test = fragmentDiskMap2(formatDiskMap2(input))
        val cleanList = buildList {
            test.forEach { curr ->
                repeat(curr.second) { add(curr.first) }
            }
        }

        return cleanList.map { it.toString() }.calculateCheckSum()
    }

    fun formatDiskMap(diskMap: String): List<String> {
        var id = 0
        return buildList {
            diskMap.forEachIndexed { index, num ->
                if (index % 2 == 0) {
                    repeat(num.digitToInt()) { add("$id") }
                    id++
                } else {
                    repeat(num.digitToInt()) { add(".") }
                }
            }
        }
    }

    fun formatDiskMap2(diskMap: String): List<Pair<String, Int>> {
        var id = 0
        return buildList<Pair<String, Int>> {
            diskMap.forEachIndexed { index, num ->
                if (index % 2 == 0) {
                    add("$id" to num.digitToInt())
                    id++
                } else {
                    add("." to num.digitToInt())
                }
            }
        }
    }

    fun fragmentDiskMap(diskMap: List<String>): List<String> {
        var updatedDiskMap = diskMap.toMutableList()
        while (updatedDiskMap.indexOfLast { it != "." } > updatedDiskMap.indexOfFirst { it == "." }) {
            updatedDiskMap.swap(
                updatedDiskMap.indexOfLast { it != "." },
                updatedDiskMap.indexOfFirst { it == "." }
            )
        }
        return updatedDiskMap
    }

    fun fragmentDiskMap3(files: List<Pair<String, Int>>): List<Pair<String, Int>> {
        var newFiles = files.toMutableList()
        for (i in files.indices.reversed()) {
            if (newFiles[i].first != ".") {
                val indexToSwap = newFiles.indexOfFirst { it.first == "." && it.second >= newFiles[i].second }
                if (indexToSwap != -1 && indexToSwap < i) {
                    if (newFiles[indexToSwap].second == newFiles[i].second) {
                        newFiles.swap(indexToSwap, i)
                    } else {
                        val oldEmptySpaceSize = newFiles[i].second
                        newFiles[indexToSwap] = Pair(".", newFiles[indexToSwap].second - oldEmptySpaceSize)
                        newFiles.add(indexToSwap, newFiles[i])
                        newFiles.removeAt(i.inc())
                        newFiles.add(i, Pair(".", oldEmptySpaceSize))
                    }
                }
            }
        }
        return newFiles.toList()
    }

    fun fragmentDiskMap2(files: List<Pair<String, Int>>): List<Pair<String, Int>> {
        val newFiles = files.toMutableList()
        for (i in files.indices.reversed()) {
            if (newFiles[i].first != ".") {
                val indexToSwap = newFiles.indexOfFirst { it.first == "." && it.second >= newFiles[i].second }
                if (indexToSwap != -1 && indexToSwap < i) {
                    if (newFiles[indexToSwap].second == newFiles[i].second) {
                        newFiles.swap(indexToSwap, i)
                    } else {
                        val oldEmptySpaceSize = newFiles[i].second
                        newFiles[indexToSwap] = Pair(".", newFiles[indexToSwap].second - oldEmptySpaceSize)
                        newFiles.add(indexToSwap, newFiles[i])
                        newFiles.removeAt(i.inc())
                        newFiles.add(i, Pair(".", oldEmptySpaceSize))
                    }
                }
            }
        }
        return newFiles.toList()
    }

    private fun List<String>.calculateCheckSum() = this.withIndex().sumOf { (index, char) ->
        if (char != ".") index * char.toLong() else 0L
    }
}
