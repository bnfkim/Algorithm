import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 8:15 - 8:38
         * 패키지 : 기타 줄 6개
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //끊어진 기타줄 개수
        int m = Integer.parseInt(st.nextToken()); //기타줄 브랜드
        ArrayList<int[]> brands = new ArrayList<>();
        int[] pack = new int[m];
        int[] etc = new int[m];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken()); //패키지 가격
            etc[i] = Integer.parseInt(st.nextToken()); //낱개 가격
        }
        /**
         * n이 6개 이상일때랑 아닐때로 나눠서 진행
         *
         */
        Arrays.sort(pack);
        Arrays.sort(etc);

        int pacCnt = 1;
        while(6*pacCnt < n) pacCnt++;
        pacCnt = pacCnt-1;
        int etcCnt = n - (6*pacCnt);

        //수량을 정확하게 맞췄을때
        int all = pack[0]*pacCnt + etc[0]*etcCnt;
        //낱개로만 모두 샀을때
        int etcAll = n*etc[0];
        //패키지로만 모두 샀을때
        int packAll = (pacCnt+1)*pack[0];

        System.out.println(Math.min(all, Math.min(etcAll, packAll)));
    }
}