import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Main {
    public static int I;
    public static int[][] map;
    public static boolean[][] visit;
    public static StringTokenizer st;
    public static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visit = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node start = new Node(x, y);

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            bfs(start);
            System.out.println(map[y][x]);
        }
    }
    public static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for(int i=0; i<8; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX<0 || nextY<0 || nextX>=I || nextY>=I) continue;
                if(visit[nextY][nextX]) continue;

                visit[nextY][nextX] = true;
                q.add(new Node(nextX, nextY));
                map[nextY][nextX] = map[now.y][now.x] + 1;
            }
        }
    }
}