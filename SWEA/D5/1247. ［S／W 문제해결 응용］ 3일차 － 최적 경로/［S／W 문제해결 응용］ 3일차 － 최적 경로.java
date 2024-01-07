import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public static int n;
    public static Node home;
    public static Node company;
    public static Node[] customers;
    public static boolean[] visited;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            customers = new Node[n];
            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n+2; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(i==0) company = new Node(x, y);
                else if(i==1) home = new Node(x, y);
                else customers[i-2] = new Node(x, y);
            }

            min = Integer.MAX_VALUE;
            makePermutation(company, 0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
    public static void makePermutation(Node now, int cnt, int sum) {
        if(sum > min) { //길이가 최솟값 보다 커지면 바로 리턴
            return;
        }

        if(cnt == n) { //집을 모두 방문 했을 경우 -> 집으로 복귀
            sum += getDistance(now, home);
            min = Math.min(sum, min);
            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[i]) continue; //방문한 집일 경우 패스

            visited[i] = true;
            makePermutation(customers[i], cnt+1, sum+getDistance(now, customers[i]));
            visited[i] = false;
        }
    }
    public static int getDistance(Node n1, Node n2) {
        return Math.abs(n1.y - n2.y) + Math.abs(n1.x - n2.x);
    }
}