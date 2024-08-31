package algorithm.modular;

public class Modular {

    public static int MOD_INT = (int) (1e9 + 7);
    public static long MOD_LONG = (long) (1e9 + 7);

    // 12345 % MOD =
    // ((((((1 * 10) + 2) * 10 + 3) * 10) + 4) * 10 + 5) % MOD
    public int modBigNumInt(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer = (answer * 10 + (s.charAt(i) - '0')) % MOD_INT;
        }
        return answer;
    }

    public long modBigNumLong(String s) {
        long answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer = (answer * 10 + (s.charAt(i) - '0')) % MOD_LONG;
        }
        return answer;
    }

    public static void main(String[] args) {
        Modular modular = new Modular();
        System.out.println(modular.modBigNumInt("12345678"));
        System.out.println(modular.modBigNumInt("1000000007"));
        System.out.println(modular.modBigNumInt("1000000008"));
        System.out.println(modular.modBigNumInt("1234567890"));
        // int로 할 시 -617207124 int 범위 넘어감
        System.out.println(modular.modBigNumInt("1234567890123456789456132165"));
        System.out.println(modular.modBigNumLong("1234567890123456789456132165"));
    }
}
