import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<number.length(); i++) {
            int num = number.charAt(i) - '0';
            
            while(!stack.isEmpty() && k > 0 && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        
        //k가 남아있는 경우도 신경써야함
        while(!stack.isEmpty()) {
            if(k > 0) {
                stack.pop();
                k--;
                continue;
            }
            answer.append(stack.pop());
        }
        
        return answer.reverse().toString();
    }
}