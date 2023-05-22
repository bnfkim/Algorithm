import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[1] = 1;
        for (int i=2; i<=n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] < arr[j] && dp[i] <= dp[j]) dp[i] = dp[j] + 1;
                else if (arr[i] == arr[j]) dp[i] = dp[j];
            }
        }
//        for(int a : arr) System.out.print(a + " ");
//        System.out.println();
//        for(int d : dp) System.out.print(d + "  ");
//        System.out.println();

        int max = 0;
        for(int d : dp) max = Math.max(d, max);
        System.out.println(max);
    }
}