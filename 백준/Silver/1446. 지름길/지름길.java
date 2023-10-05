
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int start;
    int end;
    int dist;

    public Node(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.dist, o.dist);
    }
}
class Main{
    static Node[] graph;
    static int n,m;
    static int result = 0;
    static int[] dist;
    public static void dijkastra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        dist[0] = 0; //집부터 출발

        while(!pq.isEmpty()) {
            int now = pq.poll().end;

            //index와 연결된 정점 비교
            for(Node next : graph) {
                if(next.start >= now) { //지름길을 탈 수 있는 경우만 실행
                    if(next.end > m) continue; //지름길 도착지가 학교 도착점보다 넘으면 패스

                    int tmp = next.start - now; //지름길 시작점과 현재 위치 차이 거리
                    if(dist[next.end] > dist[now] + next.dist + tmp) {
                        //System.out.println(next.end + "(도착위치) <----> " + now + "(현재위치) + " + next.dist + "(지름길 거리) + " + tmp + "(출발지와 지름길 사이 거리)");
                        dist[next.end] = dist[now] + next.dist + tmp;
                        //System.out.println(dist[next.end] + " = " + dist[now] + " + " + next.dist + " + " + tmp);

                        pq.offer(new Node(now, next.end, dist[next.end]));
                    }
                }
            }
            dist[m] = Math.min(dist[now] + m - now , dist[m]);
        }
        System.out.println(dist[m]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //지름길의 개수
        m = Integer.parseInt(st.nextToken()); //고속도로의 길이
        dist = new int[m+1];
        for(int i=0; i<=m; i++) dist[i] = i;

        graph = new Node[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); //지름길 시작 위치
            int end = Integer.parseInt(st.nextToken()); //지름길 도착 위치
            int dist = Integer.parseInt(st.nextToken()); //지름길 길이

            graph[i] = new Node(start, end, dist);
        }

        //다익스트라 알고리즘 수행
        dijkastra();
    }
}