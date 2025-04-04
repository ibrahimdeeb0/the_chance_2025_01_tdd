package IPv4AddressChecker

fun main() {
    // 1. Valid Cases

    val normalAddress = "192.168.1.1"
    check(
        name = "when address is a valid IPv4, return true",
        result = isValidIPv4(normalAddress),
        correctResult = true
    )

    val zeroAddress = "0.0.0.0"
    check(
        name = "when address has zeros in each segment, return true",
        result = isValidIPv4(zeroAddress),
        correctResult = true
    )

    val maxAddress = "255.255.255.255"
    check(
        name = "when address has max values in each segment, return true",
        result = isValidIPv4(maxAddress),
        correctResult = true
    )

    val mixedAddress = "0.255.128.1"
    check(
        name = "when address includes a mix of minimum (0), maximum (255), and mid-range (128) octets, return true",
        result = isValidIPv4(mixedAddress),
        correctResult = true
    )

    // 2. Invalid Cases

    val leadingZerosAddress = "192.168.01.1"
    check(
        name = "when address has leading zeros, return false",
        result = isValidIPv4(leadingZerosAddress),
        correctResult = false
    )

    val over255Address = "192.168.256.1"
    check(
        name = "when address has segment > 255, return false",
        result = isValidIPv4(over255Address),
        correctResult = false
    )

    val lessSegmentsAddress = "192.168.1"
    check(
        name = "when address has less than 4 segments, return false",
        result = isValidIPv4(lessSegmentsAddress),
        correctResult = false
    )

    val moreSegmentsAddress = "192.168.1.1.1"
    check(
        name = "when address has more than 4 segments, return false",
        result = isValidIPv4(moreSegmentsAddress),
        correctResult = false
    )

    val lettersAddress = "192.168.1.a"

    check(
        name = "when address has letters, return false",
        result = isValidIPv4(lettersAddress),
        correctResult = false
    )

    val consecutiveDotsAddress = "192..168.1"
    check(
        name = "when address has empty segment, return false",
        result = isValidIPv4(consecutiveDotsAddress),
        correctResult = false
    )


    // 3. Edge Cases
    val emptyStringAddress = ""
    check(
        name = "when address is empty string, return false",
        result = isValidIPv4(emptyStringAddress),
        correctResult = false
    )

    val negativeNumberAddress = "192.168.-1.1"
    check(
        name = "when address has negative number like 192.168.-1.1, return false",
        result = isValidIPv4(negativeNumberAddress),
        correctResult = false
    )

    val onlyDotsAddress = "..."
    check(
        name = "when address contains only dots and no numeric octets, return false",
        result = isValidIPv4(onlyDotsAddress),
        correctResult = false
    )

    val spacesAddress = "192.168. 1.1"
    check(
        name = "when address has spaces in any segment, return false",
        result = isValidIPv4(spacesAddress),
        correctResult = false
    )
}

fun check(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name | Expected: $correctResult, Got: $result")
    }
}

fun isValidIPv4(address: String): Boolean {
    // Check if the string is empty
    if (address.isEmpty()) return false

    // Split the address by dots
    val segments = address.split(".")

    // Check if there are exactly 4 segments
    if (segments.size != 4) return false

    // Validate each segment
    for (segment in segments) {
        // Check for empty segments (e.g., "192.168..1")
        if (segment.isEmpty()) return false

        // Check for leading zeros (e.g., "01" or "001")
        if (segment.length > 1 && segment[0] == '0') return false

        // Check if the segment is a valid number
        val number = segment.toIntOrNull() ?: return false // Returns false if not a number

        // Check if the number is between 0 and 255
        if (number !in 0..255) return false
    }

    // Check if the original string has exactly 3 dots and no extra characters
    val dotCount = address.count { it == '.' }
    return dotCount == 3
}