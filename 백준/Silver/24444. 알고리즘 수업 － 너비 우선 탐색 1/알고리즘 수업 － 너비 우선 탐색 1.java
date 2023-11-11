import java.util.*;

class Main {
    public static int N, M, R;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visit;
    public static int[] result;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //정점의 수
        M = sc.nextInt(); //간선의 수
        R = sc.nextInt(); //시작 정점

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        result = new int[N+1];
        visit = new boolean[N+1];

        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=0; i<N; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(R);

        for(int i=1; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 1;
        queue.add(start);
        visit[start] = true;
        result[start] = cnt++;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int next : graph.get(node)) {
                if(!visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                    result[next] = cnt++;
                }
            }
        }
    }
}