package exercise.codesignal;

public class FirstDuplicate {
	int solution(int[] a) {
	    boolean[] b = new boolean[a.length + 1];
	    for(int i : a) {
	        if(!b[i]){
	            b[i] = true;
	        } else{
	            return i;
	        }
	    }
	    return -1;
	}
	
	public static void main(String[] args) {
		FirstDuplicate firstDuplicate = new FirstDuplicate();
//		a = [2, 1, 3, 5, 3, 2], the output should be solution(a) = 3.
		System.out.println(firstDuplicate.solution(new int [] {2, 1, 3, 5, 3, 2}));
//		a = [2, 2], the output should be solution(a) = 2;
		System.out.println(firstDuplicate.solution(new int [] {2, 2}));
//		a = [2, 4, 3, 5, 1], the output should be solution(a) = -1.
		System.out.println(firstDuplicate.solution(new int [] {2, 4, 3, 5, 1}));
	}
}
