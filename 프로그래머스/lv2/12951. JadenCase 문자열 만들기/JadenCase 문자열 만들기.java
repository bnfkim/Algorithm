import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreElements()) {
            String word = st.nextToken();
            if(word.equals(" ")) { //빈칸이라면 그대로 출력
                sb.append(word);
            } else {
                sb.append(word.substring(0,1).toUpperCase()).append(word.substring(1));
            }
        }
        return sb.toString();
    }
}