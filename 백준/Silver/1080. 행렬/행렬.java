import java.io.*;
import java.util.*;

class Main{
    /**
     * 어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것
     *
     * 0000     1110    1001
     * 0010     1100    1011
     * 0000     1110    1001
     *
     * 0111     1001
     * 0101     1011
     * 0111     1001
     *
     * 1001
     * 1011
     * 1001
     * => 3칸꺼를 어떤 것을 먼저 하든 결과가 나옴
     *
     * 001 .
     * 100 .
     * 100
     * 000
     * 011
     * 010
     * 100
     * 100
     * 010
     * 010
     * 010
     * 110
     * 101
     * 101
     * 000
     * 110
     * 000
     *
     * 110
     * 001
     * 100
     * 011
     * 000
     * 100
     * 010
     * 011
     * 100
     * 101
     * 101
     * 010
     * 001
     * 010
     * 010
     * 111
     * 110
     * 111
     * 001
     */
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