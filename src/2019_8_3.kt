package kprimes

fun countKprimes(k: Int, start: Long, end: Long): LongArray {
    println("$k, $start, $end")
    return (start..end)
        .filter {
            isKPrimeNumber(k, it) == k
        }
        .toList()
        .toLongArray()
}

//puzzle(138)  -->  1  because [2 + 8 + 128] is the only solution
//puzzle(143)  -->  2  because [3 + 12 + 128] and [7 + 8 + 128] are the solutions
fun puzzle(s: Int): Int {
    println("puzzle $s")
    return countKprimes(7, 0, s.toLong())
        .map { s - it }
        .flatMap { reminder ->
            countKprimes(3, 0, reminder).map { reminder - it }.toList()
        }
        .flatMap { reminder ->
            countKprimes(1, 0, reminder).filter { reminder == it }.toList()
        }.count()

}

tailrec fun isKPrimeNumber(k: Int, n: Long, currentCount: Int = 0): Int? {
    if (k == currentCount) {
        return null
    }
    if (n == -1L) {
        return currentCount + 1
    }
    var number: Long? = null
    for (i in 2..n / 2) {
        if (n % i == 0L) {
            number = n / i
            break
        }
    }
    return isKPrimeNumber(k, number ?: -1L, if (number != null) currentCount + 1 else currentCount)
}


fun main() {
    val startTime = System.currentTimeMillis()
//    println(countKprimes(6, 5764301, 5766587).contentToString())
//    println(countKprimes(2, 5458717, 5460434).contentToString())
//    println(countKprimes(5, 500, 600).contentToString())
    println(countKprimes(4, 7962670, 7965230).contentToString())
    println(System.currentTimeMillis() - startTime)
}


//package kprimes
//
//fun countKprimes(k: Int, start: Long, end: Long): LongArray {
//    return (start..end).filterTo(ArrayList()) { found(it) + 1 == k }.toLongArray()
//}
//
//tailrec fun found(input: Long, primes: Int = 2, count: Int = 0): Int {
//    return if (primes <= input / primes && (input % primes).toInt() != 0) found(input, primes + 1, count)
//    else if (primes <= input / primes) found(input / primes, 2, count + 1)
//    else count
//}
//
//fun puzzle(s: Int): Int {
//    val aarray = countKprimes(1, 2, s.toLong())
//    val barray = countKprimes(3, 8, s.toLong())
//    val carray = countKprimes(7, 128, s.toLong())
//    var count = 0
//
//    carray.map { s - it }.forEach {
//        for (b in barray) {
//            if (b > it) {
//                return@forEach
//            }
//            val remain2 = it - b
//            if (aarray.contains(remain2)) {
//                count++
//            }
//        }
//    }
//    return count
//}

