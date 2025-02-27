import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int result = a + b;
        System.out.println(result);
        
        
    }
}
