import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer = -1;
    static char[][] map;
    static boolean[][][] visit;
    static int[] start;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        map = new char[N][M];
        visit = new boolean[N][M][1 << 6];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0') start = new int[]{i, j, 0, 0};
            }
        }
        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(start); //현재 위치(y,x), 거리, 열쇠의 유무(비트 마스크)
        visit[start[0]][start[1]][0] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            int d = now[2]; //움직인 거리
            int m = now[3]; //키를 보유하고 있는 비트마스크

            //도착했을 때 확인
            if(map[y][x] == '1') {
                answer = d;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(outOfRange(nx, ny)) continue;    //위치 날 경우 > 못감
                if(map[ny][nx] == '#') continue;    //벽일 경우 > 못감
                if(visit[ny][nx][m]) continue;   //이미 방문한 경우 > 못감
                if(isDoor(nx, ny) && !haveKey(m, map[ny][nx])) continue; // 문인 경우 > 키 여부 확인 > 안 갖고 있으면 못 지나감

                if(isKey(nx, ny)) {  // 키인 경우 > 해당 키 값으로 없데이트
                    int nm = m | 1 << map[ny][nx] - 'a';
                    visit[ny][nx][nm] = true;
                    queue.add(new int[]{ny, nx, d + 1, nm});
                } else { //키가 아닌 경우
                    visit[ny][nx][m] = true;
                    queue.add(new int[]{ny, nx, d + 1, m});
                }
            }
        }
    }

    private static boolean isKey(int x, int y) {
        return map[y][x] - 'a' >= 0 && map[y][x] - 'a' < 6;
    }

    private static boolean isDoor(int x, int y) {
        return map[y][x] - 'A' >= 0 && map[y][x] - 'A' < 6;
    }

    private static boolean haveKey(int mask, char c) {
        return (mask & 1 << c - 'A') != 0;
    }

    private static boolean outOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= M || y >= N;
    }
}