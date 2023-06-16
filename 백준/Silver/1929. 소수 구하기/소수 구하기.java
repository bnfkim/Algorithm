import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //에라토스테네스 체 이용해서 미리 소수 구해놓기
        boolean[] isNotPrime = new boolean[1000000];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i=2; i<isNotPrime.length; i++) {
            for(int j=i*2; j<isNotPrime.length; j+=i) {
                isNotPrime[j] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=n; i<=m; i++){
            if(!isNotPrime[i]) System.out.println(i);
        }
    }
}