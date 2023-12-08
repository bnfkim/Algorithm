import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

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

        dfs(0);

    }
    public static void dfs(int dep) {
        if(dep == m) {
            for(int r : results) {
                System.out.print(r + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++) {

            if(visit[i]) continue;

            visit[i] = true;
            results[dep] = i;
            dfs(dep+1);
            visit[i] = false;
        }
    }
}