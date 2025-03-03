import java.util.*;

class Solution {
    public Integer[] solution(int[] arr, int divisor) {        
        ArrayList<Integer> list = new ArrayList<Integer>();
        //나누어떨어지는지 판단하기
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0) list.add(arr[i]);
        }
        //정렬하기
        Collections.sort(list);
        
        //리스트 > 배열 변경
        int size = list.size();
        
        //나누어 떨어지는 경우가 없다면
        if(size == 0) list.add(-1);
        Integer[] answer = list.toArray(new Integer[size]);
        
        return answer;
    }
}