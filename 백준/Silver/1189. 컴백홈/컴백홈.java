import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int r,c,k;
    static int result = 0;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); //세로
        c = Integer.parseInt(st.nextToken()); //가로
        k = Integer.parseInt(st.nextToken()); //거리
        arr = new int[r][c];
        visit = new boolean[r][c];

        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                if(str.charAt(j)=='T') arr[i][j] = 1;
            }
        }
        visit[r-1][0] = true;
        dfs(r-1,0,1);
        System.out.println(result);
    }
    private static void dfs(int y, int x, int cnt) {
        if(cnt == k) {
            if(y == 0 && x == c-1)  result++;
            return;
        }

        for(int i=0; i<4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            //범위를 벗어나면 패스
            if(nextY<0 || nextY>=r || nextX<0 || nextX>=c) continue;
            //가지 못하는 부분은 패스
            if(visit[nextY][nextX] || arr[nextY][nextX] == 1) continue;

            visit[nextY][nextX] = true;
            dfs(nextY, nextX, cnt+1);
            visit[nextY][nextX] = false;
        }
    }
}