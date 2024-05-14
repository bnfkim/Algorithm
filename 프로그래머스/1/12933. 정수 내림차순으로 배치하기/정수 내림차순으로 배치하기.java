import java.util.*;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        int len = str.length();
        
        Integer[] arr = new Integer[len];
        for(int i = 0; i < len; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(arr[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}