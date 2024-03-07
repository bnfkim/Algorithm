import java.io.*;
import java.util.*;

public class Main {
    static class Bridge implements Comparable<Bridge>{
        int from, to, len;
        public Bridge(int from, int to, int len) {
            this.from = from;
            this.to = to;
            this.len = len;
        }
        @Override
        public int compareTo(Bridge o) {
            return Integer.compare(this.len, o.len);
        }
    }

    static int R, C;
    static int ISLAND_SIZE = 1;
    static int[][] map;
    static boolean[][] visit;
    static int[][] bridgeConnect;
    static int[] parents;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static int find(int island) {
        if(island == parents[island]) return island;
        return parents[island] = find(parents[island]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findIsland();
        findBridge();
        ArrayList<Bridge> bridgeList = makeBridgeList();

        Collections.sort(bridgeList);
        parents = new int[ISLAND_SIZE];
        for(int i=1; i<ISLAND_SIZE; i++) parents[i] = i;

        int result = 0;
        int cnt = 0;
        for (Bridge bridge : bridgeList) {
            if (union(bridge.from, bridge.to)) {
                result += bridge.len;
                cnt++;
            }
            if (cnt == ISLAND_SIZE - 2) break; //최소신장트리 완성
        }
        //모든 섬을 연결하는지 확인
        System.out.println((cnt == ISLAND_SIZE - 2) ? result : -1);
    }

    public static ArrayList<Bridge> makeBridgeList() {
        ArrayList<Bridge> bridgeList = new ArrayList<>();
        for(int i=1; i<=ISLAND_SIZE; i++) {
            for(int j=1; j<=ISLAND_SIZE; j++) {
                if(bridgeConnect[i][j] == 0) continue;
                bridgeList.add(new Bridge(i, j, bridgeConnect[i][j]));
            }
        }
        return bridgeList;
    }
    public static void findIsland() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == 0 || visit[i][j]) continue;
                bfs(i, j);
                ISLAND_SIZE++;
            }
        }
    }

    public static void findBridge() {
        bridgeConnect = new int[ISLAND_SIZE + 1][ISLAND_SIZE + 1];

        // 가로 다리 찾기
        for(int i=0; i<R; i++) {
            int from = 0, to = 0, len = -1;

            for(int j=0; j<C; j++) {
                if(map[i][j] == 0) {
                    if(from != 0) len++; // 다리를 놓음
                    continue;
                }
                if(from == 0) {
                    from = map[i][j]; // 처음 섬을 만난 경우 update
                    len = 0;
                    continue;
                }
                if(map[i][j] == from) {
                    len = 0; // 같은 섬을 만남
                    continue;
                }
                to = map[i][j];
                if(len > 1) bridgeConnect[from][to] = (bridgeConnect[from][to] == 0) ? len : Math.min(bridgeConnect[from][to], len);
                from = to; len = 0;
            }
        }
        // 세로 다리 찾기
        for(int j=0; j<C; j++) {
            int from = 0, to = 0, len = -1;

            for(int i=0; i<R; i++) {
                if(map[i][j] == 0) {
                    if(from != 0) len++; // 다리를 놓음
                    continue;
                }
                if(from == 0) {
                    from = map[i][j]; // 처음 섬을 만난 경우 update
                    len = 0;
                    continue;
                }
                if(map[i][j] == from) {
                    len = 0; // 같은 섬을 만남
                    continue;
                }
                to = map[i][j];
                if(len > 1) bridgeConnect[from][to] = (bridgeConnect[from][to] == 0) ? len : Math.min(bridgeConnect[from][to], len);
                from = to; len = 0;
            }
        }
    }
    private static void bfs(int r, int c) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{r, c});
        visit[r][c] = true;
        map[r][c] = ISLAND_SIZE;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i=0; i<4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
                if(map[nr][nc] == 0 || visit[nr][nc]) continue;

                queue.add(new int[]{nr, nc});
                map[nr][nc] = ISLAND_SIZE;
                visit[nr][nc] = true;
            }
        }
    }
}