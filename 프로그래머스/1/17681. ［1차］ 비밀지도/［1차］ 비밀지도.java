class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            System.out.println(binary);
            
            //배열 길이가 다를 경우 앞에 0 채워줌
            if(binary.length() != n) {
                while(binary.length() != n) {
                    binary = "0" + binary;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(binary.charAt(j) == '1') sb.append('#');
                else sb.append(' ');
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}