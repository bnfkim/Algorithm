import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] dp = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < N; i++) {
      dp[i] = arr[i];
    }

    int sum = dp[0];
    for(int i = 1; i < N; i++) {
      for(int j = 0; j < i; j++) {
        //최장 증가수열을 판단하는 코드
        if(arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i]);
        }
      }
      sum = Math.max(sum, dp[i]);
    }
    System.out.println(sum);
  }
}