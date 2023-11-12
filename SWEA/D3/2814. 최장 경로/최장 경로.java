import java.util.*;
import java.io.FileInputStream;

class Solution {
    public static int N, M;
    public static int max;
    public static boolean[] visit;
    public static ArrayList<ArrayList<Integer>> graph;
    public static void main(String args[]) throws Exception 	{
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); //정점
            M = sc.nextInt(); //간선

            graph = new ArrayList<>();
            visit = new boolean[N+1];
            max = 1;
            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

            for(int i=0; i<M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            for(int i=1; i<=N; i++) {
                visit[i] = true;
                dfs(i, 1);
                visit[i] = false;
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
    public static void dfs(int node, int cnt) {
        max = Math.max(max, cnt);
        visit[node] = true;
        for(int i=0; i<graph.get(node).size(); i++) {
            int next = graph.get(node).get(i);
            if(!visit[next]) {
                visit[next] = true;
                dfs(next, cnt+1);
                visit[next] = false;
            }
        }

    }
}