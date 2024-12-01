import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val unzipped = input.map { it.split(Regex("\\s+"), 2) }
            .map { Pair(it[0].toInt(), it[1].toInt()) }
            .unzip()

        return unzipped.first.sorted().zip(unzipped.second.sorted())
            .sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {
        val unzipped = input.map { it.split(Regex("\\s+"), 2) }
            .map { Pair(it[0].toInt(), it[1].toInt()) }
            .unzip()

        val leftCount = unzipped.first.groupingBy { it }.eachCount()
        val rightCount = unzipped.second.groupingBy { it }.eachCount()

        return leftCount.entries.map { it.key * it.value * (rightCount[it.key] ?: 0) }
            .sum()
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
