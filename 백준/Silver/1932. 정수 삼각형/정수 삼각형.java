import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //삼각형 크기
        int[][] tan = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++) {
                tan[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = tan[1][1];
        for(int i=2; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1]+tan[i][j] , dp[i-1][j]+tan[i][j] );
            }
        }
        //print(dp);

        int result = 0;
        for(int i=1; i<=n; i++) {
            result = Math.max(dp[n][i], result);
        }

        System.out.println(result);

    }
    public static void print(int[][] arr) {
        for(int i=1; i<arr.length; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}