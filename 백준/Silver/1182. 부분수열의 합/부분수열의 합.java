import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static int count = 0;
    private static int N; //정수의 개수
    private static int S; //정수의 합
    private static int[] arr;


    public static void main(String[] args) throws IOException {

        /**
         *  입력)
         *  첫째 줄 -> 수의 개수를 나타내는 N과 정수 S가 주어진다.
         *  둘째 줄 -> N개의 정수가 빈 칸을 사이에 두고 주어진다.
         *  출력)
         *  첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        
        if(S==0) System.out.println(count - 1);
        else System.out.println(count);
    }

    private static void dfs(int depth, int sum) {
        if(N == depth) {
            if (S == sum) count++;
            return;
        }
        // 해당 인덱스를 더하거나 or 더하지 않거나
        // 이 과정을 계속 반복해서 S와 값이 같아지는 경우에만 체크
        dfs(depth+1, sum + arr[depth]);
        dfs(depth+1, sum);
    }
}