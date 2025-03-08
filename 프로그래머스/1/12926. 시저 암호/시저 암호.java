class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        char[] answer = new char[arr.length];
        for(int i=0; i<arr.length; i++){
            //공백은 공백
            if(arr[i] == ' ') {
                answer[i] = ' ';
                continue;
            }
            // 대문자인 경우 ('A'~'Z')
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                answer[i] = (char) ('A' + (arr[i] - 'A' + n) % 26);
            }
            // 소문자인 경우 ('a'~'z')
            else if (arr[i] >= 'a' && arr[i] <= 'z') {
                answer[i] = (char) ('a' + (arr[i] - 'a' + n) % 26);
            }
        }
        return new String(answer);
    }
}