import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            int num = 1;
            int x = 0;
            int y = 0;
            int d = 0;

            int top = 0;
            int right = N;
            int bottom = N;
            int left = 0;

            while(num <= N*N) {
                arr[y][x] = num;
                
                if(d%4 == 0) x++;
                else if (d%4 == 1) y++;
                else if (d%4 == 2) x--;
                else if (d%4 == 3) y--;

                if(x>=right) {
                    x--;
                    y++;
                    top++;
                    d++;
                }
                if(y>=bottom) {
                    y--;
                    x--;
                    right--;
                    d++;
                }
                if(x<left) {
                    x++;
                    y--;
                    bottom--;
                    d++;
                }
                if(y<top) {
                    y++;
                    x++;
                    left++;
                    d++;
                }

                if(d==4) d = 0;
                num++;
            }
            sb.append("#").append(tc).append("\n");
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++){
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}