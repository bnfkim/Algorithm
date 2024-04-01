import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N, W, H, result;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            //N = 3, W = 10, H = 10
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //구슬 쏘는 갯수 1 ≤ N ≤ 4
            W = Integer.parseInt(st.nextToken());   // 2 ≤ W ≤ 12
            H = Integer.parseInt(st.nextToken());   // 2 ≤ H ≤ 15
            int[][] map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = 0x3f3f3f3f;
            dfs(0, map);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void dfs(int cnt, int[][] map) {
        if (cnt == N) { //종료 조건
            result = Math.min(getRemainBrick(map), result);
            return;
        }

        for (int c = 0; c < W; c++) { //모든 열에 대해 구슬을 쏘기
            int r = 0;
            while (r < H && map[r][c] == 0) r++; //빈 공간이 아닌데까지 내려가기

            if(r == H) dfs(cnt + 1, map); //바닥까지 닿으면 다음 구슬 던짐
            else {
                int[][] newMap = copyMap(map);  //벽돌 복사하기
                boom(r, c, newMap);             //벽돌 깨기
                down(newMap);                   //벽돌 내리기
                dfs(cnt + 1, newMap);       //다음 구슬 던지기
            }

        }
    }

    private static void boom(int r, int c, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        if(map[r][c] > 1) queue.add(new int[]{r, c, map[r][c]});
        map[r][c] = 0; //벽돌 제거

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = pos[0];
                int nc = pos[1];
                int power = pos[2];

                for(int i = 1; i < power; i++) {
                    nr += dr[d];
                    nc += dc[d];
                    if(oufOfRange(nr, nc) || map[nr][nc] == 0) continue;

                    //벽돌깨는 영역에 1 이상인 영역이 있으면 해당 추가 영역을 미치는 걸 큐에 넣기
                    if(map[nr][nc] > 1) queue.offer(new int[]{nr, nc, map[nr][nc]});
                    map[nr][nc] = 0; //벽돌 깨기
                }
            }
        }
    }

    //벽돌을 내리는 메소드 (아래 행부터 위로 행을 찾음)
    private static void down(int[][] map) {
        for(int c = 0; c < W; c++) {
            for(int r = H - 1; r >= 0; r--) { //맨 아래 행부터 맨 위 행까지 확인
                if(map[r][c] == 0) {
                    int nr = r - 1;     //바로 위의 칸을 확인
                    while(nr >= 0 && map[nr][c] == 0) nr--; // 비어있지 않은 칸을 찾을 때까지 계속 위로 이동

                    //비어있지 않은 칸을 찾았다면 -> 현재 비어있는 칸으로 이동
                    if(nr >= 0) {
                        map[r][c] = map[nr][c];
                        map[nr][c] = 0;
                    }
                }
            }
        }
    }

    //남아있는 벽돌 갯수를 세는 메소드
    private static int getRemainBrick(int[][] map) {
        int cnt = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(map[i][j] != 0) cnt ++;
            }
        }
        return cnt;
    }

    private static boolean oufOfRange(int r, int c) {
        return r < 0 || c < 0 || r >= H || c >= W;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[H][W];
        for(int i = 0; i < H; i++) {
            newMap[i] = map[i].clone();
        }
        return newMap;
    }

}