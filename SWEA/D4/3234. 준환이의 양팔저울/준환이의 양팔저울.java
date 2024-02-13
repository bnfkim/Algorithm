import java.util.*;
import java.io.*;

public class Solution {

    static int T, N, ans;
    static int[] weight;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            weight = new int[N];
            ans = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(weight);

            do{
                dfs(weight[0], 0, 1);
            } while(nextPermutation(weight));

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean nextPermutation(int[] weight) {
        int i = N-1;
        while(i > 0 && weight[i-1] >= weight[i]) i--;
        if(i == 0) return false;

        int j = N-1;
        while(weight[i-1] >= weight[j]) j--;

        swap(weight, i-1, j);

        int k = N-1;
        while(i < k) swap(weight, i++, k--);

        return true;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void dfs(int left, int right, int idx) {
        if(left < right) return;
        if(idx == N) {
            ans++;
            return;
        }

        dfs(left, right + weight[idx], idx+1);
        dfs(left + weight[idx], right, idx+1);
    }
}