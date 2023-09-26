import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        //B->A로 가는 방법 생각
        int cnt = 1;
        while(B != A) {
            if(B < A) {
                cnt = -1;
                break;
            }
            String str = String.valueOf(B);
            if(str.charAt(str.length()-1) != '1' && B%2 != 0) {
                cnt = -1;
                break;
            }
            if(B%2 == 0) B = B/2;
            else B = Long.parseLong(str.substring(0, str.length()-1));

            cnt++;
        }
        System.out.println(cnt);
    }
}