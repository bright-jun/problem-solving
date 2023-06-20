package exercise.leetcode.kotlin

class Solution2090 {

    /**
     * n == nums.length
     * 1 <= n <= 10^5
     * 0 <= nums[i], k <= 10^5
     */
    fun getAverages(nums: IntArray, k: Int): IntArray {
        return getAverages_1(nums, k)
    }

    /**
     * Time : O(N)
     * Space: O(1)
     */
    fun getAverages_1(nums: IntArray, k: Int): IntArray {
        val answer = mutableListOf<Int>()
        val n: Long = (k * 2 + 1).toLong()
        if (nums.size < n) {
            for (i in 1..nums.size) {
                answer.add(-1)
            }
            return answer.toIntArray()
        }
        for (i in 1..k) {
            answer.add(-1)
        }
        val left = 0
        val right = k * 2
        var sum: Long = nums.copyOfRange(left, right + 1).map { i -> i.toLong() }.sum()
        for (i in 0..nums.size) {
            answer.add((sum / n).toInt())
            if (right + i + 1 >= nums.size) {
                break
            }
            sum += -nums[left + i]
            sum += nums[right + i + 1]
        }
        for (i in 1..k) {
            answer.add(-1)
        }
        return answer.toIntArray()
    }
}

fun main() {
    val solution2090 = Solution2090()
    var answer: IntArray
    answer = solution2090.getAverages(intArrayOf(7, 4, 3, 9, 1, 8, 5, 2, 6), 3)
    println("output  : ${answer.toList()}\nexpected: ${listOf(-1, -1, -1, 5, 4, 4, -1, -1, -1)}")
    answer = solution2090.getAverages(intArrayOf(100000), 0)
    println("output  : ${answer.toList()}\nexpected: ${listOf(100000)}")
    answer = solution2090.getAverages(intArrayOf(8), 10000)
    println("output  : ${answer.toList()}\nexpected: ${listOf(-1)}")
}
