class Solution {
    public int solution(int n) {
        int answer = 1;
        
        //f(0) = 0, f(1) = 1, f(2) = 1
        int n1 = 1;
        int n2 = 1;
        
        if(n != 2) {
            for(int i=3; i<=n; i++){
                answer = (n1 + n2) % 1234567;
                n1 = n2;
                n2 = answer;
            }
        }

        return answer;
    }
}