package problemsolving.leetcode;

import java.util.Stack;

public class Solution71 {
	public String simplifyPath(String path) {
		
		// rule1
		if (path.charAt(path.length() - 1) == '/') {
			path = path.substring(0, path.length() - 1);
		}

		// rule3
		path = path.replaceAll("////", "/");

		// rule2
		String[] splitPaths = path.split("/");

		Stack<String> al = new Stack<String>();
		
		for (String splitPath : splitPaths) {
			if (splitPath.isEmpty()) {
				continue;
			} else if (splitPath.equals("..")) {
				if(!al.isEmpty()) {
					al.pop();
				}
			} else if (splitPath.equals(".")) {
				continue;
			} else {
				al.add(splitPath);
			}
		}
		
		String answer = "";
		for (String splitPath : al) {
			answer += "/" + splitPath;
		}
		
		return answer.isEmpty() ? "/" : answer;
	}

	public static void main(String[] args) {
		Solution71 solution71 = new Solution71();
		System.out.println(solution71.simplifyPath("/home/"));
		System.out.println(solution71.simplifyPath("/../"));
		System.out.println(solution71.simplifyPath("/home//foo/"));
		System.out.println(solution71.simplifyPath("/asdf/home/../foo/"));
		System.out.println(solution71.simplifyPath("/../home/../////foo/"));
		System.out.println(solution71.simplifyPath("///////"));
		System.out.println(solution71.simplifyPath("/a/../../b/../c//.//")); // "/c" // "..", "." treating
		System.out.println(solution71.simplifyPath("/a//b////c/d//././/..")); // "/a/b/c" // // .. -> upper file, . -> now file
	}
}
