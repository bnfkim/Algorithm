import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int n;
    static int[] arr;
    static int[] result;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 순열 숫자
        arr = new int[n];
        result = new int[n];
        visit = new boolean[n];

        for(int i=0; i<n; i++) arr[i] = i+1;
        dfs(0);
    }
    private static void dfs(int depth){
        //종료조건
        if(depth == n) {
            for(int a : result) System.out.print(a + " ");
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(depth+1);
                visit[i] = false;
            }
        }

    }
}