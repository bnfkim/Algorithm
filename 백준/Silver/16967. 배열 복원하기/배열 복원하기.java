import java.io.*;
import java.util.*;

class Main{
    /**
     * 배열 A ( H × W )
     * 배열 B (  (H + X) × (W + Y) )
     *
     *  (1) 배열 모두 포함 X -> 0
     *  (2) 배열 모두 포함 O -> A(이동전) + A(d이동 후)
     *  (3) 배열 하나 포함 -> 포함되어있는 A
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); //세로
        int W = Integer.parseInt(st.nextToken()); //가로
        int X = Integer.parseInt(st.nextToken()); //세로 늘리는 수
        int Y = Integer.parseInt(st.nextToken()); //가로 늘리는 수

        int[][] result = new int[H][W];
        int[][] arr = new int[H+X][W+Y];
        for(int i=0; i<H+X; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W+Y; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //일단 가장 먼저 1차 깔기
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                result[i][j] = arr[i][j];
            }
        }
        //겹치는 부분 바꾸기
        for(int i=X; i<H; i++){
            for(int j=Y; j<W; j++){
                result[i][j] = arr[i][j] - result[i-X][j-Y];
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}