import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[1] = 1;

        for(int i=2; i<=N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j]+1;
                } else if (arr[i] == arr[j]) {
                    dp[i] = dp[j];
                }
            }
        }
        //전체 dp[] 값을 조사해서 제일 큰 값을 출력
        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}