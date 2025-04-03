package SudokuChecker


fun main() {
    // 1. Valid Cases
    val emptyBoard = mutableListOf(
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
    )
    // 1.1
    check(
        name = "when board is empty, return true",
        result = isValidSudoku(emptyBoard),
        correctResult = true
    )

    val partialValidBoard = mutableListOf(
        mutableListOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        mutableListOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        mutableListOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        mutableListOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        mutableListOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        mutableListOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        mutableListOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        mutableListOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        mutableListOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    // 1.2
    check(
        name = "when board is partially filled with no duplicates, return true",
        result = isValidSudoku(partialValidBoard),
        correctResult = true
    )

    val fullValidBoard = mutableListOf(
        mutableListOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
        mutableListOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
        mutableListOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
        mutableListOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
        mutableListOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
        mutableListOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
        mutableListOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
        mutableListOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
        mutableListOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
    )
    // 1.3
    check(
        name = "when board is fully filled and valid, return true",
        result = isValidSudoku(fullValidBoard),
        correctResult = true
    )

    // 2. Invalid Cases
    val rowDuplicateBoard = mutableListOf(
        mutableListOf('5', '3', '5', '-', '-', '-', '-', '-', '-'), // Repeat 5 in the first row
        mutableListOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        mutableListOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        mutableListOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        mutableListOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        mutableListOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        mutableListOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        mutableListOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        mutableListOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    // 2.1
    check(
        name = "when board has duplicate in same row, return false",
        result = isValidSudoku(rowDuplicateBoard),
        correctResult = false
    )

    val colDuplicateBoard = mutableListOf(
        mutableListOf('5', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('5', '-', '-', '1', '9', '5', '-', '-', '-'), // Repeat 5 in the first column
        mutableListOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        mutableListOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        mutableListOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        mutableListOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        mutableListOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        mutableListOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        mutableListOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    // 2.2
    check(
        name = "when board has duplicate in same column, return false",
        result = isValidSudoku(colDuplicateBoard),
        correctResult = false
    )

    val boxDuplicateBoard = mutableListOf(
        mutableListOf('5', '3', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('6', '5', '-', '1', '9', '5', '-', '-', '-'), // Repeat 5 in the top left box
        mutableListOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        mutableListOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        mutableListOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        mutableListOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        mutableListOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        mutableListOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        mutableListOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    // 2.3
    check(
        name = "when board has duplicate in same 3x3 box, return false",
        result = isValidSudoku(boxDuplicateBoard),
        correctResult = false
    )

    val invalidSizeBoard = mutableListOf(
        mutableListOf('1', '2', '3'),
        mutableListOf('4', '5', '6')
    )
    // 2.3
    check(
        name = "when board is not 9x9, return false",
        result = isValidSudoku(invalidSizeBoard),
        correctResult = false
    )

    // 3. Edge Cases
    val singleValueBoard = mutableListOf(
        mutableListOf('1', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
    )
    // 3.1
    check(
        name = "when board has only one value, return true",
        result = isValidSudoku(singleValueBoard),
        correctResult = true
    )

    val invalidCharBoard = mutableListOf(
        mutableListOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        mutableListOf('6', '-', '-', '1', '9', '0', '-', '-', '-'), // '0' غير مسموح
        mutableListOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        mutableListOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        mutableListOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        mutableListOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        mutableListOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        mutableListOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        mutableListOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    // 3.2
    check(
        name = "when board has invalid characters, return false",
        result = isValidSudoku(invalidCharBoard),
        correctResult = false
    )

    val fullRowBoard = mutableListOf(
        mutableListOf('1', '2', '3', '4', '5', '6', '7', '8', '9'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
    )
    // 3.3
    check(
        name = "when board has a full row with no duplicates, return true",
        result = isValidSudoku(fullRowBoard),
        correctResult = true
    )

    val fullBoxBoard = mutableListOf(
        mutableListOf('1', '2', '3', '-', '-', '-', '-', '-', '-'),
        mutableListOf('4', '5', '6', '-', '-', '-', '-', '-', '-'),
        mutableListOf('7', '8', '9', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        mutableListOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
    )
    // 3.4
    check(
        name = "when board has a full 3x3 box with no duplicates, return true",
        result = isValidSudoku(fullBoxBoard),
        correctResult = true
    )
}

fun check(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name | Expected: $correctResult, Got: $result")
    }
}

fun isValidSudoku(board: MutableList<MutableList<Char>>): Boolean {
    return false // need implementation
}

