import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //테스트케이스 개수
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        // 시간초과 난 방법
//        for(int i=0; i <N; i++){
//            //OX 입력받아 한 글자씩 배열에 저장
//            char[] arr = br.readLine().toCharArray();
//            int count = 0;
//            int score = 0;
//            for(int j=0; j<arr.length; i++){
//                if (arr[j] == 'O'){
//                    count += 1;
//                } else if (arr[j] == 'X'){
//                    count = 0;
//                }
//                score += count;
//            }
//            bw.write(score + "\n");
//        }

        // 입력받은 문제 답 arr에 넣기
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        // 배열 원소 String을 char로 쪼개서 OX 여부에 따른 점수 계산
        for(int i=0; i<N; i++){
            int count = 0;
            int score = 0;
            for(int j=0; j<arr[i].length(); j++){
                // String을 char로 빼서 O인지 X인지 확인
                if(arr[i].charAt(j) == 'O'){
                    count++;
                    score += count;
                } else {
                    count = 0;
                }
            }
            bw.write(score + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}