import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int n;
    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine()); //순열의 크기

            arr = new int[n+1];
            visited = new boolean[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<n+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cycle = 0;
            for(int i=1; i<n+1; i++) {
                if(!visited[i]) {
                    dfs(i);
                    cycle++;
                }
            }
            sb.append(cycle).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int now) {
        visited[now] = true;

        int next = arr[now];
        if(!visited[next]) {
            dfs(next);
        }
    }
}