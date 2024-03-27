import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            String str = br.readLine();
            for(int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        solve(0, 0);
    }

    /**
     * 빈 칸(0으로 표시된 칸)을 찾은 후 1부터 9까지의 숫자를 하나씩 넣기
     * 스도쿠의 규칙에 맞는지 검사 (check 메서드)
     *  숫자가 규칙에 맞다면 -> 그 숫자를 칸에 넣고 다음 칸으로 넘어갑
     *         맞지 않다면 -> 다른 숫자를 시도
     */
    public static boolean solve(int row, int col) {
        //한 행을 모두 끝내면 다음 행으로 넘어감
        if (col == 9) {
            row++;
            col = 0;
        }
        // 모든 행을 끝내면, 출력하고 종료
        if (row == 9) {
            printBoard();
            return true;
        }


        if(board[row][col] == 0) { // 현재 칸이 빈 칸이라면
            for(int num = 1; num <= 9; num++) { //1부터 9까지 숫자 시도
                if (!check(row, col, num)) continue; //숫자를 넣을 수 있는지 확인 > 넣을 수 없으면 다음 숫자

                board[row][col] = num; //숫자를 넣기
                if (solve(row, col + 1)) return true;
                else board[row][col] = 0; //넣은 숫자로 안 풀리면 백트래킹으로 다시 0 설정
            }
            //모든 숫자로 해결이 안 된다면
            return false;
        } else { //현재 칸이 이미 숫자로 채워져 있다면 -> 다음 칸으로 진행
            return solve(row, col+1);
        }
    }

    /**
     * 특정 위치에 숫자를 넣을 수 있는지 없는지를 검사
     * (1) 같은 행에 동일한 숫자가 있는지
     * (2) 같은 열에 동일한 숫자가 있는지
     * (3) 같은 3x3 서브 그리드 내에 동일한 숫자가 있는지
     */
    public static boolean check(int row, int col, int num) {
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == num) return false; //(1) 행 체크
            if(board[i][col] == num) return false; //(2) 열 체크
        }

        //(3) 서브 그리드 체크
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[startRow + i][startCol + j] == num) return false;
            }
        }
        //3가지 조건을 통과한 것
        return true;
    }

    public static void printBoard() {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}