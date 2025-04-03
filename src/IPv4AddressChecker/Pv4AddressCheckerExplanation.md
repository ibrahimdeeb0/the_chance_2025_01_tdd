
### **Rules for IPv4 Address Checker**:
- Four numeric segments between 0 and 255, separated by exactly 3 dots.
- Leading zeros are not allowed unless the number is "0" itself.
- No extra characters or symbols are allowed except for dots.

---

### **All Possible Test Cases for IPv4 Address Checker**

#### **1. Valid Cases**
These are the cases where the function should return `true` because the address is valid:
1. **Normal Valid IPv4 Address**
    - **Description**: A standard address with 4 segments, all between 0 and 255, with no leading zeros.
    - **Example**: "192.168.1.1".
    - **Expected**: `true`.
   ```kotlin
   check(
       name = "when address is a valid IPv4 like 192.168.1.1, return true",
       result = isValidIPv4("192.168.1.1"),
       correctResult = true
   )
   ```

2. **Address with Zero Segments**
    - **Description**: An address containing "0" segments, which is allowed.
    - **Example**: "0.0.0.0".
    - **Expected**: `true`.
   ```kotlin
   check(
       name = "when address has zeros like 0.0.0.0, return true",
       result = isValidIPv4("0.0.0.0"),
       correctResult = true
   )
   ```

3. **Address with Maximum Values**
    - **Description**: An address with segments at the maximum value of 255.
    - **Example**: "255.255.255.255".
    - **Expected**: `true`.
   ```kotlin
   check(
       name = "when address has max values like 255.255.255.255, return true",
       result = isValidIPv4("255.255.255.255"),
       correctResult = true
   )
   ```

4. **Mixed Address (Zeros, 255, and Regular Numbers)**
    - **Description**: An address with a mix of 0, 255, and numbers in between.
    - **Example**: "0.255.128.1".
    - **Expected**: `true`.
   ```kotlin
   check(
       name = "when address is mixed like 0.255.128.1, return true",
       result = isValidIPv4("0.255.128.1"),
       correctResult = true
   )
   ```

---

#### **2. Invalid Cases**
These are the cases where the function should return `false` because the address is invalid:
5. **Leading Zeros in a Segment**
    - **Description**: A segment with leading zeros (e.g., "01" or "001").
    - **Example**: "192.168.01.1".
    - **Expected**: `false`.
   ```kotlin
   check(
       name = "when address has leading zeros like 192.168.01.1, return false",
       result = isValidIPv4("192.168.01.1"),
       correctResult = false
   )
   ```

6. **Segment Greater Than 255**
    - **Description**: A segment with a number greater than 255.
    - **Example**: "192.168.256.1".
    - **Expected**: `false`.
   ```kotlin
   check(
       name = "when address has segment > 255 like 192.168.256.1, return false",
       result = isValidIPv4("192.168.256.1"),
       correctResult = false
   )
   ```

7. **Fewer Than 4 Segments**
    - **Description**: An address with fewer than 4 segments (less than 3 dots).
    - **Example**: "192.168.1".
    - **Expected**: `false`.
   ```kotlin
   check(
       name = "when address has less than 4 segments like 192.168.1, return false",
       result = isValidIPv4("192.168.1"),
       correctResult = false
   )
   ```

8. **More Than 4 Segments**
    - **Description**: An address with more than 4 segments (more than 3 dots).
    - **Example**: "192.168.1.1.1".
    - **Expected**: `false`.
   ```kotlin
   check(
       name = "when address has more than 4 segments like 192.168.1.1.1, return false",
       result = isValidIPv4("192.168.1.1.1"),
       correctResult = false
   )
   ```

9. **Letters or Disallowed Symbols**
    - **Description**: An address containing letters or symbols other than dots and numbers.
    - **Example**: "192.168.1.a".
    - **Expected**: `false`.
   ```kotlin
   check(
       name = "when address has letters like 192.168.1.a, return false",
       result = isValidIPv4("192.168.1.a"),
       correctResult = false
   )
   ```

10. **Consecutive Dots**
    - **Description**: An address with consecutive dots without numbers between them.
    - **Example**: "192..168.1".
    - **Expected**: `false`.
    ```kotlin
    check(
        name = "when address has consecutive dots like 192..168.1, return false",
        result = isValidIPv4("192..168.1"),
        correctResult = false
    )
    ```

11. **Empty Segment**
    - **Description**: An address with an empty segment due to an extra or missing dot.
    - **Example**: "192.168..1".
    - **Expected**: `false`.
    ```kotlin
    check(
        name = "when address has empty segment like 192.168..1, return false",
        result = isValidIPv4("192.168..1"),
        correctResult = false
    )
    ```

---

#### **3. Edge Cases**
These are cases that test the inputs under special conditions:
12. **Empty String**
    - **Description**: The input string is empty.
    - **Example**: "".
    - **Expected**: `false`.
    ```kotlin
    check(
        name = "when address is empty string, return false",
        result = isValidIPv4(""),
        correctResult = false
    )
    ```

13. **Negative Number**
    - **Description**: A segment contains a negative number.
    - **Example**: "192.168.-1.1".
    - **Expected**: `false`.
    ```kotlin
    check(
        name = "when address has negative number like 192.168.-1.1, return false",
        result = isValidIPv4("192.168.-1.1"),
        correctResult = false
    )
    ```

14. **Only Dots Without Numbers**
    - **Description**: The string consists entirely of dots with no numbers.
    - **Example**: "...".
    - **Expected**: `false`.
    ```kotlin
    check(
        name = "when address is just dots like ..., return false",
        result = isValidIPv4("..."),
        correctResult = false
    )
    ```

15. **Spaces in the Address**
    - **Description**: The string contains spaces.
    - **Example**: "192.168. 1.1".
    - **Expected**: `false`.
    ```kotlin
    check(
        name = "when address has spaces like 192.168. 1.1, return false",
        result = isValidIPv4("192.168. 1.1"),
        correctResult = false
    )
    ```

---
