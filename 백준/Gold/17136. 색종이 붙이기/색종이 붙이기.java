import java.io.*;
import java.util.*;

public class Main {
    static int result = Integer.MAX_VALUE;              //최소 색종이 갯수
    static int[][] map = new int[10][10];                //종이
    static int[] paper = new int[]{0, 5, 5, 5, 5, 5};    //색종이 갯수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //종이 입력받기
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void solve(int r, int c, int cnt) {
        if(r >= 10) {
            result = Math.min(result, cnt);
            return;
        }

        if(c >= 10) {
            solve(r + 1, 0, cnt);
            return;
        }

        if(map[r][c] == 1) {
            for(int size = 5; size >= 1; size--) {

                if(paper[size] <= 0 || !canCover(r, c, size)) continue;

                /**
                 * 백트래킹
                 */
                cover(r, c, size, 0); //색종이 덮기
                paper[size]--;
                solve(r, c + size, cnt + 1); //다음 위치 탐색
                cover(r, c, size, 1); //다시 덮었던 색종이 제거
                paper[size]++;
            }
        } else {
            //현재 위치가 0이면 다음 위치 탐색
            solve(r, c + 1, cnt);
        }
    }

    public static void cover(int r, int c, int size, int value) {
        //색종이 덮기
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                map[i][j] = value;
            }
        }
    }

    public static boolean canCover(int r, int c, int size) {
        if (r + size > 10 || c + size > 10) return false;

        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(map[i][j] != 1) return false;
            }
        }
        return true;
    }
}