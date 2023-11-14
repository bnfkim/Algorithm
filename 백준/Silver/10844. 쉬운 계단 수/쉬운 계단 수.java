import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long mod = 1_000_000_000;
        //dp[i][j] -> i(자릿수), j(자릿값)
        long[][] dp = new long[N+1][10];
        //첫째 자리수는 경우의 수가 하나 뿐
        for(int i=1; i<10; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            //현재 자릿값을 0부터 9까지 탐색
            for(int j=0; j<10; j++) {
                if(j == 9) {
                    dp[i][j] = dp[i-1][8] % mod;
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][1] % mod;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        long ans = 0;
        for(int i=0; i<10; i++) {
            ans += dp[N][i];
        }
        System.out.println(ans % mod);
    }
}