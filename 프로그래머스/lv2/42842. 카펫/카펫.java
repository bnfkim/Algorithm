import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        //8:25
        int[] answer = new int[2];

        for(int i=1; i<=Math.sqrt(yellow); i++){
            if(yellow%i ==0) {
                int len1 = i+2;
                int len2 = yellow/i + 2;
                
                if(len1*len2 == brown+yellow) {
                    answer[0] = len2;
                    answer[1] = len1;
                }
            }
        }
        
        return answer;
    }
}