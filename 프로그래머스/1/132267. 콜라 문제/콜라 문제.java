import java.io.*;

class Solution {
    //a = 바꿔야 하는 콜라 병 수
    //b = 바꿔주는 콜라 병 수
    //n = 콜라 병수
    public int solution(int a, int b, int n) {
        int answer = 0;
        int modBottle = 0; //손에 들고 있는 콜라 수 
        
        while(n >= a) {
            int mod = n % a;
            int changeBottle = (n / a) * b; //빈병을 바꾸고 받은 수
            
            answer += changeBottle;
            n = changeBottle + mod;
            
        }
        return answer;
    }
}