package exercise.leetcode;

import java.util.Arrays;

public class Solution1675 {
	public int getDeviation(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length-1] - nums[0];
	}
	
	public boolean isSameList(int[] l1, int[] l2) {
		Arrays.sort(l1);
		Arrays.sort(l2);
		
		for (int i = 0; i < l2.length; i++) {
			if(l1[i] != l2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public int minimumDeviation(int[] nums) {
		// abs ( odds - 2^k (0<=k<=20) )
		// deviation = max - min
		// minimize deviation = max↓, min↑
		
		while(true) {
			int nowDev = getDeviation(nums);
			int aftMinDev = -1;
			int aftMaxDev = -1;
			int aftMinMaxDev = -1;
			
			int[] minNums = new int[nums.length];
			int[] maxNums = new int[nums.length];
			int[] minMaxNums = new int[nums.length];
			
			// operation min
			for (int i = 0; i < minNums.length; i++) {
				minNums[i] = nums[i];
			}
			if(nums[0] % 2 == 0) {
				minNums[0]/=2;
				aftMinDev = getDeviation(minNums);
			} else {
				minNums[0]*=2;
				aftMinDev = getDeviation(minNums);
			}
			
			// operation max
			for (int i = 0; i < maxNums.length; i++) {
				maxNums[i] = nums[i];
			}
			if(nums[nums.length-1] % 2 == 0) {
				maxNums[nums.length-1]/=2;
				aftMaxDev = getDeviation(maxNums);
			} else {
				maxNums[nums.length-1]*=2;
				aftMaxDev = getDeviation(maxNums);
			}
			
			// operation min, max
			for (int i = 0; i < minMaxNums.length; i++) {
				minMaxNums[i] = nums[i];
			}
			if(nums[0] % 2 == 0) {
				minMaxNums[0]/=2;
				aftMinMaxDev = getDeviation(minMaxNums);
			} else {
				minMaxNums[0]*=2;
				aftMinMaxDev = getDeviation(minMaxNums);
			}
			if(nums[nums.length-1] % 2 == 0) {
				minMaxNums[nums.length-1]/=2;
				aftMinMaxDev = getDeviation(minMaxNums);
			} else {
				minMaxNums[nums.length-1]*=2;
				aftMinMaxDev = getDeviation(minMaxNums);
			}
			
			int[] devList = new int[] { nowDev, aftMinDev, aftMaxDev, aftMinMaxDev };
			Arrays.sort(devList);
			int Ans = Integer.MAX_VALUE;
			if(nowDev == devList[0]) { // 최소 dev가 여러개인 경우가 있음
				// 지금이 제일 최소값
				Ans = nowDev;
				// 이 경우가 유일할 때 return
				if(nowDev != devList[1] && nowDev != devList[2] && nowDev != devList[3]) {
					return Ans;
				} else {
					// 유일하지 않다면?
					// 모든 가능성 탐색 후에 최소값 리턴하기
					// 가능성의 끝이 회귀인 경우
				}
			}
			if (aftMinDev == devList[0]){
				// 이 경우에서도 최소값 찾아오기
				// 다른 리스트의 경우에, 같을땐 회귀방지
				if (!isSameList(nums, minNums)) {
					Ans = Math.min(Ans, minimumDeviation(minNums));
				}
			}
			if (aftMaxDev == devList[0]){
				// 이 경우에서도 최소값 찾아오기
				// 다른 리스트의 경우에, 같을땐 회귀방지
				if (!isSameList(nums, maxNums)) {
					Ans = Math.min(Ans, minimumDeviation(maxNums));
				}
			}
			if (aftMinMaxDev == devList[0]){
				// 이 경우에서도 최소값 찾아오기
				// 다른 리스트의 경우에, 같을땐 회귀방지
				if (!isSameList(nums, minMaxNums)) {
					Ans = Math.min(Ans, minimumDeviation(minMaxNums));
				}
			}
			return Ans;
		}
	}

	public static void main(String[] args) {
		Solution1675 solution1675 = new Solution1675();
		/*
		System.out.println(solution1675.minimumDeviation(new int[] {1,2,3,4}));
		System.out.println(solution1675.minimumDeviation(new int[] {4,1,5,20,3})); // {1,1,5,5,3} -> {1,3,5} -> {3,4,5}
		System.out.println(solution1675.minimumDeviation(new int[] {2,10,8})); // {1,5,1}
		System.out.println(solution1675.minimumDeviation(new int[] {3,5}));
		System.out.println(solution1675.minimumDeviation(new int[] {2,8,6,1,6})); // {2,2,3,2,3} // 최선의 경우가 여러개인 경우 더이상 탐색안함.
		*/
		System.out.println(solution1675.minimumDeviation(new int[] {10,4,3})); // SOF // {5,4,6} // 최선의 경우가 여러개인 경우 더이상 탐색안함.
	
		// {513, 777, 1024} : 1024 - 513 = 511
		// {1026, 777, 1024} -> {777, 1024, 1026} : 1026 - 777 = 249
		// {513, 777, 512} -> {512, 513, 777} : 777-512 = 265
		
		// {777, 1024, 1026} : 1026 - 777 = 249
		// {1554, 1024, 1026} -> {1024, 1026, 1554} : 1554 - 1024 = 530 
		// {777, 1024, 513} -> {513, 777, 1024} : 1024 - 513 = 511
		
		// n * n * log(n); TLE
		
		// 2^n, odd, odd*2^n
	}
}

