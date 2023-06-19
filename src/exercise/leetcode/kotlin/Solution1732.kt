package exercise.leetcode.kotlin

class Solution1732 {

    /**
     * n == gain.length
     * 1 <= n <= 100
     * -100 <= gain[i] <= 100
     */
    fun largestAltitude(gain: IntArray): Int {
        return largestAltitude_1(gain)
    }

    /**
     * Time : O(N)
     * Space: O(1)
     */
    fun largestAltitude_1(gain: IntArray): Int {
        var largestAltitude = 0
        var nowAltitude = 0
        gain.forEach { g: Int ->
            nowAltitude += g
            largestAltitude = maxOf(largestAltitude, nowAltitude)
        }
        return largestAltitude
    }

}

fun main() {
    val solution1732 = Solution1732()
    var answer: Int
    answer = solution1732.largestAltitude(intArrayOf(-5, 1, 5, 0, -7))
    println("output: $answer\texpected: 1")
    answer = solution1732.largestAltitude(intArrayOf(-4, -3, -2, -1, 4, 3, 2))
    println("output: $answer\texpected: 0")
}
