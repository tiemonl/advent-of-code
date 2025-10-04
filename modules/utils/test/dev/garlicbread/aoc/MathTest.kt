package test.dev.garlicbread.aoc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Math Utils Unit Tests")
class MathTest {

    @Test
    @DisplayName("GIVEN a, b WHEN gcd() THEN return greatest common denominator between a and b")
    fun gcd() {
        assertEquals(dev.garlicbread.aoc.utils.gcd(5, 10), 5)
        assertEquals(dev.garlicbread.aoc.utils.gcd(1000, 2500), 500)
    }

    @Test
    @DisplayName("GIVEN list of integers WHEN median() THEN return number in the middle of the list")
    fun median() {
        assertEquals(dev.garlicbread.aoc.utils.median(listOf<Int>(1, 2, 3, 4, 5)), 3)
        assertEquals(dev.garlicbread.aoc.utils.median(listOf<Int>(1, 2, 3, 4, 5, 6)), 3)
    }
}
