import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            dp = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(dp, 1);
            
            for(int i = 1; i < N; i++) {
                for(int j = 0; j < i; j++) {
                    if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            int result = 0;
            for(int i = 0; i < N; i++) {
                result = Math.max(result, dp[i]);
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}