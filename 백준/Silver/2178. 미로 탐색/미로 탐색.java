import java.util.*;
import java.io.*;

class Node {
    int x, y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static String[][] map;
    static int[][] visit;
    static StringTokenizer st;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new String[N][M];
        visit = new int[N][M];
        for(int i=0; i<N; i++) map[i] = br.readLine().split("");
        bfs();
        System.out.println(visit[N-1][M-1]);
    }
    
    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));
        visit[0][0] = 1;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int nowX = node.x;
            int nowY = node.y;
            
            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                            
                if(nextX<0 || nextY<0 || nextX >= M || nextY >= N) continue;
                if(map[nextY][nextX].equals("0")) continue;
                if(visit[nextY][nextX] != 0) continue;
                
                q.offer(new Node(nextX, nextY));
                visit[nextY][nextX] = visit[nowY][nowX] + 1;
            }
        }
    }
}
