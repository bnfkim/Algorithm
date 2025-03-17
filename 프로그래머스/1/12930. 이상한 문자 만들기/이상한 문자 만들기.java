class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ", -1); // 연속된 공백도 보존
        
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) sb.append(Character.toUpperCase(str.charAt(i)));
                else sb.append(Character.toLowerCase(str.charAt(i)));
            }
            sb.append(" "); // 단어마다 공백 추가
        }
        
        // 마지막에 붙은 공백 제거
        return sb.substring(0, sb.length() - 1);
    }
}
