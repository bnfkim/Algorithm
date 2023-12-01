import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    //4:07
    public static int N, K, L;
    public static int[][] map;
    public static Deque<Node> snake = new LinkedList<>();
    public static HashMap<Integer, String> move = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //보드의 크기
        K = Integer.parseInt(br.readLine()); //사과의 개수
        map = new int[N+1][N+1];

        while(K-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1; //사과의 위치
        }

        L = Integer.parseInt(br.readLine()); //뱀의 변환 정보
        while(L-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            move.put(X, C);
        }
        System.out.println(solution());

    }
    public static int solution() {
        int time = 0; //초
        int dir = 0; //방향

        snake.add(new Node(1,1));
        int[] dx = {0, 1, 0, -1}; //동 남 서 북
        int[] dy = {1, 0, -1, 0};

        while(!snake.isEmpty()) {
            //(1) 다음 위치가 갈 수 있는지 체크
            //(2) 사과가 있다면, 현재 위치 유지시키면서 앞으로 증가
            //(3) 사과가 없다면, 머리만 이동
            Node head = snake.peekFirst(); //머리
            //System.out.print("(" + head.x + ", " + head.y + ") -> ");
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];
            //System.out.println("(" + nx + ", " + ny + ")");

            if(finish(nx, ny)) break;

            if(map[nx][ny] == 1) {
                map[nx][ny] = 0; //사과 먹은 것으로 처리
            } else {
                snake.pollLast(); //꼬리 빼기
            }
            snake.addFirst(new Node(nx, ny)); //머리 전진 시키기
            time++;

            //방향 바꾸기
            if(move.containsKey(time)) {
                String m = move.get(time);
                if(m.equals("D")) {
                    dir++;
                    if(dir == 4) dir = 0;
                } else {
                    dir--;
                    if(dir == -1) dir = 3;
                }
            }
        }
        return time+1;
    }
    public static boolean finish(int nx, int ny) {
        //벽을 만나면 종료
        if(nx < 1 || ny < 1 || nx > N || ny > N) {
            return true;
        }

        //뱀 몸통을 만나면 종료
        for(Node node : snake) {
            if(node.x == nx && node.y == ny) {
                return true;
            }
        }
        return false;
    }
}