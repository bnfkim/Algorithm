import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    static int m, n, k; //세로, 가로, 직사각형 개수
    static int[][] arr; //모눈종이
    static int cnt = 0; //영역의 넓이를 구하기 위한 변수
    static ArrayList<Integer> list = new ArrayList<>(); //각 영역의 넓이
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); 
        arr = new int[m][n];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //해당 모눈종이 채우기
            for(int y=y1; y<y2; y++){
                for(int x=x1; x<x2; x++) {
                    arr[y][x] = 1;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size()); //영역개수
        for(int a : list) System.out.print(a + " ");
    }
    private static void dfs(int y, int x) {
        arr[y][x] = 1;
        cnt++;

        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX<0 || nextX>=n || nextY<0 || nextY>=m) continue;
            if(arr[nextY][nextX] == 0) dfs(nextY, nextX);
        }
    }
}