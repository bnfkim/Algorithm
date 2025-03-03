class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        //자릿수 합
        int sum = 0;
        int tmp = x;
        
        while(tmp!=0){
            sum += tmp%10;
            tmp /= 10;
        }
        //나누기
        if(x%sum!=0) answer = false;
        
        return answer;
    }
}