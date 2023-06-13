import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    /**
     * 11:43 - 11: 53
     * [규칙]
     * 1) 돌 1개 혹은 3개
     * 2) 마지막 돌 가져가는 사람이 이김
     * 3) 상근이가 먼저 시작
     * 4) 상근(SK) 창영(CY)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //돌 개수

        System.out.println((n%2 == 1) ? "SK" : "CY");
    }
}