import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, RESULT;
    static int[] SNACK;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            SNACK = new int[N];
            RESULT = -1;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                SNACK[i] = Integer.parseInt(st.nextToken());
            }
            combination(0,0,0);

            sb.append("#").append(tc).append(" ").append(RESULT).append("\n");
        }
        System.out.println(sb);
    }

    static void combination(int dep, int start, int sum) {
        if(sum > M) {
            //2_000_000
            return;
        }

        if(dep == 2) { //정확히 두개 사야함
            RESULT = Math.max(sum, RESULT);
            return;
        }

        for (int i=start; i<N; i++) {
            combination(dep+1, i+1, sum + SNACK[i]);
        }
    }
}