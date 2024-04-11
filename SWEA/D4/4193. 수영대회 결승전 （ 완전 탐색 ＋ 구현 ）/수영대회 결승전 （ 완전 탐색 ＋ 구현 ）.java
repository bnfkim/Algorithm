import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static int N, result;
    static int[][] map;
    static boolean[][] visit;
    static int ex, ey;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0 , 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ey = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());

            sb.append("#").append(tc).append(" ").append(bfs(sy, sx)).append("\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int sy, int sx) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{sy, sx, 0});
        visit[sy][sx] = true;

        while(!deque.isEmpty()) {
            int[] cur = deque.poll();
            int y = cur[0];
            int x = cur[1];
            int t = cur[2];

            if(x == ex && y == ey) {
                return t;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if(map[ny][nx] == 1 || visit[ny][nx]) continue;

                if(map[ny][nx] == 2) {
                    if((t-2) % 3 == 0) {
                        deque.add(new int[]{ny, nx, t + 1});
                    } else {
                        deque.add(new int[]{y, x, t + 1});
                    }
                } else {
                    deque.add(new int[]{ny, nx, t + 1});
                    visit[ny][nx] = true;
                }


            }
        }
        return -1;
    }
}