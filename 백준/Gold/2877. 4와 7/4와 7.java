import java.io.*;
import java.util.*;

class Main{
    /**
     * 1 = 4 (0)
     * 2 = 7 (1)
     *
     * 3 = 44 (00)
     * 4 = 47 (01)
     * 5 = 74 (10)
     * 6 = 77 (11)
     *
     * 7 = 444 (000)
     * 8 = 447 (001)
     * 9 = 474 (010)
     * 10 = 477 (011)
     * 11 = 744 (110)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = Integer.toBinaryString(n+1);
        //4=0, 7=1
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == '0') sb.append(4);
            else sb.append(7);
        }
        System.out.println(sb);
    }
}