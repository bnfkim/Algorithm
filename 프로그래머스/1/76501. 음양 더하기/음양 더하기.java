class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = absolutes.length;
        
        for(int i=0; i<len; i++){
            if(signs[i]){ //양수면
                answer += absolutes[i];
            }else{ //음수면
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}