import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main{
    /**
     * 4:15 - 4:20
     *
     * [주의]
     * 모든 로프를 사용해야할 필요가 없음 !
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //로프의 개수
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int result = 0;
        int cnt = 0;
        while(n!=0){
            result = Math.max(result, arr[cnt]*n);
            cnt++;
            n--;
        }
        System.out.println(result);
    }
}