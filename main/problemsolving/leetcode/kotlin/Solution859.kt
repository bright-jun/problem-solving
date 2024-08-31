package problemsolving.leetcode.kotlin

class Solution859 {

    /**
     * 1 <= s.length, goal.length <= 2 * 10^4
     * s and goal consist of lowercase letters.
     */
    fun buddyStrings(s: String, goal: String): Boolean {
        return buddyStrings_1(s, goal)
    }

    /**
     * Time : O(N)
     * Space: O(1)
     */
    fun buddyStrings_1(s: String, goal: String): Boolean {
        if (s.length != goal.length) {
            return false
        }

        val length = s.length
        var count = 0
        val mem = mutableListOf<Char>()
        for (i in 0 until length) {
            if (s[i] != goal[i]) {
                count++
                mem.add(s[i])
                mem.add(goal[i])
                if (count > 2) {
                    return false
                }
            }
        }
        if (count == 2) {
            // ab ~ ba -> true
            // aa ~ bb -> false
            return (mem[0] == mem[3]) && (mem[1] == mem[2])
        } else if (count == 0) {
            // ab ~ ab -> false
            // aa ~ aa -> true
            val alphabets: MutableMap<Char, Int> = mutableMapOf()
            for (i in 0 until length) {
                alphabets[s[i]] = (alphabets[s[i]] ?: 0) + 1
                if (alphabets[s[i]] == 2) return true
            }
            return false
        } else {
            return false
        }
    }
}

fun main() {
    val solution859 = Solution859()
    var answer: Boolean
    answer = solution859.buddyStrings("ab", "ba")
    println("output: $answer\texpected: true")
    answer = solution859.buddyStrings("ab", "ab")
    println("output: $answer\texpected: false")
    answer = solution859.buddyStrings("aa", "aa")
    println("output: $answer\texpected: true")
    answer = solution859.buddyStrings("abcaa", "abcbb")
    println("output: $answer\texpected: false")
    answer = solution859.buddyStrings("abac", "abad")
    println("output: $answer\texpected: false")
}
