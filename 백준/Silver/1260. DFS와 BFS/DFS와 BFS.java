import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int n, m, v;
    public static int[][] map;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //정점의 개수
        m = Integer.parseInt(st.nextToken()); //간선의 개수
        v = Integer.parseInt(st.nextToken()); //시작할 정점의 번호

        map = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }
        dfs(v);
        bfs();

        System.out.println(sb.toString());
    }

    public static void dfs(int now) {
        sb.append(now).append(" ");
        visit[now] = true;

        for(int i=1; i<=n; i++) {
            if(map[now][i] == 0) continue; //연결이 안 되어있으면 패스
            if(visit[i]) continue; //방문했으면 패스

            visit[i] = true;
            dfs(i);
        }
    }

    public static void bfs() {
        sb.append("\n");
        visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");

            for(int i=1; i<=n; i++) {
                if(map[now][i] == 0) continue; //연결이 안 되어있으면 패스
                if(visit[i]) continue; //방문했으면 패스

                queue.add(i);
                visit[i] = true;
            }
        }
    }
}