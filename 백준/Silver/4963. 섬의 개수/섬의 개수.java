import java.io.*;
import java.util.*;

public class Main {
    public static int w, h;
    public static int[][] map;
    public static boolean[][] visit;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;

            System.out.println(solution());
        }
    }
    public static int solution() throws IOException {
        //지도 만들기
        map = new int[h][w];
        visit = new boolean[h][w];
        for(int i=0; i<h; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visit[y][x] = true;

        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            for(int i=0; i<8; i++) {
                int ny = position[0] + dy[i];
                int nx = position[1] + dx[i];

                if(ny<0 || nx<0 || ny>=h || nx>=w) continue;
                if(visit[ny][nx] || map[ny][nx] == 0) continue;

                queue.add(new int[]{ny,nx});
                visit[ny][nx] = true;
            }
        }
    }
}