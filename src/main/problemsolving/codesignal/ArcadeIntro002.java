package problemsolving.codesignal;

public class ArcadeIntro002 {

    int solution(int year) {
        return (int) Math.ceil((double) year / 100);
    }

    public static void main(String[] args) {
        ArcadeIntro002 arcadeIntro002 = new ArcadeIntro002();
        System.out.println(arcadeIntro002.solution(1700));
        System.out.println(arcadeIntro002.solution(1701));
    }
}
