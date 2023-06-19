import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}
class Main{
    static int m,n,k,cnt;
    static int[][] arr;
    static boolean[][] visit;
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        /**
         * 10:37 - 11:27
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); //가로길이
            n = Integer.parseInt(st.nextToken()); //세로길이
            k = Integer.parseInt(st.nextToken()); //배추위치
            cnt = 0; // 배추흰지렁이 개수
            arr = new int[n][m];
            visit = new boolean[n][m];
            list = new ArrayList<>();

            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
                list.add(new Node(y,x));
            }
            bfs();
            System.out.println(cnt);
        }
    }
    private static void print() {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(visit[i][j]) System.out.print("✦ ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i=0; i<list.size(); i++) {
            Queue<Node> queue = new LinkedList<>();
            Node startNode = list.get(i);
            if(!visit[startNode.y][startNode.x]) {
                queue.offer(startNode);
                cnt++;
            }
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                int curX = node.x;
                int curY = node.y;
                visit[curY][curX] = true;

                for(int j=0; j<4; j++) {
                    int nextX = curX + dx[j];
                    int nextY = curY + dy[j];
                    if(nextX>=0 && nextX<m && nextY>=0 && nextY<n) {
                        if(arr[nextY][nextX] == 1 && !visit[nextY][nextX]) {
                            queue.offer(new Node(nextY, nextX));
                            visit[nextY][nextX] = true;
                        }
                    }
                }
            }
        }
    }
}