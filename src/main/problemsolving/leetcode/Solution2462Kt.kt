package problemsolving.leetcode

class Solution2462Kt {

    /**
     * 1 <= costs.length <= 10^5
     * 1 <= costs[i] <= 10^5
     * 1 <= k, candidates <= costs.length
     */
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        return totalCost_1(costs, k, candidates)
    }

    /**
     * Time : O(N^2)
     * Space: O(1)
     */
    fun totalCost_1(costs: IntArray, k: Int, candidates: Int): Long {
        var answer: Long = 0
        val costs = costs.toMutableList()
        for (time in 1..k) {
            val min =
                minOf(
                    costs.take(candidates).toSortedSet().first(),
                    costs.takeLast(candidates).toSortedSet().first(),
                )
            answer += min
            costs.remove(min)
        }

        return answer
    }
}

fun main() {
    val solution2462 = Solution2462Kt()
    var answer: Long
    answer = solution2462.totalCost(intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8), 3, 4)
    println("output: $answer\texpected: 11")
    answer = solution2462.totalCost(intArrayOf(1, 2, 4, 1), 3, 3)
    println("output: $answer\texpected: 4")
    answer = solution2462.totalCost(
        intArrayOf(
            50,
            80,
            34,
            9,
            86,
            20,
            67,
            94,
            65,
            82,
            40,
            79,
            74,
            92,
            84,
            37,
            19,
            16,
            85,
            20,
            79,
            25,
            89,
            55,
            67,
            84,
            3,
            79,
            38,
            16,
            44,
            2,
            54,
            58,
        ),
        7,
        12,
    )
    println("output: $answer\texpected: 95")
}
