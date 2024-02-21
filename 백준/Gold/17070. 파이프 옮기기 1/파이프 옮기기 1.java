import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, CNT;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 0, 0);

        System.out.println(CNT);
    }

    public static void dfs(int x, int y, int d) {
        if(x == N-1 && y == N-1) {
            CNT++;
            return;
        }
        if(d == 0) { //가로 방향일 때
            if(x+1 < N && map[y][x+1] == 0) dfs(x+1, y, 0);
            if(x+1 < N && y+1 < N && map[y+1][x] == 0 && map[y][x+1] == 0 && map[y+1][x+1] == 0) dfs(x+1, y+1, 1);
        } else if(d == 2) { //세로 방향일 때
            if(y+1 < N && map[y+1][x] == 0) dfs(x, y+1, 2);
            if(x+1 < N && y+1 < N && map[y+1][x] == 0 && map[y][x+1] == 0 && map[y+1][x+1] == 0) dfs(x+1, y+1, 1);
        } else {
            if(x+1 < N && map[y][x+1] == 0) dfs(x+1, y, 0);
            if(x+1 < N && y+1 < N && map[y][x+1] == 0 && map[y+1][x] == 0 && map[y+1][x+1] == 0) dfs(x+1, y+1, 1);
            if(y+1 < N && map[y+1][x] == 0) dfs(x, y+1, 2);
        }
    }
}