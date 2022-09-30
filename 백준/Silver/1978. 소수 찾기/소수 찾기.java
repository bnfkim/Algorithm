import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        /**
         *  입력) 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
         *  출력) 주어진 수들 중 소수의 개수를 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine());
        br.readLine();
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            //if(is_Prime(num)) count++;
            if(is_Prime2(num)) count++;
        }
        System.out.println(count);
    }

    /**
     * 첫 번재 방법
     */
     static boolean is_Prime(int number){

        if(number == 1) return false;

         for (int i=2; i<number; i++) {
             if(number % i == 0) return false;
         }
         return true;
     }

    /**
     * 두 번재 방법
     */
    static boolean is_Prime2(int number){

        if(number == 1) return false;

        for (int i=2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}