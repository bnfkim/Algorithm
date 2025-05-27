import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] chess;
    static int min = 64;
    static void check(int row, int col){
        int cnt = 0;
        char color = chess[row][col];

        for(int i=row; i<row+8; i++){
            for(int j=col; j<col+8; j++){
                if(chess[i][j] != color){
                    cnt++;
                }

                if(color == 'W') color = 'B';
                else color = 'W';
            }
            if(color == 'W') color = 'B';
            else color = 'W';
        }
        cnt = Math.min(cnt, 64-cnt);
        min = Math.min(cnt, min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //체스판 만들기
        chess = new char[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                chess[i][j] = str.charAt(j);
            }
        }

        int new_row = n - 7;
        int new_col = m - 7;

        for(int i=0;i<new_row; i++){
            for(int j=0; j<new_col; j++){
                check(i,j);
            }
        }
        System.out.println(min);
    }
}