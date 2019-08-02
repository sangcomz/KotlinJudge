import kotlin.math.pow

fun completeBinaryTree(input: IntArray): IntArray {
    return  getBinaryTreeValue(1, input).groupBy { it.first }.flatMap { it.value }.map { it.second }.toIntArray()
}

fun getBinaryTreeValue(currentDepth:Int, input:IntArray) : ArrayList<Pair<Int, Int>> {
    val arrayList:ArrayList<Pair<Int, Int>> = arrayListOf()
    var depth = 1
    while (2.0.pow(depth.toDouble()) < input.size) {
        depth++
    }
    if (2.0.pow(depth.toDouble()).toInt() == input.size) depth++
    val remainder: Int = (input.size - 2.0.pow(depth.toDouble() - 2) * 2 + 1).toInt()
    val lastDepthSize = 2.0.pow(depth - 1).toInt()
    val rightSize: Int =
        (2.0.pow(depth.toDouble() - 2) - 1 + if (remainder - (lastDepthSize / 2) > 0)
            remainder - (lastDepthSize / 2)
        else
            0).toInt()
    val centerIndex = input.size - (rightSize + 1)
    val left = input.slice(0 until centerIndex).toIntArray()
    val right = input.slice(centerIndex+1..input.lastIndex).toIntArray()

    arrayList.add(currentDepth to input[centerIndex])

    if (left.isNotEmpty()){
        arrayList += getBinaryTreeValue(currentDepth + 1, left)
    }
    if (right.isNotEmpty()){
        arrayList += getBinaryTreeValue(currentDepth + 1 ,right)
    }
    return arrayList
}


//fun completeBinaryTree(input: IntArray):IntArray {
//    val output = IntArray(input.size)
//    var k = 0
//    fun h(i: Int): Unit {
//        if (i >= input.size) return
//        h(2 * i + 1)
//        output[i] = input[k++]
//        h(2 * i + 2)
//    }
//    h(0)
//    return output
//}