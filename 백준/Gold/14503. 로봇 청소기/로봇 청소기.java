import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static StringTokenizer st;
    static int n,m,r,c,d;
    static int count = 1;
    static int[][] arr;
    static int[] dy = {-1, 0, 1, 0}; //북 동 남 서 순서대로
    static int[] dx = {0, 1, 0, -1};
    static int[][] direction = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; //북 동 남 서 방향
    public static void main(String[] args) throws IOException {
        /**
         * 4:30 -
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로
        arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); //로봇청소기 x좌표
        c = Integer.parseInt(st.nextToken()); //로봇청소기 y좌표
        d = Integer.parseInt(st.nextToken()); //로봇청소기  방향
        //입력받기
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(r, c, d);
        System.out.println(count);
    }
    private static void dfs(int r, int c, int dir) {
        //현재 위치 청소
        arr[r][c] = 2;
        //현재 방향을 기준으로 왼쪽 방향부터 차례대로 탐색 진행
        for(int i=0; i<4; i++){
            dir = (dir+3) % 4; //반 시계방향으로 변환
            int ny = r + dy[dir];
            int nx = c + dx[dir];

            //청소가 안 된 곳이 있으면 count++
            if(ny>=0 && ny<n && nx>=0 && nx<m && arr[ny][nx] == 0) {
                count++;
                dfs(ny, nx, dir);
                //print();
                return;
            }
        }

        //네 방향 모두 청소가 이미 되어있거나 벽인 경우
        //바라보는 방향을 유지한 채로 한 칸 후진
        int back = (dir + 2) % 4;
        int by = r + dy[back];
        int bx = c + dx[back];

        if(by>=0 && by<n && bx>=0 && bx<m && arr[by][bx] != 1) {
            dfs(by, bx, dir);
        }
    }
    private static void print() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                if(arr[i][j] == 2) System.out.print("✦ ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}