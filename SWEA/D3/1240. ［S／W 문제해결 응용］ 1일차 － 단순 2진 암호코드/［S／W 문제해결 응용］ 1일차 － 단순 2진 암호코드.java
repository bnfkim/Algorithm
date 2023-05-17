import java.util.Objects;
import java.util.Scanner;
class Solution {
    static String[] codingList = { "0001101", "0011001",
            "0010011","0111101","0100011","0110001","0101111",
            "0111011","0110111", "0001011" };
    static String[] strCode = new String[8];
    static int[] numCode = new int[8];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            boolean flag = false;
            for(int i=0; i<n; i++){
                String str = sc.next(); //한줄 입력받음
                if(flag) continue; //입력받기 위한 수단

                int end = -1; //뒤에서부터 1을 찾는 인덱스
                for(int j=str.length()-1; j>=0; j--){
                    if(str.charAt(j) == '1') { //뒤에서 1발견하면 인덱스 반환
                        end = j+1;
                        break;
                    }
                }
                if(end == -1) continue; //0으로만 구성되어있으면 패스

                //56자로 자르기 -> 7비트 * 8개로 자르기
                String tmp = str.substring(end-56, end);
                int cnt = 0;
                for(int j=0; j<8; j++){
                    strCode[j] = tmp.substring(cnt, cnt+7);
                    numCode[j] = check(strCode[j]);
                    cnt += 7;
                }
                flag = true;
            }
            
            int a = 0, b=0;
            for(int i=0; i<8; i++){
                if(i%2 == 0) a += numCode[i];
                else b += numCode[i];
            }
            if(a+b == 0) System.out.println("#" + tc + " " + 0);
            else if((a*3 + b) % 10 != 0) System.out.println("#" + tc + " " + 0);
            else System.out.println("#" + tc + " " + (a + b));
        }
    }
    public static int check(String str){
        int result = -1;
        for(int i=0; i<10; i++){
            if(Objects.equals(str, codingList[i])) result = i;
        }
        return result;
    }
}