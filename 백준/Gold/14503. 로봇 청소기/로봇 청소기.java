import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static int[][] map;
    static int[] robot;

    //0(북), 1(동), 2(남), 3(서)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(cleanRoom());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        //로봇청소기가 있는 칸의 좌표 / 로봇청소기가 바라보는 방향 d
        st = new StringTokenizer(br.readLine());
        robot = new int[3];
        robot[0] = Integer.parseInt(st.nextToken());
        robot[1] = Integer.parseInt(st.nextToken());
        robot[2] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            //0 = 청소X, 1 = 벽, 2 = 청소
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int cleanRoom() {
        int cleanCount = 0;

        while(true) {
            int r = robot[0];
            int c = robot[1];
            int d = robot[2];

            //1. 현재 칸이 청소되지 않은 경우 청소
            if(map[r][c] == 0) {
                map[r][c] = 2; //청소
                cleanCount++;
            }

            boolean moved = false;

            //2. 4방향 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(outOfRange(nr, nc)) continue;

                //청소가 안 된 곳이면 전진
                if(map[nr][nc] == 0) {
                    robot[0] = nr;
                    robot[1] = nc;
                    robot[2] = d;
                    moved = true;

                    break;
                }
            }

            //움직일 수 있는 곳이 없다면 후진
            if(!moved) {
                int backDir = (d + 2) % 4;
                int br = r + dr[backDir];
                int bc = c + dc[backDir];

                if(outOfRange(br, bc) || map[br][bc] == 1) break;

                //방향은 그대로 유지
                robot[0] = br;
                robot[1] = bc;
            }
        }
        return cleanCount;
    }

    public static boolean outOfRange(int r, int c) {
        return (r < 0 || c < 0 || r >=R || c >= C);
    }
}