import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = -1;
        
        double s = Math.sqrt(n);

        if(s % 1 == 0) {
            answer = (long) Math.pow(s+1, 2);
        }
        
        return answer;
    }
}