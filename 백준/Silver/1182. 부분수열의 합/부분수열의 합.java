import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int n,s;
    public static int cnt = 0;
    public static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //정수의 개수
        s = Integer.parseInt(st.nextToken()); //정수

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        
        System.out.println((s==0) ? cnt-1 : cnt);
    }
    public static void dfs(int dep, int sum) {
        //모든 탐색 경로를 매번 결과에 추가;
        if(dep == n) {
            if(sum == s) {
                cnt++;
            }
            return;
        }

        dfs(dep+1, sum + nums[dep]); //해당 값을 더하거나
        dfs(dep+1, sum); //해당 값을 더하지 않거나
    }
}