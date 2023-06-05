import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 3:45 - 4: 30
         *
         * 6 1 1 1 2 0 0
         *
         * 0 0 0 0 0 0 1
         * 0 2 0 0 0 0 1
         * 0 2 3 4 0 0 1
         * 0 2 3 4 0 5 1
         * 6 2 3 4 0 5 1
         * 6 2 3 4 7 5 1
         *
         * 키가 작은 사람부터 배열에 채우기
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            int idx = 0;
            for(int j=0; j<n; j++){
                if(idx == arr[i]) {
                    idx = j;
                    break;
                }
                if(result[j] == 0) idx++;
            }
            while(result[idx] != 0) {
                idx++;
            }
            result[idx] = i+1;
        }
        for(int r : result) System.out.print(r + " ");
    }
}