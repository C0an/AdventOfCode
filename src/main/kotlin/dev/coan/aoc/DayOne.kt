package dev.coan.aoc

object DayOne {

    @JvmStatic
    fun main(args: Array<String>) {
        // read the text file from resources
        val input = this::class.java.getResource("/d1/trebuchet")?.readText()

        // if the input is null, print a message and return
        if(input == null) {
            println("No input found")
            return
        }

        val text = input.split("\n")

        // Print solution!
        println("P1: ${partOne(text)}")
        println("P2: ${partTwo(text)}")
    }

    private fun partOne(input: List<String>): Int {
        return input.sumOf {
            val first = it.first { char -> char.isDigit() }
            val last = it.last { char -> char.isDigit() }

            "$first$last".toInt()
        }
    }

    private fun partTwo(input: List<String>): Int {
        // Easy way to convert the word form to a number
        val numberMap = mapOf(
            "1" to 1,
            "2" to 2,
            "3" to 3,
            "4" to 4,
            "5" to 5,
            "6" to 6,
            "7" to 7,
            "8" to 8,
            "9" to 9,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,
        )

        return input.sumOf { text ->
            val first = text.findAnyOf(numberMap.keys)?.second.let { numberMap[it] }
            val last = text.findLastAnyOf(numberMap.keys)?.second.let { numberMap[it] }

            "$first$last".toInt()
        }
    }


}