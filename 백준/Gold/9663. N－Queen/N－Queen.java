import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        /**
         *  입력) N
         *  출력) 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);

        System.out.println(count);
    }

    //재귀함수
    public static void dfs(int col) {
        //col(행)이 N(마지막 행) 까지 도달시 -> 퀸의 배치가 끝난 것 -> count++
        if(col == N){
            count++;
            return;
        }
        for(int i=0; i<N; i++){
            arr[col] = i;
            // 놓을 수 있는 위치일 경우 재귀 호출을 통한 다음 퀸 위치를 둠
            if(positionCheck(col)) { //해당 위치에 퀸을 놓을 수 잇는지 체크
                dfs(col + 1); //다음 퀸을 놓으러 감
            }
        }
    }

    //놓을 위치가 다른 퀸으로부터 위협받는지 검사하는 함수
    public static boolean positionCheck(int col) {
        // 퀸의 경우 같은 가로,세로,대각선 불가
        for(int i=0; i<col; i++){
            // 같은 열에는 퀸 배치 불가
            if (arr[i] == arr[col]) {
                return false;
            }
            // 대각선상에 놓여있는 경우 (열의 차와 행의 차가 같을 경우)
            else if (Math.abs(col-i) == Math.abs(arr[i]-arr[col])) {
                return false;
            }
        }
        return true;
    }
}