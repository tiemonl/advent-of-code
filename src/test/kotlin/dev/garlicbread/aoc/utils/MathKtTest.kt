package dev.garlicbread.aoc.utils

import com.google.common.truth.Truth
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Math Utils Unit Tests")
class MathKtTest {

    @Test
    @DisplayName("GIVEN a, b WHEN gcd() THEN return greatest common denominator between a and b")
    fun gcd() {
        Truth.assertThat(gcd(5, 10)).isEqualTo(5)
        Truth.assertThat(gcd(1000, 2500)).isEqualTo(500)
    }

    @Test
    @DisplayName("GIVEN list of integers WHEN median() THEN return number in the middle of the list")
    fun median() {
        Truth.assertThat(median(listOf<Int>(1, 2, 3, 4, 5))).isEqualTo(3)
        Truth.assertThat(median(listOf<Int>(1, 2, 3, 4, 5, 6))).isEqualTo(3)
    }
}
