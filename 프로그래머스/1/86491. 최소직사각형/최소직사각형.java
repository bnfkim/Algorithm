import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int dx = 0;
        int dy = 0;
        for(int i=0; i<sizes.length; i++){
            Arrays.sort(sizes[i]);
            if(dx<sizes[i][0]) dx = sizes[i][0];
            if(dy<sizes[i][1]) dy = sizes[i][1];
        }
        return dx * dy;
    }
}