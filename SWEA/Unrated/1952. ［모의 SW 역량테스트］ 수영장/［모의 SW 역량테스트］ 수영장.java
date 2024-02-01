import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] cost = new int[4];
    static int[] month = new int[12];
    static int result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++) cost[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<12; i++) month[i] = Integer.parseInt(st.nextToken());

            result = cost[3];

            dfs(0,0);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cnt, int sum) {
        if(sum >= result) return;

        if(cnt >= 12) {
            //System.out.println("열두달 도착 !");
            result = Math.min(result, sum);
            return;
        }

        //1일권을 선택한 경우
        dfs(cnt+1, sum + cost[0]*month[cnt]);

        //1달권을 선택한 경우
        dfs(cnt+1, sum + cost[1]);

        //3달권을 선택한 경우
        dfs(cnt+3, sum + cost[2]);
    }
}