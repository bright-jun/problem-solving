package exercise.leetcode.kotlin

class Solution50 {

    fun myPow(x: Double, n: Int): Double {
        return myPow_3(x, n)
    }

    /**
     * Time : O(?)
     * Space: O(1)
     */
    fun myPow_1(x: Double, n: Int): Double {
        return Math.pow(x, n.toDouble())
    }

    /**
     * Time : O(N) TLE
     * Space: O(1)
     */
    fun myPow_2(x: Double, n: Int): Double {
        var answer: Double = 1.0
        var base: Double = x
        var exponent: Int = n
        if (n < 0) {
            base = 1 / x
            exponent = n * -1
        }
        for (i in 0..exponent - 1) {
            answer *= base
        }
        return answer
    }

    /**
     * Merge and Conquer
     * Time : O(logN)
     * Space: O(1)
     */
    fun myPow_3(x: Double, n: Int): Double {
        var base = x
        var exponent: Long = n.toLong()
        if (exponent < 0) {
            base = 1 / base
            exponent = -exponent
        }
        if (base == 1.0) {
            return 1.0
        }
        if (exponent == 0L) {
            return 1.0
        } else if (exponent % 2 == 0L) {
            return myPow_3(base * base, (exponent / 2).toInt())
        } else {
            return base * myPow_3(base, (exponent - 1).toInt())
        }
    }
}

fun main() {
    val solution50 = Solution50()
    var answer: Double
    answer = solution50.myPow(2.00000, 10)
    println("output: $answer\texpected: 1024.00000")
    answer = solution50.myPow(2.10000, 3)
    println("output: $answer\texpected: 9.26100")
    answer = solution50.myPow(2.00000, -2)
    println("output: $answer\texpected: 0.25000")
    answer = solution50.myPow(1.00000, Int.MAX_VALUE)
    println("output: $answer\texpected: 1.00000")
    answer = solution50.myPow(1.00000, Int.MIN_VALUE)
    println("output: $answer\texpected: 1.00000")
    answer = solution50.myPow(-2.00000, 2)
    println("output: $answer\texpected: 4.00000")
}
