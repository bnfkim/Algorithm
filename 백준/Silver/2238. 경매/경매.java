import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        //U는 금액의 상한이고, N은 경매에 참여한 회수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] name = new String[N];
        int[] money = new int[N];

        int[] count = new int[U+1];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            name[i] = st.nextToken();
            money[i] = Integer.parseInt(st.nextToken());

            count[money[i]]++;
        }

        //가장 적은 수의 사람이 제시한 가격 찾기
        int minCnt = Integer.MAX_VALUE;
        for(int i=1; i<count.length; i++) {
            if(count[i] != 0) {
                minCnt = Math.min(minCnt, count[i]);
            }
        }
        //System.out.println("minCnt = " + minCnt);

        int minMoney = U;
        for(int i=1; i<count.length; i++) {
            if(count[i] == minCnt) {
                minMoney = Math.min(minMoney, i);
            }
        }
        //System.out.println("minMoney = " + minMoney);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            if(money[i] == minMoney) {
                sb.append(name[i]).append(" ").append(money[i]);
                break;
            }
        }
        System.out.println(sb);
    }
}
