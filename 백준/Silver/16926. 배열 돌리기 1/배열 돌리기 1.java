import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        R = Integer.parseInt(st.nextToken()); //회전

        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        print();
    }
    static void solve() {
        int min = Math.min(N, M)/2;

        int cnt = 0;
        while(cnt != R) {

            for(int i=0; i<min; i++) {
                int x = i;
                int y = i;
                int tmp = arr[y][x];

                int dir = 0;
                while (dir < 4) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < i || ny < i || nx >= M - i || ny >= N - i) {
                        dir++; //범위에 벗어나면 방향 바꿈
                        continue;
                    }

                    arr[y][x] = arr[ny][nx];
                    y = ny;
                    x = nx;
                }
                arr[i + 1][i] = tmp;
            }
            cnt++;
        }
    }
    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}