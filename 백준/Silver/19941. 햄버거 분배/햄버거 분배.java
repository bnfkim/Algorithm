import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split("");
        boolean[] ate = new boolean[arr.length];
        
        int cnt = 0; //햄버거를 먹을 수 있는 사람의 수
        for(int i=0; i<N; i++){
            if(arr[i].equals("P")) {
                int startIdx = Math.max(i-K, 0); //인덱스 범위 내에서 탐색하기 위한 조건
                int endIdx = Math.min(i+K, N-1); //인덱스 범위 내에서 탐색하기 위한 조건2
                for(int j=startIdx; j<=endIdx; j++) {
                    if(arr[j].equals("H") && !ate[j]) {
                        ate[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}