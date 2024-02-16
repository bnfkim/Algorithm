import java.io.*;
import java.util.*;

public class Main {
    static int R, C, RESULT;
    static boolean arrive;
    static boolean[][] map;
    static int[] dy = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                if(str.charAt(j) == '.') map[i][j] = true;
            }
        }
        solve();
    }
    static void solve() {
        for(int i=0; i<R; i++) {
            arrive = false;
            move(0, 0, i);
        }
        System.out.println(getCount());
    }

    static void move(int dep, int x, int y) {
        if(dep == C-1) {
            arrive = true;
            return;
        }

        for(int i=0; i<3; i++) {
            int nx = x + 1;
            int ny = y + dy[i];

            if(outOfRange(nx, ny)) continue;
            if(!map[ny][nx]) continue;

            map[ny][nx] = false;
            move(dep + 1, nx, ny);

            if(arrive) return;
        }
    }
    static boolean outOfRange(int x, int y) {
        return x<0 || y<0 || x>=C || y >=R;
    }

    static int getCount() {
        int cnt = 0;
        for(int i=0; i<R; i++) {
            if(!map[i][C-1]) cnt++;
        }
        return cnt;
    }
}