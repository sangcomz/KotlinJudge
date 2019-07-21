fun incrementString(str: String) = str.map { it.toInt() }
    .groupBy { it.isASCIINumber() }
    .let {
        val stringValue = it[false]?.map { it.toChar() }?.joinToString("") ?: ""
        val intValue = it[true]?.map { it.toChar() }?.joinToString("")?.toInt()?.inc() ?: 1

        String.format("%s%0${it[true]?.size ?: "1"}d", stringValue, intValue)
    }


fun Int.isASCIINumber() = this in 48..57


//fun incrementString(str: String): String {
//    return str.replace(Regex("([0-8]?)(9*)$")) { m ->
//        val (d, ds) = m.destructured
//        "${if (d.isEmpty()) 1 else d.toInt() + 1}${ds.replace('9', '0')}"
//    }
//}

//fun incrementString(str: String) : String {
//    val i = str.takeLastWhile { it.isDigit() }
//    return str.dropLast(i.length) + ((i.toIntOrNull() ?: 0) + 1).toString().padStart(i.length, '0')
//}