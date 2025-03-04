import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1}; // 배열의 길이가 1이면 [-1] 반환

        int min = Arrays.stream(arr).min().getAsInt(); // 가장 작은 값 찾기
        
        return Arrays.stream(arr)  
                     .filter(n -> n != min) // 최솟값이 아닌 것만 필터링
                     .toArray(); // 배열로 변환
    }
}
