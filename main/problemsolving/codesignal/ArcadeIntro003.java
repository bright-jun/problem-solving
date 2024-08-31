package problemsolving.codesignal;

public class ArcadeIntro003 {

    boolean solution(String inputString) {
        for (int i = 0; i < inputString.length() / 2; i++) {
            char f = inputString.charAt(i);
            char e = inputString.charAt(inputString.length() - 1 - i);

            if (f != e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArcadeIntro003 arcadeIntro003 = new ArcadeIntro003();
        System.out.println(arcadeIntro003.solution("A"));
        System.out.println(arcadeIntro003.solution("ABC"));
        System.out.println(arcadeIntro003.solution("ABCBA"));
    }
}
