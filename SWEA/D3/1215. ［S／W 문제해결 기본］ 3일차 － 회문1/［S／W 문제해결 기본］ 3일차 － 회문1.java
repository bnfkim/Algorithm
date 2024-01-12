import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int n;
    public static char[][] map = new char[8][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1; tc<=10; tc++) {
            n = Integer.parseInt(br.readLine()); //회문의 길이
            //맵 입력받기
            for(int i=0; i<8; i++) {
                String str = br.readLine();
                for(int j=0; j<8; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            int cnt = 0;

            for(int i=0; i<8; i++) {
                for(int j=0; j<=8-n; j++) {
                    StringBuilder hori = new StringBuilder();
                    StringBuilder verti = new StringBuilder();
                    for(int k=0; k<n; k++) {
                        hori.append(map[i][j+k]);
                        verti.append(map[j+k][i]);
                    }
                    if(isPalindrome(hori.toString())) cnt++;
                    if(isPalindrome(verti.toString())) cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
    
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length()-1;

        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}