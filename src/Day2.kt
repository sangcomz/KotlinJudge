import java.math.BigDecimal

    fun highAndLow(numbers: String): String {
        val list = numbers.split(" ").map { it.toInt() }
        return "${list.max()} ${list.min()}"
    }

    //fun highAndLow(numbers: String) = numbers.split(' ').map(String::toInt).let { "${it.max()} ${it.min()}" }


    fun tribonacci(signature: DoubleArray, n: Int) = signature.copyOf(n)
        .also {
            for (i in 3 until n) {
                it[i] = (it[i - 1].toBigDecimal() + it[i - 2].toBigDecimal() + it[i - 3].toBigDecimal()).toDouble()
            }
        }
