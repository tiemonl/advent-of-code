package dev.garlicbread.aoc.core

import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath

class FileInputProvider(
    private val metadata: ProblemMetadata,
    private val suffix: String = "",
    private val fileSystem: FileSystem = FileSystem.SYSTEM
) : InputProvider {

    override fun provideStringListInput(): List<String> =
        readFile {
            readUtf8()
                .lineSequence()
                .toList()
                .dropLastWhile { it.isBlank() }
        }

    override fun provideStringInput(): String =
        readFile { readUtf8() }.trim()

    override fun provideIntListInput(): List<Int> =
        safeRead {
            readUtf8().lineSequence()
                .mapNotNull { it.toIntOrNull() }
                .toList()
        }

    override fun provideNestedIntListInput(): List<List<Int>> =
        safeRead {
            readUtf8().lineSequence()
                .mapNotNull { line ->
                    val trimmed = line.trim()
                    if (trimmed.isEmpty()) return@mapNotNull null

                    val tokens = if (trimmed.contains("\\s+".toRegex()))
                        trimmed.split("\\s+".toRegex())
                    else
                        listOf(trimmed)

                    tokens.mapNotNull { it.toIntOrNull() }.takeIf { it.isNotEmpty() }
                }
                .toList()
        }

    override fun provideLongListInput(): List<Long> =
        safeRead {
            readUtf8().lineSequence()
                .mapNotNull { it.toLongOrNull() }
                .toList()
        }

    private fun <T> readFile(block: okio.BufferedSource.() -> T): T {
        return fileSystem.read(getFilePath(), block)
    }

    private inline fun <reified T> safeRead(noinline block: okio.BufferedSource.() -> T): T {
        return try {
            readFile(block)
        } catch (e: Exception) {
            when (T::class) {
                List::class -> emptyList<Any>() as T
                else -> throw e
            }
        }
    }

    private fun getFilePath(): Path {
        val rootPath = getRootDirectory()
        val relative = if (suffix.isEmpty()) {
            "input/${metadata.year}/main/input${metadata.day}.in"
        } else {
            "input/${metadata.year}/test/input${metadata.day}$suffix.in"
        }

        // Ensure a single separator between root and relative path
        return if (rootPath.endsWith("/")) {
            "$rootPath$relative".toPath()
        } else {
            "$rootPath/$relative".toPath()
        }
    }

    private fun getRootDirectory(): String {
        val currentDir = System.getProperty("user.dir")

        return if (currentDir.contains("years")) {
            currentDir.split("/").dropLast(2).joinToString("/")
        } else {
            currentDir
        }
    }
}

inline fun <reified T : Any> fileInputProvider(
    suffix: String = ""
): FileInputProvider = FileInputProvider(
    metadata = problemMetadata<T>(),
    suffix = suffix
)