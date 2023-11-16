import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static int N;
    public static int[] result;
    public static boolean[] visit;
    public static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //노드의 수  N (2 ≤ N ≤ 100,000)
        result = new int[N+1];
        visit = new boolean[N+1];
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 연결되지 않은 노드는 없는가? -> 트리라고 했으니 없음
        bfs();
        for(int i=2; i<=N; i++) {
            System.out.println(result[i]);
        }
    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while(!queue.isEmpty()) {
            int parent = queue.poll();

            for(int i=0; i<graph.get(parent).size(); i++) {
                int child = graph.get(parent).get(i);
                if(visit[child]) continue;

                result[child] = parent;
                queue.add(child);
                visit[child] = true;
            }
        }

    }
}