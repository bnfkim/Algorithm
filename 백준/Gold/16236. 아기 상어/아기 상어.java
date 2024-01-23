import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;
    int s;
    Node(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
}

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0,};
    static int[] dy = {0,0,1,-1};

    //저장 해야 하는 것
    //(1)아기상어 위치, (2)아기상어 사이즈, (3)물고기를 얼마나 먹었는지, 4)몇초가 흘렀는지
    //첫번째 고민! 이렇게 많은 데이터를 한번에 노드에 저장하는게 맞을까?
    //두번째 고민 종료 조건을 어떻게 할것인가?
    //세번째 고민 우선 순위를 어떻게 할것인가? -> comparator<Node> 구현
    //네번째 고민, 물고기를 하나 잡아서 먹었으면 그 위치로 다시 어떻게 시작할 것인가?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        Node now = null;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 9) {
                    now = new Node(j, i, 0);
                    arr[i][j] = 0;
                }
            }
        }

        int size = 2;
        int cnt = 0;
        int sec = 0;

        while (true) {
            PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
                if(o1.s == o2.s) {
                    if(o1.y == o2.y) return o1.x - o2.x;
                    return o1.y - o2.y;
                }
                return o1.s - o2.s;
            });
            visit = new boolean[n][n];

            queue.add(new Node(now.x, now.y, 0));
            visit[now.y][now.x] = true;
            boolean eatFish = false;

            while (!queue.isEmpty()) {
                now = queue.poll();

                //먹은 것 중에, 물고기인지 + 아기 상어가 먹을 수 있는 물고기 인지
                if(arr[now.y][now.x] != 0 && arr[now.y][now.x] < size) {


                    arr[now.y][now.x] = 0; //물고기 먹음
                    cnt++; //먹은 갯수 증가
                    sec += now.s; //시간 증가
                    eatFish = true;
                    break;
                }

                for(int i=0; i<4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                    if(visit[ny][nx] || arr[ny][nx] > size) continue;

                    queue.add(new Node(nx, ny, now.s+1));
                    visit[ny][nx] = true;
                }
            }

            //물고기 먹을 수 있는게 아무 것도 없을 때
            if(!eatFish) break;

            if(cnt == size) {
                size++;
                cnt = 0;
            }
        }

        System.out.println(sec);
    }

    static void print() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visit[i][j]) System.out.print("❇️");
                else System.out.print("⏹️");
            }
            System.out.println();
        }
        System.out.println();
    }
}