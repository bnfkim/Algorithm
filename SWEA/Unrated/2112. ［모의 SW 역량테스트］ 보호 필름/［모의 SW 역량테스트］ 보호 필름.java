import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int D, W, K, minCnt;
    static int[][] cell;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            input();
            testingFilm(0, 0);

            sb.append("#").append(tc).append(" ").append(minCnt).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void input() throws IOException {
        minCnt = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());       //보호 필름 두께
        W = Integer.parseInt(st.nextToken());       //가로 크기
        K = Integer.parseInt(st.nextToken());       //합격 기준

        cell = new int[D][W];
        for(int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                cell[i][j] = Integer.parseInt(st.nextToken());  //0(A) B(1)
            }
        }
    }

    public static void testingFilm(int curCnt, int curRow) {
        //3-1 : 현재 상태에서 통과할 수 있는 필름인지 확인
        if(canPass()) {
            minCnt = Math.min(minCnt, curCnt);
            return;
        }
        if(curCnt > minCnt) return;     //3-2 : 이전 통과 필름의 주입 횟수보다 더 큰 경우는 더 이상 확인할 필요가 없다.
        if(curRow == D) return;         //3-3 : 필름의 끝에 도달한 경우, 더 이상 진행할 수 없다.

        //0. 원본 배열 저장
        int[] originalRow = Arrays.copyOf(cell[curRow], W);

        // 1. 그대로 유지
        testingFilm(curCnt,curRow + 1);
        //2. A 약 넣기
        changeType(curRow, 0);
        testingFilm(curCnt + 1, curRow + 1);
        //3. B 약 넣기
        changeType(curRow, 1);
        testingFilm(curCnt + 1, curRow + 1);

        //4. 복구하기
        cell[curRow] = Arrays.copyOf(originalRow, W);
    }
    public static void changeType(int r, int type) {
        for(int i = 0; i < W; i++) cell[r][i] = type;
    }

    public static boolean canPass() {
        //모든 열을 다 패스할 수 있는지 확인
        for(int c = 0; c < W; c++) {
            int cnt = 1;
            boolean pass = false;

            for(int r = 1; r < D; r++) {
                if(cell[r][c] == cell[r - 1][c]) cnt++;
                else cnt = 1;

                if(cnt >= K) {
                    pass = true;
                    break;
                }
            }
            if(!pass) return false; // 하나라도 통과하지 못한 경우 false
        }
        return true;
    }
}