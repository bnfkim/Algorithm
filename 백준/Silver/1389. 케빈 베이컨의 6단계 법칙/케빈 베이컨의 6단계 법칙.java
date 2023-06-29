import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    static final int INF = 9999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //유저의 수
        int m = Integer.parseInt(st.nextToken()); //친구 관계의 수
        int[][] arr = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] != 1) arr[i][j] = INF;
            }
        }
        //플루이드 와샬 이용
        for(int y=1; y<=n; y++){ //경유지
            for(int x=1; x<=n; x++){ //출발지
                for(int z=1; z<=n; z++){ //도착지
                    if(y==x || y==z || x==z) continue;
                    if(arr[x][z] > arr[x][y] + arr[y][z]) {
                        arr[x][z] = arr[x][y] + arr[y][z];
                    }
                }
            }
        }
        int idx = 0;
        int sum = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            int tmp = 0;
            for(int j=1; j<=n; j++) tmp += arr[i][j];
            //베이컨의 수가 가장 작은 경우 업데이트
            if(tmp < sum) {
                sum = tmp;
                idx = i;
            }
        }
        System.out.println(idx);
    }
}