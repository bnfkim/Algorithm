import java.io.IOException;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 해결방법
         * - 현재 날짜에서 상담일을 더했을 때 범위를 초과하지 않는 경우 금액을 더해준다
         * - dp[i] = max(dp[i + t[i]], dp[i + t[i]] + p[i])
         * - dp[i+1] = Math.max(dp[i] + dp[i+1])
         *
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];
        for(int i=0; i<n; i++){
            t[i] = sc.nextInt();;
            p[i] = sc.nextInt();
        }
        //dp : n일에 얻을 수 있는 최대 수익
        int[] dp = new int[n+1];

        //점화식
        //현재 날짜에서 소요 시간과 비용을 더해 dp에 저장
        //중복될 때는 최대값을 넣음
        for(int i=0; i<n; i++){
            int next = i + t[i];
            if(next <= n) {//날짜의 범위가 벗어나지 않는 선
                //지금까지 계산한 값 vs 지금 해야할 계산 -> 둘 중 큰 값 dp에 저장
                dp[next] = Math.max(dp[next], dp[i]+ p[i]);
            }
            //현재 경우의 수가 0일 수 있기 때문에 이전의 최대값을 넣어줌
            //해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어줌
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
//        System.out.print("t  : ");
//        for(int i : t) System.out.print(i + "  ");
//        System.out.print("\np  : ");
//        for (int i : p) System.out.print(i + " ");
//        System.out.print("\ndp : ");
//        for (int i : dp) System.out.print(i + " ");
        System.out.println(dp[n]);
    }
}