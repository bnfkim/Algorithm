import java.util.*;

class Solution {
    public int[] solution(String s) {
        //집합 원소 만들기
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        //크기대로 정렬하기
        Arrays.sort(arr, (a,b) -> {
            return a.length() - b.length();
        });
        
        //중복 값을 제거하지만 순서를 유지하기 위해 hashSet 사용
        //set.add() 메소드를 사용하여, 추가가 되면 true를 반환
        Set<String> set = new HashSet<>();
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String str : arr) {
            for(String st : str.split(",")) {
                if(set.add(st)) answer[idx++] = Integer.parseInt(st);
            }
        }
        return answer;
    }
}