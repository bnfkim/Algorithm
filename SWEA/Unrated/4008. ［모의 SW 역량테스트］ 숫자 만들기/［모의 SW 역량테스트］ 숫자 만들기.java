import java.util.*;
import java.io.*;

public class Solution {

    static int N, max, min;
    static int[] numbers, operators;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            input();
            dfs(numbers[0], 1);
            sb.append("#").append(tc).append(" ").append(max - min).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static void input() throws IOException {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        N = Integer.parseInt(br.readLine());
        operators = new int[4];
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) operators[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
    }

    //연산자 중복순열 메소드
    static void dfs(int ans, int cnt) {
        if(cnt == N) { //모든 숫자를 사용했을 경우
            max = Math.max(ans, max);
            min = Math.min(ans, min);
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                operators[i]--; //연산자 사용

                switch (i) {
                    case 0: dfs(ans + numbers[cnt], cnt + 1); break;
                    case 1: dfs(ans - numbers[cnt], cnt + 1); break;
                    case 2: dfs(ans * numbers[cnt], cnt + 1); break;
                    case 3: dfs(ans / numbers[cnt], cnt + 1); break;
                }

                operators[i]++; //연산자 복원
            }
        }
    }
}