import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double max = 0;
        double avr = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // 수 입력받고 나머지 배열에 저장하기
        for(int i=0; i <N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            // 가장 큰 수 구하기
            if(arr[i]>max){
                max = arr[i];
            }
        }
        // 새로운 평균 값 구하기
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i]/max*100;
            avr += arr[i];
        }
        avr = avr/N;
        bw.write( avr + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}