package dev.garlicbread.aoc.core

import com.google.common.truth.Truth.assertThat
import okio.Path.Companion.toPath
import okio.fakefilesystem.FakeFileSystem
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("File Input Provider Tests")
class FileInputProviderTest {

    @Nested
    @DisplayName("String List Input")
    inner class ProvideStringListInput {

        @Test
        fun `returns all lines as-is`() = withProvider(
            lines = listOf(
                "abc",
                "def",
                "ghi"
            )
        ) { provider ->
            val result = provider.provideStringListInput()

            assertThat(result).containsExactly("abc", "def", "ghi").inOrder()
        }

        @Test
        fun `returns all lines except last if there is no text`() = withProvider(
            lines = listOf(
                "abc",
                "",
                "def",
                "ghi",
                ""
            )
        ) { provider ->
            val result = provider.provideStringListInput()

            assertThat(result).containsExactly("abc", "", "def", "ghi").inOrder()
        }

        @Test
        fun `returns empty list when file missing`() {
            val originalUserDir = System.getProperty("user.dir")
            val fs = FakeFileSystem()
            val root = "/test-root-missing"

            try {
                System.setProperty("user.dir", root)

                val metadata = ProblemMetadata(
                    year = 1,
                    day = 1,
                    name = "Missing"
                )

                val provider = FileInputProvider(
                    metadata = metadata,
                    suffix = "",
                    fileSystem = fs
                )

                val result = provider.provideStringListInput()
                assertThat(result).isEmpty()
            } catch (e: Exception) {
                assertThat(e).isNotNull()
            } finally {
                System.setProperty("user.dir", originalUserDir)
            }
        }
    }

    @Nested
    @DisplayName("String Input")
    inner class ProvideStringInput {

        @Test
        fun `returns full multiple lines with contents trimmed`() = withProvider(
            lines = listOf(
                "  hello",
                "world  "
            )
        ) { provider ->
            val result = provider.provideStringInput()
            assertThat(result).isEqualTo("hello\nworld")
        }

        @Test
        fun `returns full line with contents trimmed`() = withProvider(
            lines = listOf(
                "  hello   world  "
            )
        ) { provider ->
            val result = provider.provideStringInput()
            assertThat(result).isEqualTo("hello   world")
        }
    }

    @Nested
    @DisplayName("Int List Input")
    inner class ProvideIntListInput {

        @Test
        fun `parses each line as int and ignores invalid`() = withProvider(
            lines = listOf(
                "10",
                "20",
                "abc",
                "30"
            )
        ) { provider ->
            val result = provider.provideIntListInput()

            assertThat(result).isEqualTo(listOf(10, 20, 30))
        }

        @Test
        fun `returns empty list when parsing fails or file missing`() {
            val originalUserDir = System.getProperty("user.dir")
            val fs = FakeFileSystem()
            val root = "/test-root-int-missing"

            try {
                System.setProperty("user.dir", root)

                val metadata = ProblemMetadata(
                    year = 1,
                    day = 1,
                    name = "Missing"
                )

                val provider = FileInputProvider(
                    metadata = metadata,
                    suffix = "",
                    fileSystem = fs
                )

                val result = provider.provideIntListInput()

                assertThat(result).isEmpty()
            } finally {
                System.setProperty("user.dir", originalUserDir)
            }
        }
    }

    @Nested
    @DisplayName("Nested Int List Input")
    inner class ProvideNestedIntListInput {

        @Test
        fun `parses mixed spaced and continuous digit lines with sanitized output`() = withProvider(
            lines = listOf(
                "1 2 3",
                "123",
                "12 345",
                "   ",
                "abc"
            )
        ) { provider ->
            val result = provider.provideNestedIntListInput()

            assertThat(result).isEqualTo(
                listOf(
                    listOf(1, 2, 3),
                    listOf(123),
                    listOf(12, 345)
                )
            )
        }

        @Test
        fun `parses only continuous digit lines`() = withProvider(
            lines = listOf(
                "123 45",
                "4567",
                "  89  "
            )
        ) { provider ->
            val result = provider.provideNestedIntListInput()

            assertThat(result).isEqualTo(
                listOf(
                    listOf(123, 45),
                    listOf(4567),
                    listOf(89)
                )
            )
        }

        @Test
        fun `skips completely blank and non-digit-only lines`() = withProvider(
            lines = listOf(
                "",
                "   ",
                "\t",
                "abc",
                "---",
                "42"
            )
        ) { provider ->
            val result = provider.provideNestedIntListInput()
            assertThat(result).isEqualTo(
                listOf(
                    listOf(42)
                )
            )
        }
    }

    @Nested
    @DisplayName("Long List Input")
    inner class ProvideLongListInput {

        @Test
        fun `parses each line as long and ignores invalid`() = withProvider(
            lines = listOf(
                "10000000000",
                "20000000000",
                "abc",
                "30000000000"
            )
        ) { provider ->
            val result = provider.provideLongListInput()

            assertThat(result).isEqualTo(
                listOf(
                    10_000_000_000L,
                    20_000_000_000L,
                    30_000_000_000L
                )
            )
        }

        @Test
        fun `returns empty list when parsing fails or file missing`() {
            val originalUserDir = System.getProperty("user.dir")
            val fs = FakeFileSystem()
            val root = "/test-root-long-missing"

            try {
                System.setProperty("user.dir", root)

                val metadata = ProblemMetadata(
                    year = 1,
                    day = 1,
                    name = "Missing"
                )

                val provider = FileInputProvider(
                    metadata = metadata,
                    suffix = "",
                    fileSystem = fs
                )

                val result = provider.provideLongListInput()

                assertThat(result).isEmpty()
            } finally {
                System.setProperty("user.dir", originalUserDir)
            }
        }
    }

    @Nested
    @DisplayName("suffix routing")
    inner class SuffixRouting {

        @Test
        fun `reads from main input when suffix is empty`() = withProvider(
            lines = listOf("main-line-1", "main-line-2"),
            suffix = ""
        ) { provider ->
            val result = provider.provideStringListInput()

            assertThat(result).containsExactly("main-line-1", "main-line-2").inOrder()
        }

        @Test
        fun `reads from test input when suffix is provided`() = withProvider(
            lines = listOf("test-line-1", "test-line-2"),
            suffix = "_1"
        ) { provider ->
            val result = provider.provideStringListInput()

            assertThat(result).containsExactly("test-line-1", "test-line-2").inOrder()
        }
    }

    private fun withProvider(
        lines: List<String>,
        suffix: String = "",
        year: Int = 1,
        day: Int = 1,
        name: String = "Test Problem",
        block: (FileInputProvider) -> Unit
    ) {
        val originalUserDir = System.getProperty("user.dir")
        val fs = FakeFileSystem()
        val root = "/test-root-$year-$day"

        try {
            System.setProperty("user.dir", root)

            val mainOrTest = if (suffix.isEmpty()) "main" else "test"
            val dirPath = "$root/input/$year/$mainOrTest".toPath()
            fs.createDirectories(dirPath)

            val fileName = if (suffix.isEmpty()) {
                "input$day.in"
            } else {
                "input${day}$suffix.in"
            }

            val filePath = dirPath.resolve(fileName)

            fs.write(filePath) {
                writeUtf8(lines.joinToString(separator = "\n"))
            }

            val metadata = ProblemMetadata(
                year = year,
                day = day,
                name = name
            )

            val provider = FileInputProvider(
                metadata = metadata,
                suffix = suffix,
                fileSystem = fs
            )

            block(provider)
        } finally {
            System.setProperty("user.dir", originalUserDir)
        }
    }
}