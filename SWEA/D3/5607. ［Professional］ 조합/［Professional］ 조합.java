import java.util.Scanner;

public class Solution {
    static final int MOD = 1_234_567_891;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            long n = sc.nextLong();
            long r = sc.nextLong();

            sb.append("#").append(tc).append(" ").append(combination(n, r)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    // 조합을 계산하는 함수, 모듈로 연산 적용
    public static long combination(long n, long r) {
        if (r == 0) return 1;

        long numerator = factorial(n); // 분자 n!
        long denominator = (factorial(r) * factorial(n - r)) % MOD; // 분모 r!(n-r)!

        // 분자에 분모의 모듈로 역원을 곱함
        return (numerator * modInverse(denominator, MOD)) % MOD;
    }

    // 모듈로 연산에서의 역원을 계산하는 함수 (페르마의 소정리 활용)
    public static long modInverse(long a, int p) {
        return power(a, p - 2);
    }

    private static long factorial(long N) {
        long result = 1L;
        for (int i = 2; i <= N; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }

    //거듭제곱을 계산하는 함수, 모듈로 연산 적용
    //a : 밑,   p = 지수 (exponent)
    public static long power(long a, long p) {
        long result = 1;
        a = a % MOD;

        while (p > 0) {
            // 지수가 홀 수면 반환하고자 하는 result에 곱해주도록 한다.
            // 지수가 모두 짝수라면 expo가 1이 될 떄까지 base의 값이 제곱되다가 최종적으로 result에 담긴다.
            if (p % 2 == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            p = p >> 1;
        }
        return result;
    }
}