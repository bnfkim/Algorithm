import java.util.ArrayList;
import java.util.Scanner;
class Solution{
    /**
     * 49분 소요
     */
    static String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        /**
         * [인코딩하는 방법]
         * 1) 한 바이트(8비트)씩, 3바이트(24비트)의 문자를 집어넣음
         * 2) 버터의 위쪽부터 6비트씩 잘라 그 값을 읽고, 인코딩한다
         * [디코딩하는 방법]
         * 1) 6자리로
         *
         * 1) 문자열 -> 숫자바꾸기
         * 2) 숫자 -> 6자리 이진수 만들기
         * 3) 이어만든 이진수로 한 바이트 씩 자르기
         * 4) 다시 코드랑 매치하기
         * 원래는 아스키코드로 char 배열 만들고 싶었는데 아스키 코드 배열 어떻게 만들더라 ..
         */
        for(int tc = 1; tc <= T; tc++){
            String str = sc.next(); //길이가 항상 4의 배수
            StringBuilder sb = new StringBuilder();

            //1)문자열 -> 숫자 바꾸기 -> 2진수로 바꾸기
            for(int i=0; i<str.length(); i++){
                for(int j=0; j<code.length(); j++){
                    if(str.charAt(i) == code.charAt(j)) {
                        StringBuilder bi = new StringBuilder(Integer.toBinaryString(j));
                        while(bi.length() != 6) {
                            bi.insert(0, "0");
                        }
                        sb.append(bi);
                    }
                }
            }
            //216 % 8 = 27 -> 27글자인것
            ArrayList<Integer> list = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            //8자리씩 끊어 2진수 -> 10진수로 바꾸기
            StringBuilder tmp = new StringBuilder();
            for(int i=0; i<sb.length(); i++){
                tmp.append(sb.charAt(i));
                if(tmp.length() == 8){
                    int a = Integer.parseInt(tmp.toString(), 2);
                    result.append((char)a);
                    tmp.setLength(0);
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}