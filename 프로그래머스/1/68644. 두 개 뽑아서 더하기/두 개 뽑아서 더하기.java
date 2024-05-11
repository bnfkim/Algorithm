import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                int num = numbers[i] + numbers[j];
                if(list.indexOf(num) == -1) list.add(num);
            }
        }
        
        Collections.sort(list);
        
        int[] answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}