import java.util.ArrayList;
import java.util.Scanner;
class Solution {
    /**
     * 40분 소요
     */
    static String str;
    public static void main(String args[]) throws Exception  {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            str = sc.next(); //문자 길이가 30
            /**
             * 풀이방법
             * 완전탐색 방법 진행
             * 문자열 길이가 1, 2, 3, 4 , 5 .... 10
             * 30이므로 해당 숫자로 30을 나누었을때 떨어지도록 미리 길이 조절
             */
            for(int i=1; i<=10; i++){
                if(i==1) continue;
                int cnt = 30/i;
                if (check(i, cnt)) {
                    System.out.println("#" + tc + " " + i);
                    break;
                }
            }
        }
    }
    public static boolean check(int n, int cnt){
        int idx = 0;
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<cnt; i++){
            String tmp = str.substring(idx, idx+n);
            list.add(tmp);
            idx += n;
        }
        for(int i=0; i< list.size()-1; i++){
            if(!list.get(i).equals(list.get(i+1))) {
                return false;
            }
        }
        return true;
    }
}