package exercise.leetcode.kotlin

class Solution11 {
    /**
     * n == height.length
     * 2 <= n <= 10^5
     * 0 <= height[i] <= 10^4
     */
    fun maxArea(height: IntArray): Int {
        return maxArea_2(height)
    }

    /**
     * Time : O(N^2)
     * Space: O(1)
     */
    fun maxArea_1(height: IntArray): Int {
        var maxArea: Int = Int.MIN_VALUE
        for (i in 0 until height.size) {
            for (j in i until height.size) {
                maxArea = maxOf(maxArea, getArea(i, j, height))
            }
        }
        return maxArea
    }

    /**
     * Time : O(N)
     * Space: O(1)
     */
    fun maxArea_2(height: IntArray): Int {
        var maxArea: Int = Int.MIN_VALUE
        var left = 0
        var right = height.size - 1
        while (left < right) {
            maxArea = maxOf(maxArea, getArea(left, right, height))
            if (height[left] < height[right]) {
                // don't need to check Area[left, right-N]
                // because
                // height[left] < height[right]
                // max(height[left], height[right]) >= max(height[left], height[right-N])
                // width(left, right) > width(left, right-N)
                // Area[left, right] > Area[left, right-N]
                left++
            } else if (height[left] > height[right]) {
                // Area[left, right] > Area[left+N, right]
                right--
            } else {
                // don't need to check both Area[left, right-N] & Area[left+N, right]
                // Area[left, right] > Area[left, right-N]
                // Area[left, right] > Area[left+N, right]
                left++
            }
        }
        return maxArea
    }

    fun getArea(left: Int, right: Int, height: IntArray): Int =
        minOf(height[left], height[right]) * (right - left)
}

fun main() {
    val solution11 = Solution11()
    var answer: Int
    answer = solution11.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
    println("output: $answer\texpected: 49")
    answer = solution11.maxArea(intArrayOf(1, 1))
    println("output: $answer\texpected: 1")
}
