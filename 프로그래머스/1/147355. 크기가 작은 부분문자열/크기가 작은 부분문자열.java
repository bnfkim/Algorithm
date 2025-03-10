import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        ArrayList<Long> list = new ArrayList<>();
        
        for(int i=0; i<=t.length()-len; i++){
            list.add(Long.parseLong(t.substring(i, i+len)));
        }
        
        for(Long l : list) {
            if(l <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}