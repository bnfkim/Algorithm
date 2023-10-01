import java.util.*;

class Solution {
        public static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        //(1) 회전시키기
        int idx = 0;
        while(idx < s.length()) {
            if(isCorrect(sb.toString())) answer++;
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            idx++;
        }
        return answer;
    }
    public static boolean isCorrect(String s) {
        if(s.length() == 1) return false;

        boolean check = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch =='{') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;

                char item = stack.pop();
                switch (item) {
                    case '[':
                        if(ch != ']') return false;
                        break;
                    case '{':
                        if(ch != '}') return false;
                        break;
                    case '(':
                        if(ch != ')') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}