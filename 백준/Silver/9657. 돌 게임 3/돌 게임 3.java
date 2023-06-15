import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /**
         * 돌 개수 | 이긴사람
         * 0    ->  창영
         * 1    ->  상근
         * 2    ->  창영
         * 3    ->  상근
         * 4    ->  상근
         * 5    ->  상근
         * 6    ->  상근
         * 7    ->  상근
         */

        //상근이가 먼저 시작하므로, 상근이는 자기가 이길 수 있는 돌의 갯수를 가져갈 것
        System.out.println((n % 7 == 0 || n % 7 == 2) ? "CY" : "SK");
    }
}