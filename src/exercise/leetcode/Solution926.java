package exercise.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution926 {
	/*
	 * 1 <= s.length <= 10^5
	 * s[i] is either '0' or '1'.
	 */
	public int minFlipsMonoIncr(String s) {
		/*
		 * if s.length = 4
		 * check 4 cases O(N^2)
		 * 0000
		 * 0001
		 * 0011
		 * 0111
		 * 1111
		 */

		 /*
		  * 00110                                                                   
		  * -> 00110                                                                
		  * 010110                                                                  
		  * -> 020110 -> 2 means if you change string to 1, you need to flip 2
		  *    0112--
		  *    01123-
		  *    011233
		  *    02----      
		  * -> represent as array: [2,1,1]                                            
		  * 00011000                                                                
		  * -> 00033000 -> 3 means if you change string to 1, you need to flip 3    
		  *    00012222         -> if not, you flip one and count to next.                  
		  *    00014---
		  *    0003----         -> ...                                                      
		  * -> represent as array: [3,3]                                            
		  * 10000000                                                                
		  * -> 70000000 -> 7 means if you change string to 1, you need to flip 7
		  *    11111111
		  *    7-------    
		  *             -> if not, ...                                            
		  * -> represent as array: [7]                                              
		  * 10000100                                                                
		  * -> 60000200 -> 6 means if you change string to 1, you need to flip 6
		  *    11111222
		  *    111113--    
		  *    6-------
		  *             -> if not, you flip one and go to next                      
		  *                -> 2 means if you change string to 1, you need to flip 2
		  *                -> ... 
		  * -> represent as array: [6,2]
		  * -> 6 or count(2), 1 + count(1)
		  * 
		  * 000101010101010
		  * 000605040302010
		  *                                           
		  * -> represent as array: [6,5,4,3,2,1]
		  * -> 6 or count(6) .. same
		  * 
		  * 0001010101010100
		  * 0007060504030200
		  *                                           
		  * -> represent as array: [7,6,5,4,3,2]
		  * -> 7 or count(6) -> 6
		  *              
  		  * 00010100000101010
		  * 00090800000302010
		  *                                           
		  * -> represent as array: [9,8,3,2,1]
		  * -> 9 or count(5) -> 5
		  * 
		  * 000101010101011110
		  * 000605040302011110
		  * 
		  * -> represent as array: [6,5,4,3,2,1,1,1,1]
		  * -> 6 or count(9) -> 6
		  * 
		  * 10011111110010111011
		  * 60044444440020111000
		  * 
		  * -> represent as array: [5,4,4,4,4,4,4,4,2,1,1,1]
		  * -> 6 or count(12)
		  * -> 6 can be flipped
		  *    -> 6 flip + count(11) || 6,4 flip + count(10)
		  */
		Deque<Integer> representList = new LinkedList<Integer>();
		char[] charArray = s.toCharArray();
		int zeroCount = 0;
		for (int i = charArray.length - 1; i >= 0; i--) {
			if (charArray[i] == '0') {
				zeroCount++;
			} else {
				if (zeroCount > 0) {
					representList.addFirst(zeroCount);
				}
			}
		}
		
		int size = representList.size();
		if (size == 0) {
			return 0;
		}
		// all 1 vs all 0 
		int answer = Math.min(representList.pollFirst(), size);
		for (int i = 0; i < size - 1 ; i++) {
			// make 1 rest vs flip and make 1 rest 
			answer = Math.min(answer, (i + 1) + representList.pollFirst());
		}

		return answer;
	}

	/*
	 * Time: O(2*N)
	 * Space: O(1)
	 */
	public int minFlipsMonoIncrSol1(String s) {
		int zeroCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				zeroCount++;
			}
		}
		// 0 * 0 + 1 * n
		int answer = zeroCount;
		for (int i = 0; i < s.length(); i++) {
			// 0 * (i+1) + 1 * (n - (i+1))
			if (s.charAt(i) == '0') {
				// flip count --
				// (stay) 0 -> 0
				zeroCount--;
				answer = Math.min(answer, zeroCount);
			} else {
				// flip count ++
				// (flip) 1 -> 0
				zeroCount++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution926 solution926 = new Solution926();
		int answer;
		answer = solution926.minFlipsMonoIncrSol1("00110"); // 1
		answer = solution926.minFlipsMonoIncrSol1("010110"); // 2
		answer = solution926.minFlipsMonoIncrSol1("00011000"); // 2
		answer = solution926.minFlipsMonoIncrSol1("10000000"); // 1
		answer = solution926.minFlipsMonoIncrSol1("00010100000101010"); // 5
		answer = solution926.minFlipsMonoIncrSol1("000101010101010"); // 6
		answer = solution926.minFlipsMonoIncrSol1("0001010101010100"); // 6
		answer = solution926.minFlipsMonoIncrSol1("0101100011"); // 3
		answer = solution926.minFlipsMonoIncrSol1("10011111110010111011"); // 5
		// TLE
		// LinkedList -> Deque
	}
}
