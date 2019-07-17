    fun evenNumbers(array: List<Int>, number: Int): List<Int> {
        // good luck
        return array.filter { it % 2 == 0 }.takeLast(number)
    }

    fun getCount(str: String): Int {
        return str.filter {
            it == 'a'
                    || it == 'e'
                    || it == 'i'
                    || it == 'o'
                    || it == 'u'
        }.length
    }

    /**
     * pp0 현재 인구
     * percent 1 year
     * aug 이주민
     * p 목표 인구
     */
    fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int): Int {
        var currentPopulation = pp0
        var year = 0
        while (currentPopulation < p) {
            year++
            currentPopulation += (currentPopulation * percent / 100).toInt() + aug
        }
        return year
    }
    //best
//    fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int): Int =
//        generateSequence(pp0.toDouble()) { it * (1 + percent / 100) + aug }.takeWhile { it < p }.count()
