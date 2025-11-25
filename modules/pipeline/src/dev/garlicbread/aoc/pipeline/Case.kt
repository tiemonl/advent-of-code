package dev.garlicbread.aoc.pipeline

data class Case(val year: Int, val day: Int, val part: Int, val pass: Boolean = false) {
    fun toKey() = CaseKey(this.day, this.part)
}
