import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    /**
     * 3:05 -
     * [규칙]
     * 한 단계 혹은 두 단계씩 오를 수 있음
     * 연속된 세 단계 모두 밟아선 안 됨
     * 마지막 도착 계단은 반드시 밝아야함
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //계단의 수 (300이하)
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(br.readLine());

        dp[1] = arr[1];
        if (n>=2) {
            dp[2] = arr[1] + arr[2];
            for(int i=3; i<=n; i++){
                dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
            }
        }


        System.out.println(dp[n]);

    }
}