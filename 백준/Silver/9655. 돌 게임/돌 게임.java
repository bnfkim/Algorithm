import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    /**
     * 11:43 -
     * [규칙]
     * 1) 돌 1개 혹은 3개
     * 2) 마지막 돌 가져가는 사람이 이김
     * 3) 상근이가 먼저 시작
     * 4) 상근(SK) 창영(CY)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //돌 개수

        boolean isSK = false;

        /**
         * 1개 -> 상근
         * 2개 -> 상근 > 창영
         * 3개 -> 상근
         * 4개 -> 상근(3) > 창영(1)
         * 5개 -> 상근(3) > 창영(1) > 상근(1)
         * 6개 -> 상근(3) > 창영(3)
         */

        while(n!=0){
            if(n>3){
                n -= 3;
            } else {
                n -= 1;
            }
            isSK = !isSK;
        }

        if(isSK) System.out.println("SK");
        else System.out.println("CY");
    }
}