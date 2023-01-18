package exercise.leetcode;

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
		  * -> 7 or count(6)
		  *              
  		  * 00010100000101010
		  * 00090800000302010
		  *                                           
		  * -> represent as array: [9,8,3,2,1]
		  * -> 9 or count(5)
		  *    -> 9 flip + 8 or count(4)
		  *       -> 9,8 flip + 3 or count(3) .. same
		  */
		return -1;
	}

	public static void main(String[] args) {
		Solution926 solution926 = new Solution926();
		int answer;
		answer = solution926.minFlipsMonoIncr("00110"); // 1
		answer = solution926.minFlipsMonoIncr("010110"); // 2
		answer = solution926.minFlipsMonoIncr("00011000"); // 2
		answer = solution926.minFlipsMonoIncr("10000000"); // 1
		answer = solution926.minFlipsMonoIncr("00010100000101010"); // 5
		answer = solution926.minFlipsMonoIncr("000101010101010"); // 6
		answer = solution926.minFlipsMonoIncr("0001010101010100"); // 6
	}
}
