import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M, CNT;
  static String[][] map;
  static boolean[][] visit;
  static boolean[][] finished;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new String[N][M];
    visit = new boolean[N][M];
    finished = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      map[i] = br.readLine().split("");
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

    int nx = x, ny = y;
    if(map[y][x].equals("D")) ny = y + 1;
    if(map[y][x].equals("U")) ny = y - 1;
    if(map[y][x].equals("R")) nx = x + 1;
    if(map[y][x].equals("L")) nx = x - 1;

    if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
      if(!visit[ny][nx]) dfs(nx, ny);
      else {
        if(!finished[ny][nx]) CNT++;
      }
    }
    finished[y][x] = true;
  }
}