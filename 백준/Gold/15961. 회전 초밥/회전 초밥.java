import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, d, k, c;
    static int[] belt, eat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        belt = new int[N];
        eat = new int[d + 1];
        for(int i=0; i<N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(slide());
    }

    static int slide() {
        //k크기의 슬라이드 내에서 먹은 중복 없는 스시 개수
        int cnt = 1; //손님이 먹은 초밥의 가짓수
        eat[c]++;
        for (int i = 0; i < k; i++) {
            //중복이 없는 경우에만 카운트
            if (eat[belt[i]] == 0) cnt++;
            eat[belt[i]]++;
        }

        int answer = cnt;

        for (int i = 1; i < N; i++) {
            //슬라이드 이동 -> 앞쪽 스시 못 먹음
            int deleteSushi = belt[i - 1];
            eat[deleteSushi]--;
            if (eat[deleteSushi] == 0) cnt--;

            //슬라이드 이동 -> 뒤쪽 스시 먹음
            //회전 초밥이므로 모드를 해줌
            int addSushi = belt[(i + k - 1) % N];
            if (eat[addSushi] == 0) cnt++;
            eat[addSushi]++;

            answer = Integer.max(answer, cnt);
        }

        return answer;
    }
}