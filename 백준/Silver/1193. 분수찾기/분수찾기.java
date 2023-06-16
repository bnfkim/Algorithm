import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         *   1     2     3      4    5     6       28
         *   1     3     6     10    15    21
         *  (1/1) (2/1) (1/3) (4/1) (1/5) (6/1)
         *
         *   n(n+1)/2
         *   n=6 -> 21
         *
         *   1   2   6   7   15  16  28  29
         *   3   5   8   14  17  27
         *   4   9   13  18  26
         *   10  12  19  25
         *   11  20  24
         *   21  23
         *   22
         *
         *   x이 주어지면, n(n+1)/2<x 인 값을 찾아봐야함
         *   ex. x가 23이면, n=6
         *   6은 짝수이므로, 분자가 6, 분모가1
         *   23-21 = 2 이므로 cnt=1;
         *   그 다음인 자모 7(6+1), 분모 1 해주고 cnt--;
         *   숫자를 만날 떄 까지 분자 + 해주기
         *
         */

        int X = Integer.parseInt(br.readLine());
        int denom = 1; //분모
        int num = 1;   //분자

        int idx = 1;
        while(idx*(idx+1)/2 < X) idx++;
        idx = idx-1;

        int cnt = X - (idx*(idx+1)/2) - 1;
        if(idx%2 == 0) {
            num = idx + 1;
            while(cnt!=0) {
                denom++;
                num--;
                cnt--;
            }

        }
        else {
            denom = idx + 1;
            while(cnt!=0) {
                num++;
                denom--;
                cnt--;
            }
        }

        System.out.println(num + "/" + denom);
    }
}