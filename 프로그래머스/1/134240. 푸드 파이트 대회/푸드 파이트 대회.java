import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            String num = String.valueOf(i).repeat(food[i]/2);
            sb.append(num);
        }
        result.append(sb);
        result.append(0);
        result.append(sb.reverse());
        
        return result.toString();
    }
}