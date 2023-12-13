import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int result = Integer.MAX_VALUE;
    public static int[][] arr;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //축구를 하기 위해 모인 사람

        visit = new boolean[n];
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        //결과 : 스타트 팀과 링크 팀의 능력치 차이의 최솟값
        System.out.println(result);
    }

    public static void dfs(int start, int dep) {
        //팀 조합이 완성될 경우
        if(dep == n/2) {
            cal();
            return;
        }

        for(int i=start; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i+1, dep+1);
                visit[i] = false;
            }
        }
    }
    public static void cal() {
        //(1) 방문한 팀과 방문 하지 않은 팀을 나누기
        int start = 0;
        int link = 0;

        //(2) 각 팀의 점수를 구하기
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                // i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
                if (visit[i] && visit[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
                // i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
                else if (!visit[i] && !visit[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }
        // 두 팀의 점수 차이 (절댓값)
        int gap = Math.abs(start - link);

        //(3) 최솟값 찾기
        if(gap == 0) {
            System.out.println(gap);
            System.exit(0);
        }

        result = Math.min(gap, result);
    }
}