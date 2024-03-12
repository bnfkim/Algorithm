import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        if(people.length == 1) return 1;

        int answer = 0;
        int idx = 0;
        
        Arrays.sort(people);
        
        for(int i = people.length-1; i >= idx; i--){
            if(people[idx] + people[i] <= limit) idx++;
            
            answer++;
        }
        return answer;
    }
}