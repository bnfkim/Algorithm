import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    static String[][] arr = new String[5][5];
    static ArrayList<String> list = new ArrayList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력받기
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) arr[i][j] = st.nextToken();
        }
        //위치마다 6자리 수 만들기
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(j,i,1, arr[i][j]);
            }
        }
        System.out.println(list.size());
    }
    private static void dfs(int x, int y, int cnt, String tmp) {
        if(cnt == 6) {
            //중복하지 않는 경우에만 리스트 추가
            if(!list.contains(tmp)) list.add(tmp);
            return;
        }
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX>=0 && nextX<5 && nextY>=0 && nextY<5) {
                dfs(nextX, nextY, cnt+1, tmp+arr[nextY][nextX]);
            }
        }
    }
}