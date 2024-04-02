import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] map, distance;
    static final int INF = 0x3f3f3f3f;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static StringBuilder sb = new StringBuilder();

    static class Node {
        int y, x, cost; //다음 노드, 다음 노드로 가는데 필요한 비용
        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            result = 0;
            map = new int[N][N];
            distance = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = INF;
                }
            }
            solve();
            sb.append("Problem ").append(testCase++).append(": ").append(distance[N-1][N-1]).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(0, 0, map[0][0]));
        distance[0][0] = map[0][0];

        while(!pq.isEmpty()) {
            Node now = pq.poll();

//            System.out.println("=======(" + now.x + "," + now.y  + " > " + now.cost + ")========");
//            for(int i = 0; i< N; i++) {
//                for(int j = 0; j < N; j++) {
//                    System.out.print(distance[i][j] == INF ? "X " : distance[i][j] + " ");
//                }
//                System.out.println();
//            }

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(outOfRange(ny, nx)) continue;

//                System.out.println("now.cost + map[ny][nx] < distance[ny][nx]");
//                System.out.println(now.cost + "+"  + map[ny][nx] + "<" + distance[ny][nx]);
                if(now.cost + map[ny][nx] < distance[ny][nx]) {
                    distance[ny][nx] = now.cost + map[ny][nx];
                    pq.offer(new Node(ny, nx, distance[ny][nx]));
                }
            }
        }
    }
    public static boolean outOfRange(int y, int x) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
}