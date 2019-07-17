import kotlin.math.pow

fun digPow(n: Int, p: Int) = n.toString()
    .map(Character::getNumericValue)
    .mapIndexed { index, i ->
        i.toDouble().pow(p + index)
    }
    .sum()
    .toInt()
    .let {
        if (it % n == 0) it.div(n)
        else -1
    }