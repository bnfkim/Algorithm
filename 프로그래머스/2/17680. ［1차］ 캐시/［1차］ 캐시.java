import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // cacheSize가 0일 경우 처리
        if(cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(int i=0; i<cities.length; i++ ) {
            //대소문자 구분하지 않기 위해 toUpperCase() 사용
            String city = cities[i].toUpperCase();
            
            if(cache.remove(city)) {
                answer += 1;
                cache.add(city);
            } else {
                answer += 5;
                if(cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(city);
            }
        }
        return answer;
    }
}