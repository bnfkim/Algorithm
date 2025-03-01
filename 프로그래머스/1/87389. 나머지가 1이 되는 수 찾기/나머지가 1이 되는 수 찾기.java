class Solution {
    public int solution(int n) {
        int answer = 2;
        n -= 1;
        while(n%answer != 0){
            answer++;
        }
        return answer;
    }
}