import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M, result;
    static Shark[][] map;
    static ArrayList<Shark> sharkList;
    static PriorityQueue<Shark> queue;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, -1, 1, 0, 0};
    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R + 1][C + 1];

        sharkList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());   //속력
            int d = Integer.parseInt(st.nextToken());   //이동방향 (1-위, 2-아래, 3-오른쪽, 4-왼쪽)
            int z = Integer.parseInt(st.nextToken());   //크기

            Shark shark = new Shark(r, c, s, d, z);
            map[r][c] = shark;
            sharkList.add(shark);
        }
        if(M != 0) solve();
        System.out.println(result);
    }

    public static void solve(){
        sharkList.sort((o1, o2) -> o1.z - o2.z);

        //1. 한칸 씩 낚시왕 이동
        for(int c = 1; c <= C; c++) {
            //2. 땅과 제일 가까운 상어 잡음
            for(int r = 1; r <= R; r++) {
                if(map[r][c] == null) continue;
                catchShark(r, c);
                break;
            }

            //3. 상어 이동
            moveShark();

            //System.out.println(c + "번째 이동 최종 모습 <<<< ");
            //printMap();
        }
    }

    private static void moveShark() {
        Shark[][] moveMap = new Shark[R + 1][C + 1];
        ArrayList<Shark> surviveSharkList = new ArrayList<>();

        for (Shark shark : sharkList) {
            int curR = shark.r;
            int curC = shark.c;

            //System.out.println("======" + (i+1) + "번째 상어(" + shark.z + ")=====");
            //printMap();

            for(int speed = 0 ; speed < shark.s; speed++) {
                int nr = curR + dy[shark.d];
                int nc = curC + dx[shark.d];

                //벽에 만나면 방향 바꾸고, 다시 시도
                if(outOfRange(nr, nc)) {
                    shark.d = changeDirection(shark.d);
                    speed--;
                    continue;
                }
                curR = nr;
                curC = nc;
            }

            //System.out.println("최종 움직일 위치 : " + curR + "," + curC);

            // 이동한 위치에 상어가 이미 있다면 크기 비교 후 작은 상어 제거
            if(moveMap[curR][curC] != null) {
                if(moveMap[curR][curC].z < shark.z) {
                    surviveSharkList.remove(moveMap[curR][curC]);
                    moveMap[curR][curC] = shark;
                    surviveSharkList.add(shark);
                }
            } else {
                moveMap[curR][curC] = shark;
                surviveSharkList.add(shark);
            }

            //상어 위치 업데이트
            shark.r = curR;
            shark.c = curC;
        }
        sharkList = surviveSharkList;
        map = moveMap;
    }

    private static boolean outOfRange(int r, int c) {
        return r < 1 || c < 1 || r > R || c > C;
    }

    private static int changeDirection(int direction) {
        if(direction == 1) return 2;
        if(direction == 2) return 1;
        if(direction == 3) return 4;
        if(direction == 4) return 3;
        return direction;
    }

    private static void catchShark(int r, int c) {
        Shark shark = map[r][c];
        //System.out.println(shark.z + "상어를 잡았습니다 !");
        result += shark.z;
        map[r][c] = null;
        sharkList.remove(shark);
    }

//    private static void printMap() {
//        for(int i = 1; i <= R; i++) {
//            for(int j = 1; j <= C; j++) {
//                System.out.print(map[i][j] == null ? "X " : map[i][j].z + " ");
//            }
//            System.out.println();
//        }
//    }
}