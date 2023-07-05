import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //종이 개수
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[101][101];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<=y2; y++){
                for(int x=x1; x<=x2; x++){
                    arr[y][x]++;
                }
            }
        }

        int cnt = 0;
        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){
                if(arr[i][j] > m) cnt++;
            }
        }
        System.out.println(cnt);
    }
}