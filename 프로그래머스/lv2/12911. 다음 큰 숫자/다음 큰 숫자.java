class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //78(1001110) -> 83(1010011)
        
        //(1) 숫자>2진수로 바꾸고 1의 개수 세기
        String bi = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i=0; i<bi.length(); i++) {
            if(bi.charAt(i) == '1') cnt++;
        }
        
        //(3) 1의 개수가 같은 숫자가 나왔을 때 stop
        while(true) {
            int tmp = 0;
            n++;
            String bi2 = Integer.toBinaryString(n);
            for(int i=0; i<bi2.length(); i++){
                if(bi2.charAt(i) == '1') tmp++;
            }
            if(tmp == cnt) { //1의 개수를 만족하는 숫자를 찾았을때
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}