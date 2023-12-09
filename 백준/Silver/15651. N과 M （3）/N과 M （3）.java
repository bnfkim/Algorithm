import java.io.*;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[] results;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        results = new int[m];

        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int dep) {
        if(dep == m) {
            printResult();
            return;
        }

        for(int i=1; i<=n; i++) {
            results[dep] = i;
            dfs(dep+1);
        }
    }
    public static void printResult() {
        for(int r : results) {
            sb.append(r).append(" ");
        }
        sb.append("\n");
    }
}