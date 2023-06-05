import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 3:00
         * [해결방법]
         * 1) 팰린드롬인지 아닌지 확인하는 함수
         * 2) 팰린드롬인지 확인하는 방법
         * 앞에서부터 잘라서 팰린드롬인 부분을 찾는다
         * 팰린드롬인 부분을 찾으면, 시작한 인덱스 반환
         * 맨 앞부터 시작한 인덱스 부분까지를 (1)자르고 (2)뒤집어서 (3)붙인다
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int idx = str.length()-1;
        for(int i=0; i<str.length()-1; i++){
            if(isPalindrome(str.substring(i))) {
                idx = i;
                break;
            }
        }
        System.out.println(str.length()+idx);
    }
    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length()-1;
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}