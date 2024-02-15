import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BC implements Comparable<BC> {
    int x;
    int y;
    int c;
    int p;

    public BC(int x, int y, int c, int p) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.p = p;
    }

    @Override
    public int compareTo(BC o) {
        return o.p - this.p;
    }
}
public class Solution {
    static int M, A, RES;
    static BC[] bcList;
    static int[][] move, position;
    static int[][][] map;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            input();
            init();
            solve();
            sb.append("#").append(tc).append(" ").append(RES).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //이동시간
        A = Integer.parseInt(st.nextToken()); //문제풀이.BC 개수

        bcList = new BC[A];
        move = new int[2][M];
        RES = 0;

        //사람 이동 입력받기
        for(int p=0; p<2; p++) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                move[p][i] = Integer.parseInt(st.nextToken());
            }
        }

        //충전기 정보 입력받기
        for(int i=0; i<A; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            bcList[i] = new BC(x, y, c, p);
        }
        Arrays.sort(bcList);
    }

    static void init() {
        map = new int[11][11][2];

        for (int i=1; i<=10; i++) {
            for (int j=1; j<=10; j++) {

                map[i][j][0] = -1;
                map[i][j][1] = -1;

                for(int k=0; k<A; k++) {
                    if(map[i][j][1] > -1) break; //이미 충전기 2개가 찼을 경우

                    int distance = getDistance(i, j, bcList[k].y, bcList[k].x);
                    if(distance > bcList[k].c) continue; //충전 위치 범위가 아닌 경우

                    if(map[i][j][0] == -1) map[i][j][0] = k;
                    else map[i][j][1] = k;
                }
            }
        }
    }

    private static int getDistance(int y1, int x1, int y2, int x2) {
        return Math.abs(x2- x1) + Math.abs(y2-y1);
    }

    static void solve() {
        int[] dx = {0, 0, 1, 0, -1};
        int[] dy = {0, -1, 0, 1, 0};

        //현재 두 명의 위치
        position = new int[2][2];
        position[0] = new int[]{1,1};
        position[1] = new int[]{10,10};

        //처음 출발지 충전
        if(map[position[0][1]][position[0][0]][0] != -1 ) RES += bcList[map[position[0][1]][position[0][0]][0]].p;
        if(map[position[1][1]][position[1][0]][0] != -1) RES += bcList[map[position[1][1]][position[1][0]][0]].p;

        for (int t=0; t<M; t++) {
            //TODO : 사람 위치 변경
            for(int i=0; i<2; i++) {
                position[i][0] += dx[move[i][t]];
                position[i][1] += dy[move[i][t]];
            }

            //1순위 충전기
            int A1 = map[position[0][1]][position[0][0]][0];
            int B1 = map[position[1][1]][position[1][0]][0];

            if (A1 == -1 && B1 == -1) continue;

            //TODO : 겹치지 않으면 -> 각자 1순위 충전기에서 충전
            if(A1 != B1) {
                if (A1 != -1) RES += bcList[A1].p;
                if (B1 != -1) RES += bcList[B1].p;
                continue;
            }

            //TODO : 겹치는 경우 (하나에만 겹치는 경우)
            int A2 = map[position[0][1]][position[0][0]][1];
            int B2 = map[position[1][1]][position[1][0]][1];

            if (A2 == -1 && B2 == -1) RES += bcList[A1].p;
            else if (A2 == -1) RES += bcList[A1].p + bcList[B2].p;
            else if (B2 == -1) RES += bcList[B1].p + bcList[A2].p;
            else RES += bcList[A1].p + Math.max(bcList[A2].p, bcList[B2].p);
        }
    }
}