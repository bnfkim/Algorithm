import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arrStr = s.split(" ");
        //문자열 배열 -> 정수형 배열로 변경
        int[] arrInt = new int[arrStr.length];
        for(int i=0; i<arrStr.length; i++){
            arrInt[i] = Integer.parseInt(arrStr[i]);
        }
        Arrays.sort(arrInt);

        StringBuilder sb = new StringBuilder();
        sb.append(arrInt[0]).append(" ").append(arrInt[arrInt.length-1]);
        
        answer = sb.toString();
        return answer;
    }
}