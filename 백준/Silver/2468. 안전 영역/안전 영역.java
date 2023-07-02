import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    /**
     * 높이 별로 진행하기
     * 해당 높이에 따라 접근할 수 없다고 체크하기
     */
    static int n;
    static int result = 0; //안전한 영역의 최대 개수
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        int height = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, arr[i][j]);
            }
        }

        for(int h=0; h<=height; h++){ //높이
            //물에 잠기지 않는 영역 구하기
            int tmp = 0;
            visit = new boolean[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++) {
                    if(!visit[i][j] && arr[i][j]>h) {
                        tmp++; //영역 추가
                        dfs(i, j, h);
                    }
                }
            }
            result = Math.max(tmp, result);
        }
        System.out.println(result);
    }
    private static void dfs(int y, int x, int h){
        visit[y][x] = true;

        for(int i=0; i<4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextX>=0 && nextX<n && nextY>=0 && nextY<n) {
                if(!visit[nextY][nextX] && arr[nextY][nextX]>h) {
                    dfs(nextY, nextX, h);
                }
            }
        }
    }
}