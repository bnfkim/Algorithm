import java.util.*;
import java.io.*;

public class Main {

    static int N,S;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(S==0 ? cnt-1 : cnt);
    }

    public static void dfs (int sum, int dep) {
        if(dep == N) {
            if(sum == S) {
                cnt++;
            }
            return;
        }

        dfs(sum + arr[dep], dep+1); //해당 수열 선택
        dfs(sum, dep+1); //해당 수열 미선택
    }

}