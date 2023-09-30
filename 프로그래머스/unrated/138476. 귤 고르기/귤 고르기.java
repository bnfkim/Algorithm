import java.util.*;

class Solution {
    Map<Integer, Integer> map = new TreeMap<>();
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        for(int t : tangerine) map.put(t, map.getOrDefault(t, 0) + 1);
        
        // custom 한 comparator 로 정렬
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, new customComparator());
        
        //정렬된 key 리스트에서 값을 하나씩 가져와 k에 빼줌
        for(Integer key : keyList) {
            if(k <= 0) break;
            answer++;
            k -= map.get(key);
        }
        return answer;
    }
    public class customComparator implements Comparator<Integer> {
        
        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    }
}