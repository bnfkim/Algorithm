import java.io.*;
import java.util.*;
    
class Solution {
    public int[] solution(int k, int[] score) {
        int days = score.length;
        ArrayList<Integer> scoreList = new ArrayList<>();
        int[] answer = new int[days];
        
        for (int i=0; i<days; i++) {
            scoreList.add(score[i]);
            Collections.sort(scoreList, Collections.reverseOrder());
            
            //System.out.println(scoreList.toString());
            
            if(i<k) answer[i] = scoreList.get(i);
            else answer[i] = scoreList.get(k-1);
        }
        return answer;
    }
}