import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //N(1 ≤ N ≤ 90) 정수가 90자리 넘어가면 int 로 불가 -> long
        //dp (왜냐면 dp[1] dp[2]가 정해져있음
        long[] dp = new long[N+1]; //n자리 이친 수의 총 개수

        dp[0] = 0;
        dp[1] = 1;

        // dp[n] n자리 수 끝에 0이 오는 경우 + 1이 오는 경우를 더하면 된다.
        // n 자리에 0과 1 두 가지만 올 수 있다.
        // n 자리에 0이 들어 오면, 앞에 0과 1 둘 다 들어올 수 있다.
        // n 자리에 1이 들어 오면, 앞에 0만 들어올 수 있다.

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}