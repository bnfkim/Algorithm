import java.util.*;

class Solution {
    boolean solution(String s) {
        int cnt = 0;        
        s = s.toUpperCase();
        
        for(int i = 0; i< s.length(); i++) {
            if(s.charAt(i) == 'P') cnt++;
            else if(s.charAt(i) == 'Y') cnt--;
        }

        return cnt == 0;
    }
}