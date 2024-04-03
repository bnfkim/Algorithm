import java.io.*;
import java.util.*;

/**
 * 11:20
 *
 * 반시계 방향으로 돌릴시 -> 톱니(6) + 톱니(2)
 * 반대편이랑 서로 같으면 -> 회전x / 서로 같으면 -> 회전o
 *
 */
public class Solution {

    static int[][] gear = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {

            int K = Integer.parseInt(br.readLine()); //회전 횟수

            //톱니바퀴 입력받기 (N극이면 0점, S극이면 1점)
            for(int i=0; i<4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) gear[i][j] = Integer.parseInt(st.nextToken());
            }

            while(K-- > 0){
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1; //톱니 바퀴 번호
                boolean isClockWise = Integer.parseInt(st.nextToken()) == 1;     //시계 방향(1), 반 시계 방향(-1)
                operation(idx, isClockWise);
            }

            int result = 0;
            for(int i = 0; i < 4; i++){
                result += (int) (Math.pow(2, i) * gear[i][0]);
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    //톱니바퀴 연산을 동작
    static void operation(int idx, boolean isClockWise) {
        //해당 톱니바퀴를 기준으로, 영향을 주는 톱이를 움직임
        //인덱스는 해당 방향으로 넣어주고, 방향은 반대로 입력
        leftRotate(idx-1, !isClockWise);
        rightRotate(idx+1, !isClockWise);
        myselfRotate(idx, isClockWise);
    }

    private static void leftRotate(int idx, boolean isClockWise) {
        if(idx < 0) return;
        if(gear[idx][2] == gear[idx + 1][6]) return;

        leftRotate(idx - 1, !isClockWise);
        myselfRotate(idx, isClockWise);
    }

    private static void rightRotate(int idx, boolean isClockWise) {
        if(idx > 3) return;
        if(gear[idx][6] == gear[idx - 1][2]) return;

        rightRotate(idx + 1, !isClockWise);
        myselfRotate(idx, isClockWise);
    }

    private static void myselfRotate(int idx, boolean isClockWise) {
        if (isClockWise) {
            //시계 방향으로 한바퀴 돌리기
            int tmp = gear[idx][7];
            for(int i = 7; i > 0; i--) gear[idx][i] = gear[idx][i-1];
            gear[idx][0] = tmp;
        } else {
            //반시계 방향으로 한바퀴 돌리기
            int tmp = gear[idx][0];
            for(int i = 0; i < 7; i++) gear[idx][i] = gear[idx][i+1];
            gear[idx][7] = tmp;
        }
    }
}