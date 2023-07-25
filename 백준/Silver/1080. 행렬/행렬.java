import java.io.*;
import java.util.*;

class Main{
    static int N, M;
    static int cnt = 0;
    static int[][] arrOri;
    static int[][] arrRes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //(1)입력받기
        arrOri = new int[N][M];
        arrRes = new int[N][M];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++) arrOri[i][j] = tmp.charAt(j)-'0';
        }
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++) arrRes[i][j] = tmp.charAt(j)-'0';
        }
        //다르면 뒤집음
        for(int i=0; i<=N-3; i++){
            for(int j=0; j<=M-3; j++){
                if(arrOri[i][j] != arrRes[i][j]) {
                    change(i, j);
                    cnt++;
                }
            }
        }
        //마지막에 달라진 곳이 있는지 한 번 더 확인
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arrOri[i][j] != arrRes[i][j]) cnt = -1;
            }
        }
        System.out.println(cnt);
    }
    //뒤집는 함수
    public static void change(int y, int x) {
        for(int i=y; i<y+3; i++){
            for(int j=x; j<x+3; j++){
                if(arrOri[i][j] == 0) arrOri[i][j] = 1;
                else arrOri[i][j] = 0;
            }
        }
    }
}