import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 11:00 - 11:20
         * 8
         * 8 2 5 6 10 17 16 24
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //각 레벨 점수 입력받기
        int[] scores = new int[N]; //각 레벨의 점수
        for(int i=0; i<N; i++) scores[i] = Integer.parseInt(br.readLine());

        int score = scores[scores.length-1]; //최종점수
        //System.out.println(score + "점수부터 시작합니다");
        int cnt = 0;
        for(int i=scores.length-2; i>=0; i--) {
            int tmp = scores[i];
            //System.out.print(tmp + " vs " + score + " >>> ");
            while(true) {
                if(tmp >= score) {
                    //System.out.println("점수 조정이 필요합니다");
                    cnt++;
                    tmp--;
                } else {
                    //System.out.println("점수 조정이 필요 없습니다");
                    score = tmp;
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
}