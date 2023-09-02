import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') { //열린 괄호일 시 
                stack.push(ch); //스택에 넣어줌
            } else { //닫힌 괄호일 시
                if(stack.isEmpty()) answer = false; //스택이 비어져있으면 false
                else stack.pop(); //열린괄호가 있으면 빼주기
            }
        }
        //스택에 괄호가 남아있으면 false 처리
        if(!stack.isEmpty()) answer= false;

        return answer;
    }
}