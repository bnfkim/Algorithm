class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cnt = 0; //이진 변환의 횟수
        int delZero = 0; //변환 과정에서 제거된 모든 0의 개수
        
        while(!s.equals("1")){
            //(1) x의 모든 0 제거 + 제거된 0의 개수 체크
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '0') delZero++;
            }
            s = s.replaceAll("0", "");

            //(2) x의 길이(c)를 2진법으로 표현한 문자열로 바꾸기
            int c = s.length();
            s = Integer.toBinaryString(c);
                cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = delZero;
        
        return answer;
    }
}