import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, M;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //배열크기
            M = Integer.parseInt(st.nextToken()); //파리채 크기

            map = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for(int i=0; i<=N-M; i++) {
                for(int j=0; j<=N-M; j++) {
                    result = Math.max(result, getFries(j, i));
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int getFries(int x, int y) {
        int sum = 0;
        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                sum += map[y+i][x+j];
            }
        }
        return sum;
    }
}