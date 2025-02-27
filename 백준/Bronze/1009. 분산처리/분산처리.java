import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            //4번곱한
            int[] arr = new int[5];
            arr[1] = a%10;
            for(int i=1; i<4; i++){
                arr[i+1] = (arr[i] * a) % 10;
                //System.out.println(i + "번째 >> " + arr[i]);
            }
            
            int result = arr[b % 4 == 0 ? 4 : b%4]%10;
            
            // 0이면 10으로 변환
            if (result == 0) {
                result = 10;
            }
            //sb.append(result + "\n");
            System.out.println(result);
        }
        //System.out.println(sb);
    }
}
