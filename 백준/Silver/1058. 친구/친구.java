import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int n, result;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            String str = br.readLine();
            for(int j=1; j<=n; j++) {
                char ch = str.charAt(j-1);
                if(ch=='Y') arr[i][j] = 1;
                else arr[i][j] = 9999; //갈수 없는 곳은 무한 숫자
            }
        }

        //플루이드 와샬 (연결된 친구 구해주기)
        for(int y=1; y<=n; y++) { //경유지
            for(int x=1; x<=n; x++) { //출발지
                for(int z=1; z<=n; z++) { //도착지
                    if(x==z || y==x || y==z) continue;
                    //출발지(x) -> 도착지(z) 보다
                    //출발지(x) -> 경유지(y) -> 도착지(z) 경로가 짧으면 값을 수정
                    if(arr[x][z] > arr[x][y] + arr[y][z]) {
                        arr[x][z] = arr[x][y] + arr[y][z];
                    }
                }
            }
        }

        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(i==j) continue; //자기 자신은 건너뜀
                if(arr[i][j]<=2) cnt++; //2-친구인 경우
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }
}