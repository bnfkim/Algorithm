import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] dp = new int[11];
    public static void main(String[] args) throws IOException {

        /**
         *  입력)
         *  첫째 줄 ->  테스트 케이스의 개수 T가 주어진다.
         *  둘째 줄 ->  정수 n이 주어진다. n은 양수이며 11보다 작다.
         *  출력)
         *  각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        //초기 값 초기화
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int j=0; j<T; j++){
            int n = Integer.parseInt(br.readLine());
            for(int i=4; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
    }
}