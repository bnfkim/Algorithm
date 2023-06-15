import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int H, W;
    static int[] block;
    public static void main(String[] args) throws IOException {
        /**
         * 풀이방법
         * - 생각의 전환으로 진행
         * - 현재 내가 있는 인덱스 내에서 얼마나 고일 수 있는지만 체크
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken()); //세로
        W = Integer.parseInt(st.nextToken()); //가로

        block = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<block.length; i++) block[i] = Integer.parseInt(st.nextToken());

        int result = 0;
        for(int i=1; i<W-1; i++){
            int left = 0;
            int right = 0;

            //왼쪽 블럭 찾기
            for(int j=0; j<i; j++){
                left = Math.max(block[j], left);
            }
            //오른쪽 블럭 찾기
            for(int j=i+1; j<W; j++) {
                right = Math.max(block[j], right);
            }

            if(block[i]<left && block[i]<right) {
                result += Math.min(left,right) - block[i];
            }
        }
        System.out.println(result);
    }
}