import java.util.*;

class Solution {
    public static int solution(int[] elements) {
        //{7, 9, 1, 1, 4} -> {7, 9, 1, 1, 4 ,7 ,9, 1, 1, 4}
        int[] newElements = new int[elements.length * 2];
        for(int i=0; i<elements.length; i++) {
            newElements[i] = elements[i];
            newElements[i + elements.length] = elements[i];
        }

        Set<Integer> set = new HashSet<>();
        //시작 원소는 처음 배열 길이만큼만 횟수를 돌면 됨
        for(int i=0; i<elements.length; i++) {
            int sum = 0;
            //자기 자신부터, 원소의 길이만큼 더하기
            for(int j=i; j<i+elements.length; j++) {
                sum += newElements[j];
                set.add(sum);
            }
        }
        return set.size();
    }
}