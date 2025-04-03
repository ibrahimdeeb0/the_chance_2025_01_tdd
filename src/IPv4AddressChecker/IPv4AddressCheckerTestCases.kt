package IPv4AddressChecker


fun main() {
    // 1. Valid Cases
    val normalAddress = "192.168.1.1"
    // 1.1
    check(
        name = "when address is a valid IPv4 like 192.168.1.1, return true",
        result = isValidIPv4(normalAddress),
        correctResult = true
    )

    val zeroAddress = "0.0.0.0"
    // 1.2
    check(
        name = "when address has zeros like 0.0.0.0, return true",
        result = isValidIPv4(zeroAddress),
        correctResult = true
    )

    val maxAddress = "255.255.255.255"
    // 1.3
    check(
        name = "when address has max values like 255.255.255.255, return true",
        result = isValidIPv4(maxAddress),
        correctResult = true
    )

    val mixedAddress = "0.255.128.1"
    // 1.4
    check(
        name = "when address is mixed like 0.255.128.1, return true",
        result = isValidIPv4(mixedAddress),
        correctResult = true
    )

    // 2. Invalid Cases
    val leadingZerosAddress = "192.168.01.1"
    // 2.1
    check(
        name = "when address has leading zeros like 192.168.01.1, return false",
        result = isValidIPv4(leadingZerosAddress),
        correctResult = false
    )

    val over255Address = "192.168.256.1"
    // 2.2
    check(
        name = "when address has segment > 255 like 192.168.256.1, return false",
        result = isValidIPv4(over255Address),
        correctResult = false
    )

    val lessSegmentsAddress = "192.168.1"
    // 2.3
    check(
        name = "when address has less than 4 segments like 192.168.1, return false",
        result = isValidIPv4(lessSegmentsAddress),
        correctResult = false
    )

    val moreSegmentsAddress = "192.168.1.1.1"
    // 2.4
    check(
        name = "when address has more than 4 segments like 192.168.1.1.1, return false",
        result = isValidIPv4(moreSegmentsAddress),
        correctResult = false
    )

    val lettersAddress = "192.168.1.a"
    // 2.5
    check(
        name = "when address has letters like 192.168.1.a, return false",
        result = isValidIPv4(lettersAddress),
        correctResult = false
    )

    val consecutiveDotsAddress = "192..168.1"
    // 2.6
    check(
        name = "when address has consecutive dots like 192..168.1, return false",
        result = isValidIPv4(consecutiveDotsAddress),
        correctResult = false
    )

    val emptySegmentAddress = "192.168..1"
    // 2.7
    check(
        name = "when address has empty segment like 192.168..1, return false",
        result = isValidIPv4(emptySegmentAddress),
        correctResult = false
    )

    // 3. Edge Cases
    val emptyStringAddress = ""
    // 3.1
    check(
        name = "when address is empty string, return false",
        result = isValidIPv4(emptyStringAddress),
        correctResult = false
    )

    val negativeNumberAddress = "192.168.-1.1"
    // 3.2
    check(
        name = "when address has negative number like 192.168.-1.1, return false",
        result = isValidIPv4(negativeNumberAddress),
        correctResult = false
    )

    val onlyDotsAddress = "..."
    // 3.3
    check(
        name = "when address is just dots like ..., return false",
        result = isValidIPv4(onlyDotsAddress),
        correctResult = false
    )

    val spacesAddress = "192.168. 1.1"
    // 3.4
    check(
        name = "when address has spaces like 192.168. 1.1, return false",
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
    return false // need implementation
}
