import java.io.*;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[] results;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        results = new int[m];
        visit = new boolean[n+1];

        dfs(1, 0);
    }
    public static void dfs(int start, int dep) {
        //k번째 노드에 도달하면 결과에 추가
        if(dep == m) {
            printResult();
            return;
        }

        //현재 엘리먼트 이후 엘리먼트 탐색
        for(int i=start; i<=n; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            results[dep] = i;
            dfs(i+1, dep+1);
            visit[i] = false;
        }
    }
    public static void printResult() {
        for(int r : results) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}