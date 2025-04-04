package SudokuChecker

import kotlin.math.sqrt

fun main() {
    // 1. Valid Cases

    val emptyBoard = listOf(
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
    )
    check(
        name = "when board is empty, return true",
        result = isValidSudoku(emptyBoard),
        correctResult = true
    )

    val partialValidBoard = listOf(
        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    check(
        name = "when board is partially filled with no duplicates, return true",
        result = isValidSudoku(partialValidBoard),
        correctResult = true
    )

    val fullValidBoard = listOf(
        listOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
        listOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
        listOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
        listOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
        listOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
        listOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
        listOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
        listOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
        listOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
    )
    check(
        name = "when board is fully filled and valid, return true",
        result = isValidSudoku(fullValidBoard),
        correctResult = true
    )

    // 2. Invalid Cases

    val rowDuplicateBoard = listOf(
        listOf('5', '3', '5', '-', '-', '-', '-', '-', '-'), // Repeat 5 in the first row
        listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    check(
        name = "when board has duplicate in same row, return false",
        result = isValidSudoku(rowDuplicateBoard),
        correctResult = false
    )

    val colDuplicateBoard = listOf(
        listOf('5', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('5', '-', '-', '1', '9', '5', '-', '-', '-'), // Repeat 5 in the first column
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    check(
        name = "when board has duplicate in same column, return false",
        result = isValidSudoku(colDuplicateBoard),
        correctResult = false
    )

    val boxDuplicateBoard = listOf(
        listOf('5', '3', '-', '-', '-', '-', '-', '-', '-'),
        listOf('6', '5', '-', '1', '9', '5', '-', '-', '-'), // Repeat 5 in the top left box
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    check(
        name = "when board has duplicate in same 3x3 box, return false",
        result = isValidSudoku(boxDuplicateBoard),
        correctResult = false
    )

    val invalidSizeBoard = listOf(
        listOf('1', '2', '3'),
        listOf('4', '5', '6')
    )
    check(
        name = "when board is not 9x9, return false",
        result = isValidSudoku(invalidSizeBoard),
        correctResult = false
    )

    // 3. Edge Cases

    val singleValueBoard = listOf(
        listOf('1', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
    )
    check(
        name = "when board has only one value, return true",
        result = isValidSudoku(singleValueBoard),
        correctResult = true
    )

    val invalidNumberBoard = listOf(
        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        listOf('6', '-', '-', '1', '9', '0', '-', '-', '-'), // not allowed with 0
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    check(
        name = "when board has invalid number, return false",
        result = isValidSudoku(invalidNumberBoard),
        correctResult = false
    )

    val invalidLatterBoard = listOf(
        listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
        listOf('6', '-', '-', '1', '9', 'a', '-', '-', '-'), // not allowed with a
        listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
        listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
        listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
        listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
        listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
        listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
        listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
    )
    check(
        name = "when board has invalid latter, return false",
        result = isValidSudoku(invalidLatterBoard),
        correctResult = false
    )

    val fullRowBoard = listOf(
        listOf('1', '2', '3', '4', '5', '6', '7', '8', '9'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
    )
    check(
        name = "when board has a full row with no duplicates, return true",
        result = isValidSudoku(fullRowBoard),
        correctResult = true
    )

    val fullBoxBoard = listOf(
        listOf('1', '2', '3', '-', '-', '-', '-', '-', '-'),
        listOf('4', '5', '6', '-', '-', '-', '-', '-', '-'),
        listOf('7', '8', '9', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
        listOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
    )
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

// handle with dynamic Sudoku 3x3, 9x9 or 16x16
fun isValidSudoku(board: List<List<Char>>): Boolean {
    val numberOfRowsForBoard = board.size

    // Check if board is square and all rows have same size
    if (numberOfRowsForBoard == 0 || board.any { row -> row.size != numberOfRowsForBoard }) return false

    val boxSizeInsideBorder = sqrt(numberOfRowsForBoard.toDouble()).toInt()
    if (boxSizeInsideBorder * boxSizeInsideBorder != numberOfRowsForBoard) return false // Must be dynamic square (e.g., 4x4, 9x9, 16x16)

    // Allowed characters: '1' to n as chars (handle 10+ with letters if needed)
    val allowedChars = (1..numberOfRowsForBoard).map {
        if (it <= 9) '0' + it
        else 'A' + (it - 10)
    }.toSet()


    // Check rows
    for (row in board) {
        if (hasDuplicates(row, allowedChars)) return false
    }

    // Check columns
    for (col in 0..<numberOfRowsForBoard) {
        if (hasDuplicates(board.map { it[col] }, allowedChars)) return false
    }

    // Check boxes
    for (boxRow in 0..<boxSizeInsideBorder) {
        for (boxCol in 0..<boxSizeInsideBorder) {
            val box = buildList {
                for (i in 0..<boxSizeInsideBorder) {
                    for (j in 0..<boxSizeInsideBorder) {
                        add(board[boxRow * boxSizeInsideBorder + i][boxCol * boxSizeInsideBorder + j])
                    }
                }
            }
            if (hasDuplicates(box, allowedChars)) return false
        }
    }

    return true
}

// Make sure that the list you entered does not contain any unauthorized duplicates.
fun hasDuplicates(cells: List<Char>, allowedChars: Set<Char>): Boolean {
    val seen = mutableSetOf<Char>()
    return cells.any { char ->
        char != '-' && (char !in allowedChars || !seen.add(char))
    }
}