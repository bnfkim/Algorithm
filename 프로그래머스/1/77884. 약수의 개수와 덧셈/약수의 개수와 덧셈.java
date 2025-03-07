class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            if(getPrimeNumber(i)%2==0) answer += i;
            else answer -= i;
        }
        return answer;
    }
    
    public int getPrimeNumber(int num){
        int cnt = 1;
        
        for(int i=2; i<=num; i++){
            if(num%i==0) cnt++;
        }
        
        return cnt;
    }
}