import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0; i<prices.length; i++) {
            int[] item = new int[]{prices[i], i};
            
            if(stack.isEmpty()) {
                stack.push(item);
                continue;
            }
            
            while(true) {
                int price = stack.peek()[0]; //1
                int second = stack.peek()[1];
                
                if(price <= item[0]) break;
                
                answer[second] = i - second;
                stack.pop();
                if(stack.isEmpty()) break;
            }
            stack.push(item);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.peek()[1]] = prices.length - 1 - stack.peek()[1];
            stack.pop();
        }
        
        return answer;
    }
}