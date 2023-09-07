import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        ArrayList<String> list = new ArrayList<>();

        //가장 먼저 탈락하는 사람의 번호,  몇 번째 차례에 탈락하는지
        //만약 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return
        int idx = 0;
        boolean check = false;
        
        //(1) 중복되는 단어가 있는지 체크
        for(int i=0; i<words.length; i++){
            if(list.contains(words[i])) {
                idx = i;
                check = true;
                System.out.println("중복단어");
                break;
            }
            list.add(words[i]);
            
            //(2) 끝나는 철자로 시작 하는지 체크
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                System.out.println("철자틀림");
                idx = i;
                check = true;
                break;
            }
        }

        if(check) {
            answer[0] = idx%n + 1;
            answer[1] = idx/n + 1;
        }
        return answer;
    }
}