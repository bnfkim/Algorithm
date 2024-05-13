import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dc = {0, -1, 0, 1};
    static int[] dr = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void bfs() {
        visit = new boolean[R][C][2];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, 1}); //// x, y, 벽을 부쉈는지 여부, 이동 거리
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            //목적지에 도달한 경우
            if(cur[0] == C - 1 && cur[1] == R - 1) {
                result = cur[3];
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nc = cur[0] + dc[i];
                int nr = cur[1] + dr[i];

                //범위를 벗어나는 경우
                if(nc < 0 || nc >= C || nr < 0 || nr >= R) continue;
                //갈 수 있는 곳일 경우
                if(map[nr][nc] == 0 && !visit[nr][nc][cur[2]]) {
                    queue.add(new int[]{nc, nr, cur[2], cur[3] + 1});
                    visit[nr][nc][cur[2]] = true;
                    continue;
                }
                //벽이라, 한번 부수고 가는 경우
                if(map[nr][nc] == 1 && cur[2] == 0) {
                    queue.add(new int[]{nc, nr, 1, cur[3] + 1});
                    visit[nr][nc][1] = true;
                }
            }
        }
    }
}