package exercise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1268 {
	/*
	 * 1 <= products.length <= 1000
	 * 1 <= products[i].length <= 3000
	 * 1 <= sum(products[i].length) <= 2 * 104
	 * All the strings of products are unique.
	 * products[i] consists of lowercase English letters.
	 * 1 <= searchWord.length <= 1000
	 * searchWord consists of lowercase English letters.
	 */
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> ans;
		ans = new ArrayList<List<String>>();
		Arrays.sort(products);
		
		
		
		return null;
	}

	public static void main(String[] args) {
		Solution1268 solution1268 = new Solution1268();
		List<List<String>> ans;
		ans = solution1268.suggestedProducts(new String [] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
		ans = solution1268.suggestedProducts(new String [] {"havana"}, "havana");
		ans = solution1268.suggestedProducts(new String [] {"bags","baggage","banner","box","cloths"}, "bags");
	}
}
