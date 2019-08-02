package besttravel

import kotlin.math.absoluteValue

fun chooseBestSum(t: Int, k: Int, ls: List<Int>): Int {
    println("input ::: $t, $k, ${ls}")
    if (k == 1) {
        return t - ls.run {
            getMinValue(t, this)
        }
    }
    if (k == ls.size){
        val sum = ls.sum()
        if (sum > t){
            return -1
        }
        else
           return sum
    }
    val filterList =  ls.filter { it < t }
    if (filterList.size < k) return -1
    println(filterList)

    val combinations = filterList.combinations(k)
    return t - getMinValueWithIndexed(t, combinations)
}


fun <T> List<T>.combinations(combinationSize: Int): List<List<T>> = when {
    combinationSize < 0 -> throw Error("combinationSize cannot be smaller then 0. It is equal to $combinationSize")
    combinationSize == 0 -> listOf(listOf())
    combinationSize >= size -> listOf(listOf())
    else -> powerset()
        .filter { it.size == combinationSize }
}

fun <T> Collection<T>.powerset(): List<List<T>> = powerset(this, listOf(listOf()))

private fun <T> powerset(left: Collection<T>, acc: List<List<T>>): List<List<T>> = when {
    left.isEmpty() -> acc
    else -> powerset(left.drop(1), acc + acc.map { it + left.first() })
}



//fun <T> Set<T>.combinations(combinationSize: Int): Set<Set<T>> = when {
//    combinationSize < 0 -> throw Error("combinationSize cannot be smaller then 0. It is equal to $combinationSize")
//    combinationSize == 0 -> setOf(setOf())
//    combinationSize >= size -> setOf(toSet())
//    else -> powerset()
//        .filter { it.size == combinationSize }
//        .toSet()
//}
//
//fun <T> Collection<T>.powerset(): Set<Set<T>> = powerset(this, setOf(setOf()))
//
//private tailrec fun <T> powerset(left: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> = when {
//    left.isEmpty() -> acc
//    else -> powerset(left.drop(1), acc + acc.map { it + left.first() })
//}


fun getMinValue(t: Int, list: List<Int>): Int {
    var minValue: Int? = null;
    list.forEach {
        val value = t - it
        if (it > t || value < 0) return@forEach
        if (it == t) return 0
        if (minValue == null) {
            minValue = value
        } else {
            minValue?.let {
                if (value < it)
                    minValue = value
            }
        }
    }
    return minValue ?: t + 1
}
fun getMinValueWithIndexed(t: Int, setSet: List<List<Int>>): Int {
    var minValue: Int? = null;
    setSet.forEach {
        val sum = it.sum()
        val value = t - sum
        if (sum > t || value < 0) return@forEach
        if (sum == t) return 0
        if (minValue == null) {
            minValue = value
        } else {
            minValue?.let {
                if (value < it)
                    minValue = value
            }
        }
    }
    return minValue ?: t + 1
}

//fun getMinValueWithIndexed(t: Int, setSet: Set<Set<IndexedValue<Int>>>): Int {
//    var minValue: Int? = null;
//    setSet.forEach {
//        val sum = it.sumBy { it.value }
//        val value = t - sum
//        if (sum > t || value < 0) return@forEach
//        if (sum == t) return 0
//        if (minValue == null) {
//            minValue = value
//        } else {
//            minValue?.let {
//                if (value < it)
//                    minValue = value
//            }
//        }
//    }
//    return minValue ?: t + 1
//}



//fun chooseBestSum(t:Int, k:Int, ls:List<Int>, traveled: Int = 0):Int {
//    if(k == 0) return if(traveled <= t) traveled else -1
//    return ls.mapIndexed { i, d -> chooseBestSum(t, k-1, ls.subList(i+1, ls.size), traveled + d) }.max() ?: -1
//}



//fun chooseBestSum(t:Int, k:Int, ls:List<Int>):Int {
//    var result = -1
//    for (i in ls.indices)
//    {
//        if (ls.get(i) <= t)
//        {
//            if (k == 1)
//            {
//                result = Math.max(result, ls.get(i))
//            }
//            else
//            {
//                val temp = chooseBestSum(t - ls.get(i), k - 1, ls.subList(i + 1, ls.size))
//                if (temp != -1)
//                {
//                    result = Math.max(result, ls.get(i) + temp)
//                }
//            }
//        }
//    }
//    if (result < 0) return -1
//    return result
//}