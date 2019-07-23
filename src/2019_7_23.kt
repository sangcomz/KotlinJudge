//https://www.codewars.com/kata/52e88b39ffb6ac53a400022e/train/kotlin

import kotlin.math.pow

fun longToIP(ip: UInt) = Integer
    .toBinaryString(ip.toInt())
    .reversed()
    .toCharArray()
    .withIndex()
    .groupBy {
        it.index / 8
    }
    .map {
        it.value.sumBy {
            if (it.value == '1') {
                2.0.pow(it.index.toDouble() % 8).toInt()
            } else
                0
        }
    }
    .let {
        "${it.getOrNull(3) ?: 0}" +
                ".${it.getOrNull(2) ?: 0}" +
                ".${it.getOrNull(1) ?: 0}" +
                ".${it.getOrNull(0) ?: 0}"
    }