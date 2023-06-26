import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * [해결방법]
         * . -> 그대로 출력
         * X가 나오면 숫자 세기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for(int i=0; i<line.length(); i++){
            if(line.charAt(i) == '.') sb.append(".");
            else {
                cnt++;
                if((i+1)==line.length() || line.charAt(i+1) == '.')  {
                    if(cnt%2 !=0) {
                        sb.setLength(0);
                        sb.append(-1);
                        break;
                    }
                    while(cnt>0){
                        if(cnt>=4) {
                            sb.append("AAAA");
                            cnt -= 4;
                        } else {
                            sb.append("BB");
                            cnt -= 2;
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}