import java.util.*;

class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        int start = 0;
        while(start <= discount.length - 10) {
            //값 넣기
            for(int i=0; i<want.length; i++) map.put(want[i], number[i]);

            for(int i=start; i<start+10; i++) {
                if(!map.containsKey(discount[i])) break;
                map.replace(discount[i], map.get(discount[i])-1);
            }
            if(check(map)) answer++;
            start++;
        }
        return answer;
    }
    
    public static boolean check(HashMap<String, Integer> map){
        boolean isEmpty = true;
        for(String key : map.keySet()) {
            if(map.get(key) != 0) return false;
        }
        return isEmpty;
    }
}