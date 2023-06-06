import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //사람 수
        int[] arr = new int[n]; //인출하는데 걸리는 시간
        int result = 0; //결과 값
        //입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        for(int i=0; i<n-1; i++) arr[i+1] = arr[i+1] + arr[i];
        for(int a : arr) result += a;
        System.out.println(result);
    }
}