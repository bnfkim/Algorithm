import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M, CNT;
  static char[][] map;
  static boolean[][] visit;
  static boolean[][] finished;

  static int[] dx = {0 , 0, -1, 1};
  static int[] dy = {-1, 1, 0 , 0};
  static char[] move = {'U', 'D', 'L', 'R'};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    visit = new boolean[N][M];
    finished = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(visit[i][j]) continue;
        dfs(j, i);
      }
    }
    System.out.println(CNT);
  }

  public static void dfs(int x, int y) {
    visit[y][x] = true;

    for(int i = 0; i < 4; i++) {
      if(map[y][x] == move[i]) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if(nx < 0 || ny < 0 && nx >= M && ny >= N) break;
        if(!visit[ny][nx]) dfs(nx, ny);
        else {
          if(!finished[ny][nx]) CNT++;
        }
        break;
      }
    }
    finished[y][x] = true;
  }
}