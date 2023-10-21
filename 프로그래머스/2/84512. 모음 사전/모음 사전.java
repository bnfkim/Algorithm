import java.util.*;

class Solution {
    public static char[] chars= {'A', 'E', 'I', 'O', 'U'};
    public static ArrayList<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        
        //알파벳 모음 사전 만들기
        dfs("", 0);
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)) return i;
        }
        return answer;
    }
    public static void dfs(String str, int len) {
        list.add(str);
        if(len == 5) return;
        for(int i=0; i<5; i++) dfs(str + chars[i], len+1);
    }
}