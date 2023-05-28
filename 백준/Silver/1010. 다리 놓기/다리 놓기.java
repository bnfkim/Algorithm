import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //M개 중에 N개를 골라야함 -> M C N
        // (M-1 C N-1) + (M-1 C N) = M C N
        //파스칼 삼각형을 이용하자!

        //파스칼 삼각형 만들기
        int[][] arr = new int[31][31];
        arr[1][1] = 1;
        for(int i=1; i<=30; i++) arr[i][0] = 1;
        for(int i=2; i<=30; i++){
            for(int j=1; j<=30; j++){
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(arr[m][n]);
        }
    }
}