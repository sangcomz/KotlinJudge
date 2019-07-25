package weight

fun orderWeight(string: String) = string
    .split(" ")
    .map {
        it to it
            .toCharArray()
            .map(Character::getNumericValue)
            .sum()
    }
    .sortedWith(compareBy({ it.second }, { it.first }))
    .map { it.first }
    .joinToString(" ")

//fun orderWeight(string: String): String {
//    return string.split(" ")
//        .sortedWith(compareBy<String> { it.toCharArray().map(Char::toString).map(String::toInt).sum() }.thenBy { it })
//        .joinToString(" ")
//}
