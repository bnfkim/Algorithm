import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Main {
    public static int w, h;
    public static int result;
    public static int[][] map;
    public static boolean[][] visit;
    public static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    public static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            map = new int[h+1][w+1];
            visit = new boolean[h+1][w+1];
            result = 0;
            for(int i=1; i<=h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=1; i<=h; i++) {
                for(int j=1; j<=w; j++) {
                    if(map[i][j] == 1 && !visit[i][j]) {
                        //System.out.println("시작 -> (" + j + "," + i + ")");
                        result++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(result);
            System.out.println(result);
        }
    }
    public static void dfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visit[y][x] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i=0; i<8; i++) {
                int nextY = node.y + dy[i];
                int nextX = node.x + dx[i];

                if(nextY<1 || nextY>h || nextX<1 || nextX>w) continue;
                if(map[nextY][nextX] == 0 || visit[nextY][nextX]) continue;

                visit[nextY][nextX] = true;
                queue.add(new Node(nextY, nextX));
            }
        }
    }
}