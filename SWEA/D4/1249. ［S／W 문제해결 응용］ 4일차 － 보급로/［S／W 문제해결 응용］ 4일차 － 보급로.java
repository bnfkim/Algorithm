import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map,sumTime;
    static boolean[][] visit;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            input();
            findMinTime();
            
            sb.append("#").append(tc).append(" ").append(sumTime[N-1][N-1]).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static void findMinTime() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        sumTime[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            //print();

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(sumTime[nr][nc] <= sumTime[r][c] + map[nr][nc]) continue;

                queue.add(new int[]{nr, nc});
                sumTime[nr][nc] = sumTime[r][c] + map[nr][nc];
            }
        }
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sumTime = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
                sumTime[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}