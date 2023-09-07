import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        //모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값
        //큰 무게 - 작은 무게 짝짓기
        int answer = 0;
        int idx = 0;
        Arrays.sort(people);
        for(int i=people.length-1; i>=idx; i--){
            if(people[idx] + people[i] <= limit) idx++;
            answer++;
        }
        return answer;
    }
}