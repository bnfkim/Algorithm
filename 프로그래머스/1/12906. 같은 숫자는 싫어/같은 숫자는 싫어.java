import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for(int i=1; i<arr.length; i++) {    
            //System.out.println("peek =" + stack.peek() + ", arr =" + arr[i]);
            if(stack.size() == 0) {
                stack.push(arr[i]);
                continue;
            }
            
            if(stack.peek() == arr[i]) continue;
            stack.push(arr[i]);
        }
        int[] answer = new int[stack.size()];
        for(int i=0; i<answer.length; i++){
            answer[answer.length-i-1] = stack.pop();
        }
        
        return answer;
    }
}