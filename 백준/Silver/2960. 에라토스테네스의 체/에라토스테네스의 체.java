import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    /**
     * 11:20 -
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[n+1];

        int result = 0;
        int cnt = 0;
        boolean flag = false;
        for(int i=2; i<=n; i++) {
            for(int j=i; j<=n; j+=i) {
                if(cnt == k) {
                    flag = true;
                    break;
                }
                if(!visit[j]) {
                    cnt++;
                    result = j;
                    visit[j]  = true;
                }
            }
            if (flag) break;
        }
        System.out.println(result);
    }
}