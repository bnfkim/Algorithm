import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            //숫자라면
            if(ch - '0' < 10) {
                result.append(ch);
                continue;
            }
            //문자라면
            temp.append(ch);
            
            for(int j=0; j<numbers.length; j++){
                //numbers 에 일치하는게 있다면
                if(numbers[j].equals(temp.toString())){
                    result.append(j);
                    temp.setLength(0); ; //리셋
                    break;
                }
            }
        }
        return Integer.parseInt(result.toString());
    }
}