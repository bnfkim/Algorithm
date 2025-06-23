import java.util.*;
import java.io.*;

public class Main {

    static int MAP_SIZE, COMMAND_COUNT;
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] cloud, prevCloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        MAP_SIZE = Integer.parseInt(st.nextToken());
        COMMAND_COUNT = Integer.parseInt(st.nextToken());

        map = new int[MAP_SIZE][MAP_SIZE];
        cloud = new boolean[MAP_SIZE][MAP_SIZE];

        for (int i = 0; i < MAP_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //(0)비바라기 시전
        //(N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다
        cloud[MAP_SIZE-1][0] = true;
        cloud[MAP_SIZE-1][1] = true;
        cloud[MAP_SIZE-2][0] = true;
        cloud[MAP_SIZE-2][1] = true;

        for(int command = 0; command < COMMAND_COUNT; command++) {
            st = new StringTokenizer(br.readLine());
            //1부터 순서대로
            int d = Integer.parseInt(st.nextToken()); //방향
            int s = Integer.parseInt(st.nextToken()); //거리

            //(1) 구름 이동
            moveCloud(d, s);

            //(2) 비가 내림
            rainy();

            //(3) 구름 사라짐
            savePrevCloud();

            //(4) 물복사버그 마법
            copyCloud();

            //(5) 구름 생김
            makeCloud();
        }
        System.out.println(getWaterSum());
    }

    public static void savePrevCloud() {
        prevCloud = new boolean[MAP_SIZE][MAP_SIZE]; //사라진 구름 자리 기억하고 있어야 함
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                prevCloud[i][j] = cloud[i][j];
            }
        }
    }

    // 물복사 :: 대각선 방향에 물이 있으면 물의 양 증가
    public static void copyCloud() {
        //대각선만 취급
        int[] dc = {-1, 1, 1, -1};
        int[] dr = {-1, -1, 1, 1};

        for (int r = 0; r < MAP_SIZE; r++) {
            for (int c = 0; c < MAP_SIZE; c++) {
                if (cloud[r][c]) {
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int nc = c + dc[d];
                        int nr = r + dr[d];
                        if (nc >= 0 && nr >= 0 && nc < MAP_SIZE && nr < MAP_SIZE) {
                            if (map[nr][nc] > 0) count++;
                        }
                    }
                    map[r][c] += count;
                }
            }
        }
    }

    public static void makeCloud() {
        //초기화
        cloud = new boolean[MAP_SIZE][MAP_SIZE];

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                //바구니에 저장된 물의 양이 2 이상인 칸 + 이전 사라진 구름이 아닌 칸 -> 구름이 생김
                if (!prevCloud[i][j] && map[i][j] >= 2) {
                    cloud[i][j] = true;
                    map[i][j] -= 2; //물의 양이 2 줄어든다
                }
            }
        }
    }

    public static void moveCloud(int d, int s) {
        boolean[][] newCloud = new boolean[MAP_SIZE][MAP_SIZE];
        //총 8가지 방향
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};

        for (int r = 0; r < MAP_SIZE; r++) {
            for (int c = 0; c < MAP_SIZE; c++) {
                if (cloud[r][c]) {
                    //만약 왼쪽방향으로, 4칸만큼 간다면,

                    int nr = (r + dy[d - 1] * s) % MAP_SIZE;
                    int nc = (c + dx[d - 1] * s) % MAP_SIZE;

                    // 음수인 경우 보정
                    if (nr < 0) nr += MAP_SIZE;
                    if (nc < 0) nc += MAP_SIZE;

                    newCloud[nr][nc] = true;
                }
            }
        }
        cloud = newCloud;
    }

    //구름이 있는 바구니에 저장된 물의 양이 1 증가
    public static void rainy() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (cloud[i][j]) {
                    map[i][j]++;
                }
            }
        }
    }
    //물의 합 양을 출력하는 함수
    public static int getWaterSum() {
        int sum = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }
}