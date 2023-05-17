import java.util.*;

class Main {
    static int n, m, v;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] dfsV;
    static boolean[] bfsV;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //정점의 개수
        m = sc.nextInt(); //간선의 개수
        v = sc.nextInt(); //시작번호
        graph = new ArrayList<>();
        dfsV = new boolean[n+1];
        bfsV = new boolean[n+1];

        //그래프 만들기
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        //조건 : 작은 수 부터 탐색
        for (ArrayList<Integer> node : graph) Collections.sort(node);
        dfs(v);
        sb.append("\n");
        bfs();
        System.out.println(sb);
    }
    public static void dfs(int v) {

        dfsV[v] = true;
        sb.append(v).append(" ");
        for(int i=0; i<graph.get(v).size(); i++){
            int node = graph.get(v).get(i);
            if(!dfsV[node]) dfs(node);
        }
    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        bfsV[v] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            for(int i=0; i<graph.get(node).size(); i++){
                int tmp = graph.get(node).get(i);
                if(!bfsV[tmp]) {
                    queue.offer(tmp);
                    bfsV[tmp] = true;
                }
            }
        }
    }
}