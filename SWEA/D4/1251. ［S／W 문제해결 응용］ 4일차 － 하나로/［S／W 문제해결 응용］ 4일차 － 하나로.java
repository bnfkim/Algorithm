import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        int f, t;
        double w;
        public Edge(int f, int t, double w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
        }
    }
    static int N;
    static double E;
    static int[] parents;
    static Pos[] posArr;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            posArr = new Pos[N];
            edgeList = new ArrayList<>();

            StringTokenizer xInput = new StringTokenizer(br.readLine());
            StringTokenizer yInput = new StringTokenizer(br.readLine());
            for(int i=0; i<N ; i++) {
                int x = Integer.parseInt(xInput.nextToken());
                int y = Integer.parseInt(yInput.nextToken());
                posArr[i] = new Pos(x, y);
            }

            E = Double.parseDouble(br.readLine());

            sb.append("#").append(tc).append(" ").append(getResult()).append("\n");
        }
        System.out.println(sb);
    }

    public static long getResult() {
        for(int i = 0; i < N; i++) {
            Pos pos1 = posArr[i];

            for(int j=i+1; j<N; j++) {
                Pos pos2 = posArr[j];

                double L = getDistance(pos1.x, pos1.y, pos2.x, pos2.y);
                edgeList.add(new Edge(i, j, L*E));
            }
        }

        Collections.sort(edgeList);
        make();

        double result = 0;
        int cnt = 0;
        for(Edge edge : edgeList) {
            if(!union(edge.f, edge.t)) continue;
            result += edge.w;
            if(++cnt == N-1) break;
        }

        return Math.round(result);
    }

    public static void make() {
        parents = new int[N];
        for(int i=0; i<N; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
    }
}