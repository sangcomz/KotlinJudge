import java.util.*
import kotlin.math.sign

val getRotArray: (CharArray, Int) -> CharArray = { oriArray, startIndex ->
    val resultArray = oriArray.copyOf()
    for (i in oriArray.lastIndex downTo startIndex) {
        val index = if (i - 1 < startIndex) oriArray.lastIndex else i - 1
        resultArray[index] = oriArray[i]
    }

    resultArray
}

fun maxRot(n: Long): Long {
    var originalN = n.toString().toCharArray()
    val resultArray = arrayListOf(n)
    for (i in 0 until originalN.lastIndex){
        originalN = getRotArray(originalN, i)
        resultArray.add(originalN.joinToString("").toLong())
    }
    return resultArray.max() ?: n
}

//fun maxRot(n:Long):Long {
//
//    val numberList = arrayListOf<Long>()
//    numberList.add(n)
//    var text = n.toString()
//
//    (1 until n.toString().length).forEach { t ->
//        text = text.removeRange(t-1, t) + text[t-1]
//        numberList.add(text.toLong())
//    }
//
//    return numberList.reduce{ max, element -> if(element > max) element else max}
//}

//fun maxRot(n:Long):Long =
//    generateSequence ("" to n.toString()) {
//        if (it.second.length < 2) null
//        else it.first + it.second[1] to it.second.substring(2) + it.second[0]
//    }.map {
//        (it.first + it.second).toLong()
//    }.max()?:n