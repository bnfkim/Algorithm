import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //테스트케이스 개수
        int test_case = Integer.parseInt(br.readLine());

        // 입력받은 int arr에 넣기
        for(int i=0; i<test_case; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student_num = Integer.parseInt(st.nextToken());

            int[] arr = new int[student_num];
            float sum = 0;
            // 학생 수 크기 배열 만들어 저장
            for(int j=0; j<student_num; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            // 평균구하기
            float avr = sum/student_num;
            // 평균을 넘는 학생들의 비율 구하기
            float student_over = 0;
            for(int k : arr){
                if(k > avr) {
                    student_over++;
                }
            }
            String result = String.format("%.3f", (student_over*100)/student_num);
            bw.write(result + "%\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}