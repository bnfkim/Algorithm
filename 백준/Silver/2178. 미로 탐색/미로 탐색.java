import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}

class Main{
    static int n,m;
    static String[][] arr;
    static int[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];
        visit = new int[n][m];
        //배열 입력받기
        for(int i=0; i<n; i++) arr[i] = br.readLine().split("");
        bfs();
        System.out.println(visit[n-1][m-1]);
    }
    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0));
        visit[0][0] = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                //배열 범위 벗어나지 않도록
                if(nextX<0 || nextX>=m || nextY<0 || nextY>=n) continue;
                //갈 수 있는 곳만 가야함 && 방문하지 않은 곳만 가야함
                if(arr[nextY][nextX].equals("1") && visit[nextY][nextX] == 0) {
                    queue.offer(new Node(nextY, nextX));
                    visit[nextY][nextX] = visit[nowY][nowX] + 1;
                }
            }
        }
    }
}