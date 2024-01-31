import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            boolean[][] visit = new boolean[N][N];

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            int d = 0;
            int y = 0;
            int x = 0;
            int num = 1;

            while(num <= N*N) {
                visit[y][x] = true;
                map[y][x] = num;
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(nx<0 || ny<0 || nx>=N || ny>=N || visit[ny][nx]) {
                    d = (d + 1) % 4;
                    ny = y + dy[d];
                    nx = x + dx[d];
                }
                y = ny;
                x = nx;
                num++;
            }

            sb.append("#").append(tc).append("\n");
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++){
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}