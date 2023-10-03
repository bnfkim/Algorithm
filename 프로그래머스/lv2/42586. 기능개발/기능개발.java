import java.util.*;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] days = new int[progresses.length];
        for(int i=0; i< progresses.length; i++){
            int day = (100 - progresses[i])/speeds[i];
            if((100 - progresses[i])%speeds[i] != 0) day += 1;
            days[i] = day;
        }

        int cnt = 1;
        int release = days[0];
        for(int i=1; i<days.length; i++){
            if(release < days[i]) {
                release = days[i];
                list.add(cnt);
                cnt = 0;
            }
            cnt++;
        }
        list.add(cnt);

        //list -> arr
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}