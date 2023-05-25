import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    /**
     * 11:20 - 11:37
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solve(n, k));
    }
    private static int solve(int n, int k){
        int cnt = 0;
        boolean[] visit = new boolean[n+1];
        
        for(int i=2; i<=n; i++) {
            for(int j=i; j<=n; j+=i) {
                if(!visit[j]){
                    cnt++;
                    visit[j] = true;
                }
                if(cnt==k) return j;
            }
        }
        return -1;
    }
}