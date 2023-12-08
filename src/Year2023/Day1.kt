package Year2023

import java.io.File

fun main() {
    println(part1(File("src/Year2023/day1Input.txt").bufferedReader().readLines()))
    println(part2(File("src/Year2023/day1Input.txt").bufferedReader().readLines()))
}

private fun part1(lines: List<String>): Int {
    return lines.map { line -> line.filter { it.isDigit() } }
            .map(::firstAndLastDigits)
            .sumOf { it.toInt() }
}

private fun part2(lines: List<String>): Int {
    return lines.map(::replaceCharsWithDigits)
            .map { line -> line.filter { it.isDigit() } }
            .map(::firstAndLastDigits)
            .sumOf { it.toInt() }
}

private fun firstAndLastDigits(digitLine: String): String {
    return "${digitLine[0]}${digitLine[digitLine.length - 1]}"
}

private fun replaceCharsWithDigits(line: String): String {
    var newLine = line
    val wordToNumberMap = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)
    wordToNumberMap.entries.forEach { newLine = newLine.replace(it.key, "${it.key}${it.value}${it.key}") }
    return newLine
}
