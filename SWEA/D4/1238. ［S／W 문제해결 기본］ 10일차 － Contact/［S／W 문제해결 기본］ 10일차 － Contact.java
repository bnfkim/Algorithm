import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {

    static int n,m, max;
    static boolean[] visit;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc=1; tc<=10; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //입력받는 데이터의 길이
            m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[101];
            visit = new boolean[101];
            for(int i=1; i<=100; i++) graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
            }

            bfs();
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void bfs() {
        int cnt = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{m, 0});
        visit[m] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[1] > cnt)  {
                cnt++;
                max = 0;
            }

            if(now[1] == cnt) {
                max = Math.max(max, now[0]);
            }

            for(int next : graph[now[0]]) {
                if(visit[next]) continue;

                visit[next] = true;
                queue.add(new int[]{next, now[1] + 1});
            }
        }
    }
}