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
		  * -> represent as array: [2,1]                                            
		  * 00011000                                                                
		  * -> 00033000 -> 3 means if you change string to 1, you need to flip 3    
		  *             -> if not, you flip one and count to next.                  
		  *             -> ...                                                      
		  * -> represent as array: [3,3]                                            
		  * 10000000                                                                
		  * -> 70000000 -> 7 means if you change string to 1, you need to flip 7    
		  *             -> if not, ...                                            
		  * -> represent as array: [7]                                              
		  * 10000100                                                                
		  * -> 60000200 -> 6 means if you change string to 1, you need to flip 6    
		  *             -> if not, you flip one and go to next                      
		  *                -> 2 means if you change string to 1, you need to flip 2
		  *                -> ... 
		  * -> represent as array: [6,2]                                            
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
	}
}
