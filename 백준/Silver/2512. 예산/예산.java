import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, budget;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        budget = Integer.parseInt(br.readLine());

        if(sum <= budget) {
            System.out.println(max);
        } else {
            System.out.println(binarySearch(0, max, 0));
        }
    }
    public static long binarySearch(int min, int max, long result) {
        if(min > max) {
            return result;
        }
        int mid = (min + max)/2;
        long sum = 0;
        for(int i = 0; i <N; i++) {
            if(arr[i] > mid) sum += mid;
            else sum += arr[i];
        }

        // 상한액을 만족하면, 그 값을 result로 저장하고 상한값을 더 높여본다.
        if(sum <= budget) return binarySearch(mid + 1, max, mid);
        // 예산을 초과하면, 상한값을 낮춘다.
        else return binarySearch(min, mid - 1, result);
    }
}