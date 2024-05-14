import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        String str = sb.reverse().toString();
        
        int[] answer = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            answer[i] = str.charAt(i) - '0';
        }
        return answer;
    }
}