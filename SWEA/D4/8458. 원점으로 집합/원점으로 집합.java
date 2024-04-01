import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            long max = 0;
            boolean isEven = false, isOdd = false;
            for(int i = 0; i < N; i++) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                long d = getDistance(x, y);

                max = Math.max(max, d);
                if(d % 2 == 0) isEven = true; else isOdd = true;
            }

            long result = 0;
            if(isEven && isOdd) result = -1; //홀수거나 짝수이면 안 됨
            else {
                long move = 0;
                long i;
                for(i = 1; i < 1_000_000_000; i++) {

                    //짝수 - 짝수 = 짝수 / 홀수 - 홀수 = 홀수
                    if(move >= max && Math.abs(move - max) % 2 == 0) break;
                    move += i;
                    result++;
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static long getDistance(long x, long y) {
        return Math.abs(x) + Math.abs(y);
    }
}