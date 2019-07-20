fun productFib(prod: Long): LongArray {
    // your code
    return generateSequence(arrayListOf(0L, 1L)) {
        it.apply {
            add(it.last() + it[it.lastIndex - 1])
        }
    }
        .takeWhile {
            prod >= it.last() * it[it.lastIndex - 1]
        }
        .map {
            val isSame = if (prod == it.last() * it[it.lastIndex - 1]) 1L else 0L
            val firstElement = if (isSame == 1L) it[it.lastIndex - 1] else it.last()
            val secondElement = if (isSame == 1L) it.last() else it.slice(it.lastIndex-1..it.lastIndex).sum()
            longArrayOf(firstElement, secondElement, isSame)
        }
        .last()
}
