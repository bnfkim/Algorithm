class Solution {
    public String solution(String phone_number) {
        int repeatCnt = phone_number.length() - 4;
        String answer = "*".repeat(repeatCnt);
        for(int i=repeatCnt; i<repeatCnt+4; i++){
            answer = answer + phone_number.charAt(i);
        }
        return answer;
    }
}