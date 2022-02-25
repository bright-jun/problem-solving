package exercise.leetcode;

public class Solution165 {
	public int compareVersion(String version1, String version2) {
		String[] revision1StrList = version1.split("\\.");
		String[] revision2StrList = version2.split("\\.");

		int revisionLength = Integer.max(revision1StrList.length, revision2StrList.length);

		int[] revision1List = new int[revisionLength];
		int[] revision2List = new int[revisionLength];
		for (int i = 0; i < revisionLength; i++) {
			try {
				revision1List[i] = Integer.parseInt(revision1StrList[i]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				revision2List[i] = Integer.parseInt(revision2StrList[i]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 0; i < revisionLength; i++) {
			if (revision1List[i] < revision2List[i]) {
				return -1;
			} else if (revision1List[i] > revision2List[i]) {
				return 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		Solution165 solution165 = new Solution165();
		System.out.println(solution165.compareVersion("1.01", "1.001"));
		System.out.println(solution165.compareVersion("1.0", "1.0.0"));
		System.out.println(solution165.compareVersion("0.1", "1.1"));
	}
}
