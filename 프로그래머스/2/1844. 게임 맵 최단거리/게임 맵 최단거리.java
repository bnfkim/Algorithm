import java.util.*;

class Node {
    int x;
    int y;
    public Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public static int n, m;
    public static int answer = 0;
    public static boolean[][] visit;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {

        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        
        bfs(maps);
        
        return answer;
    }
    public void bfs(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        visit[0][0] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;
            
            for(int i=0; i<4; i++){
                int nextY = node.y + dy[i];
                int nextX = node.x + dx[i];
                
                if(nextY<0 || nextY>=n || nextX<0 || nextX>=m) continue;
                if(visit[nextY][nextX] || maps[nextY][nextX] == 0) continue; 
                
                queue.add(new Node(nextY, nextX));
                visit[nextY][nextX] = true;
                maps[nextY][nextX] += maps[node.y][node.x];
            }
        }
        
        answer = maps[n-1][m-1];
        answer = (answer==1) ? -1 : answer;
    }
}