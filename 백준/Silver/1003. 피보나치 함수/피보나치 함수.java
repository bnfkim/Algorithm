import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    /**
     * 3:45 -
     */
    public static void main(String[] args) throws IOException {
        /**
         * fibo(0) -> 1 0
         * fibo(1) -> 0 1
         * fibo(2) -> fibo(1) + fibo(0) -> 1 1
         * fibo(3) -> fibo(2) + fibo(1) -> 1 2
         * fibo(4) -> fibo(3) + fibo(2) -> 2 3
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> fibo = new ArrayList<>();
        fibo.add(new int[]{1, 0});
        fibo.add(new int[]{0, 1});
        int cnt = 2;
        while(cnt<=40){
            int tmp1 = fibo.get(cnt-1)[0] + fibo.get(cnt-2)[0];
            int tmp2 = fibo.get(cnt-1)[1] + fibo.get(cnt-2)[1];
            fibo.add(new int[]{tmp1,tmp2});
            cnt++;
        }

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++)  {
            int n = Integer.parseInt(br.readLine());
            int zero = fibo.get(n)[0];
            int one = fibo.get(n)[1];
            System.out.println(zero + " " + one);
        }
    }
}