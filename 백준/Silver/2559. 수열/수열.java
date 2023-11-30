import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //온도를 측정한 전체 날짜 수
        int K = Integer.parseInt(st.nextToken()); //연속 적 날짜
        int[] days = new int[N];
        
        String[] arr = br.readLine().split(" ");
        for(int i=0; i< arr.length; i++) days[i] = Integer.parseInt(arr[i]);

        System.out.println(maxTemperatures(days, N, K));
    }
    public static int maxTemperatures(int[] days, int N, int K) {
        int result = Integer.MIN_VALUE;

        for(int i=0; i<=N-K; i++) {
            int sum = 0;
            for(int j=i; j<i+K; j++) {
                sum += days[j];
            }
            result = Math.max(sum, result);
        }
        return result;
    }
}