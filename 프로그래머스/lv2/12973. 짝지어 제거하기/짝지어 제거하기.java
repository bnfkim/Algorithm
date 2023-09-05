import java.io.IOException;
import java.util.*;

class Solution 
{
    public int solution(String s)
    {
        int answer = 1;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            if(stack.isEmpty()) {
                stack.push(c);
            } else { //비어있을때 peek() 하면 오류가 나므로 따로 else 처리 후 진행
                if(stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                } 
            }
        }
        
        if(!stack.isEmpty()) answer = 0;
        
        return answer;
    }
}