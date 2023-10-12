import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int scov : scoville) queue.add(scov);
        
        while(queue.peek() < K && queue.size() > 1) {
            int s1 = queue.poll();
            int s2 = queue.poll();
            queue.add(s1 + s2*2);
            answer++;
        }
        return (queue.peek() < K) ? -1 : answer;
    }
}