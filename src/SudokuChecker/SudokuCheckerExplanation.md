
### **All Possible Test Cases for Sudoku**

The following rules must be considered for a 9x9 Sudoku:
- No duplicates in rows.
- No duplicates in columns.
- No duplicates in 3x3 boxes.
- Empty cells are represented by '-'.

---

### **All Possible Test Cases for Sudoku**

#### **1. Valid Cases**
These are the cases where the function should return `true` because the Sudoku is valid:
1. **Completely Empty Board**:
    - All cells are '-'.
    - Description: "A 9x9 board that is completely empty has no duplicates, so it is valid."
    - Expected: `true`.

   ```kotlin
   check(
       name = "when board is empty, return true",
       result = isValidSudoku(emptyBoard),
       correctResult = true
   )
   ```

2. **Partially Filled Board with No Duplicates**:
    - A board with some numbers (from 1 to 9) and the rest as '-', with no duplicates in any row, column, or 3x3 box.
    - Description: "A partially filled board where the existing values do not duplicate in any row, column, or box."
    - Expected: `true`.

   ```kotlin
   check(
       name = "when board is partially filled with no duplicates, return true",
       result = isValidSudoku(partialValidBoard),
       correctResult = true
   )
   ```

3. **Fully Filled and Valid Board**:
    - A 9x9 board fully filled with numbers from 1 to 9, with no duplicates in rows, columns, or boxes.
    - Description: "A fully filled board with a completely valid solution."
    - Expected: `true`.

   ```kotlin
   check(
       name = "when board is fully filled and valid, return true",
       result = isValidSudoku(fullValidBoard),
       correctResult = true
   )
   ```

---

#### **2. Invalid Cases**
These are the cases where the function should return `false` because there is an error in the Sudoku:
4. **Duplicate in the Same Row**:
    - A duplicated number (e.g., '5') in the same row.
    - Description: "A number duplicated in a single row, making the Sudoku invalid."
    - Expected: `false`.

   ```kotlin
   check(
       name = "when board has duplicate in same row, return false",
       result = isValidSudoku(rowDuplicateBoard),
       correctResult = false
   )
   ```

5. **Duplicate in the Same Column**:
    - A duplicated number (e.g., '7') in the same column.
    - Description: "A number duplicated in a single column, making the Sudoku invalid."
    - Expected: `false`.

   ```kotlin
   check(
       name = "when board has duplicate in same column, return false",
       result = isValidSudoku(colDuplicateBoard),
       correctResult = false
   )
   ```

6. **Duplicate in the Same 3x3 Box**:
    - A duplicated number (e.g., '3') in the same 3x3 box (e.g., top-left or bottom-right).
    - Description: "A number duplicated in a single 3x3 box, making the Sudoku invalid."
    - Expected: `false`.

   ```kotlin
   check(
       name = "when board has duplicate in same 3x3 box, return false",
       result = isValidSudoku(boxDuplicateBoard),
       correctResult = false
   )
   ```

7. **Incorrect Board Size**:
    - A board that is not 9x9 (e.g., 4x4 or 8x8) and does not follow standard Sudoku rules.
    - Description: "A board smaller or larger than 9x9, making it unacceptable."
    - Expected: `false`.

   ```kotlin
   check(
       name = "when board is not 9x9, return false",
       result = isValidSudoku(invalidSizeBoard),
       correctResult = false
   )
   ```

---

#### **3. Edge Cases**
These are cases that test behavior under special conditions:
8. **Board with Only One Value**:
    - A board with all cells '-' except one cell containing a number (e.g., '1').
    - Description: "One filled cell with the rest empty, no duplicates, so it is valid."
    - Expected: `true`.

   ```kotlin
   check(
       name = "when board has only one value, return true",
       result = isValidSudoku(singleValueBoard),
       correctResult = true
   )
   ```

9. **Board with Invalid Numbers**:
    - A board with values outside the allowed range (e.g., '0' or 'a' instead of 1-9 or '-').
    - Description: "Values not permitted in Sudoku, making it invalid."
    - Expected: `false`.

   ```kotlin
   check(
       name = "when board has invalid characters, return false",
       result = isValidSudoku(invalidCharBoard),
       correctResult = false
   )
   ```

10. **Board with a Full Row or Column with No Duplicates**:
    - A single row or column filled with numbers from 1 to 9 without duplicates, and the rest '-'.
    - Description: "A full row or column with no duplicates, so it is valid."
    - Expected: `true`.

    ```kotlin
    check(
        name = "when board has a full row with no duplicates, return true",
        result = isValidSudoku(fullRowBoard),
        correctResult = true
    )
    ```

11. **Board with a Full 3x3 Box with No Duplicates**:
    - A single 3x3 box filled with numbers from 1 to 9 (distributed across 9 cells) without duplicates, and the rest '-'.
    - Description: "A full 3x3 box with no duplicates, so it is valid."
    - Expected: `true`.

    ```kotlin
    check(
        name = "when board has a full 3x3 box with no duplicates, return true",
        result = isValidSudoku(fullBoxBoard),
        correctResult = true
    )
    ```

---

### **Summary of Test Cases**
- **Number of Cases**: 11 cases.
    - Valid Cases (3): Empty board, partially filled valid board, fully filled valid board.
    - Invalid Cases (4): Duplicate in row, duplicate in column, duplicate in box, incorrect size.
    - Edge Cases (4): Single value, invalid characters, full row/column, full box.
