import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 10:40
         * [해결방법]
         * (1) .을 기준으로 끊음
         * (2) 4칸이상이면 AAAA, 4칸이하이면 BB진행
         * (3) 홀수이면 -1 반환
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer strToken = new StringTokenizer(str, ".");
        ArrayList<String> list = new ArrayList<>();
        boolean check = true;
        while(strToken.hasMoreTokens()) {
            StringBuilder sb = new StringBuilder();
            String tmp = strToken.nextToken();
            int len = tmp.length();
            //홀수일 경우에는 덮을 수 없음
            if(len%2 != 0) {
                check = false;
                break;
            }
            if(len%4 == 0) sb.append("AAAA".repeat(len/4));
            else {
                int A4 = len/4;
                int B2 = (len-A4*4)/2;
                sb.append("AAAA".repeat(A4)).append("BB".repeat(B2));
            }
            list.add(sb.toString());
        }

        if(!check) System.out.println(-1);
        else {
            StringTokenizer dotToken = new StringTokenizer(str, "X");

            StringBuilder sb = new StringBuilder();
            if(str.charAt(0) == '.'){
                sb.append(dotToken.nextToken());
                for(int i=0; i< list.size(); i++) {
                    sb.append(list.get(i));
                    if(dotToken.hasMoreTokens()) sb.append(dotToken.nextToken());
                }
            } else {
                for(int i=0; i<list.size()-1; i++) {
                    sb.append(list.get(i));
                    sb.append(dotToken.nextToken());
                }
                sb.append(list.get(list.size()-1));
                if(dotToken.hasMoreTokens()) sb.append(dotToken.nextToken());
            }
            System.out.print(sb);
        }
    }
}