import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static boolean[] result;
    static int[] S;
    static int k;

    public static void main(String[] args) throws IOException {

        /**
         *  첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다.
         *  S의 원소는 오름차순으로 주어진다.
         *  입력의 마지막 줄에는 0이 하나 주어진다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());

            if(k == 0) break;

            result = new boolean[k];
            S = new int[k];

            for(int i=0; i<k; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }

            //백트래킹,dfs 사용가능 -> dfs 메소드
            dfs(0, 0);
            System.out.println();
        }
        //System.out.println(sb);
    }

    private static void dfs(int start, int depth) {
        // 6개의 수를 모두 구하면 출력
        if(depth == 6) {
            print();
        }
        for(int i=start; i<k; i++){
            result[i] = true;
            dfs(i+1, depth+1);
            result[i] = false;
        }
    }

    private static void print() {
        for(int i=0; i<k; i++){
            if(result[i]){
                System.out.print(S[i] + " ");
            }
        }
        System.out.println();
    }
}