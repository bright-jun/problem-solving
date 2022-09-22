package exercise.leetcode;

public class Solution557 {
	/*
	 * 1 <= s.length <= 5 * 10^4
	 * s contains printable ASCII characters.
	 * s does not contain any leading or trailing spaces.
	 * There is at least one word in s.
	 * All the words in s are separated by a single space.
	 */
	public String reverseWords(String s) {

		StringBuilder answer = new StringBuilder();
		String[] words = s.split(" ");

		for (String word : words) {
			// swap using StringBuilder
			/*
			StringBuilder sb = new StringBuilder();
			for (char c : word.toCharArray()) {
				sb.insert(0, c);
			}
			answer.append(sb);
			*/
			// swap using two pointer
			char[] cArr = word.toCharArray();
			int startIdx = 0;
			int endIdx = cArr.length - 1;
			while (startIdx < endIdx) {
				// swap
				char temp = cArr[startIdx];
				cArr[startIdx] = cArr[endIdx];
				cArr[endIdx] = temp;
				// move pointer
				startIdx++;
				endIdx--;
			}
			answer.append(new String(cArr));
			answer.append(" ");
		}

		return answer.deleteCharAt(answer.length() - 1).toString();
	}

	public static void main(String[] args) {
		Solution557 solution557 = new Solution557();
		String answer;

		answer = solution557.reverseWords("Let's take LeetCode contest");
		answer = solution557.reverseWords("God Ding");

		return;
	}
}
