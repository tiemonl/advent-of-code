package dev.garlicbread.aoc.core

interface InputProvider {

    /**
     * Returns the input as a list of raw lines.
     *
     * ### Example
     * **Input file:**
     * ```
     * abc
     * def
     * ghi
     * ```
     *
     * **Output:**
     * ```
     * ["abc", "def", "ghi"]
     * ```
     *
     * @return A list of strings, one per line.
     */
    fun provideStringListInput(): List<String>

    /**
     * Returns the entire input as a single trimmed string.
     *
     * ### Example
     * **Input file:**
     * ```
     *   12345
     * ```
     *
     * **Output:**
     * ```
     * "12345"
     * ```
     *
     * @return The full input as a single string with surrounding whitespace removed.
     */
    fun provideStringInput(): String

    /**
     * Returns each line parsed as an integer.
     * Lines that cannot be parsed as integers are ignored.
     *
     * ### Example
     * **Input file:**
     * ```
     * 10
     * 20
     * abc
     * 30
     * ```
     *
     * **Output:**
     * ```
     * [10, 20, 30]
     * ```
     *
     * @return A list of integers parsed from each line.
     */
    fun provideIntListInput(): List<Int>

    /**
     * Returns each line parsed into a list of integers, supporting two formats:
     *
     * ### 1. Whitespace-separated integers
     * If the line contains spaces, each token is treated as an integer string,
     * and each character of each token is parsed individually.
     *
     * **Example**
     * ```
     * Line: "12 345"
     * Output: [1, 2, 3, 4, 5]
     * ```
     *
     * ### 2. Continuous digits (no whitespace)
     * If the line contains no spaces, the entire line is treated as a sequence of digits.
     *
     * **Example**
     * ```
     * Line: "789"
     * Output: [7, 8, 9]
     * ```
     *
     * ### Combined Example Input
     * ```
     * 1 2 3
     * 123
     * 12 345
     * ```
     *
     * ### Combined Output
     * ```
     * [
     *   [1, 2, 3],
     *   [1, 2, 3],
     *   [1, 2, 3, 4, 5]
     * ]
     * ```
     *
     * Non-digit characters are ignored.
     *
     * @return A nested list of digits extracted from each line.
     */
    fun provideNestedIntListInput(): List<List<Int>>


    /**
     * Returns each line parsed as a long integer.
     * Lines that cannot be parsed are ignored.
     *
     * ### Example
     * **Input file:**
     * ```
     * 10000000000
     * 20000000000
     * abc
     * 30000000000
     * ```
     *
     * **Output:**
     * ```
     * [10000000000, 20000000000, 30000000000]
     * ```
     *
     * @return A list of parsed longs.
     */
    fun provideLongListInput(): List<Long>

    companion object {
        lateinit var provider: InputProvider
    }
}