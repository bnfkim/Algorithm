import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] paper = new boolean[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int y = h; y < h+10; y++) {
                for(int x = w; x < w+10; x++) {
                    paper[y][x] = true;
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<=100; i++) {
            for(int j=0; j<=100; j++) {
                if(paper[i][j]) cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}