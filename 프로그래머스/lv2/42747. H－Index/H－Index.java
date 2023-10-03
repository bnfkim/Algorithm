import java.util.*;

class Solution {
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int cnt = 0;
            for(int j=0; j<citations.length; j++){
                if(citations[j] >= citations[i]) cnt++;
            }
            if(cnt <= citations[i]) answer = Math.max(answer, cnt);
        }

        return answer;
    }
}