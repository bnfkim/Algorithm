import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int N, M, u, v;
    static int[][] arr;
    static boolean[] visit;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        arr = new int[N+1][N+1];
        visit = new boolean[N+1];

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        for(int i=1; i<=N; i++){
            if(!visit[i]){
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }
    public static void dfs(int node) {
        visit[node] = true;
        for(int i=1; i<=N; i++){
            if(arr[node][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}