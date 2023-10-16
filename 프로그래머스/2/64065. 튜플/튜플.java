import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        ArrayList<ArrayList<Integer>> groups = parsing(s);
        
        //크기대로 정렬하기
        Collections.sort(groups, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                return list1.size() - list2.size();
            }
        });
        
        //하나씩 List에 넣기
        ArrayList<Integer> answerList = new ArrayList<>();
        for(ArrayList<Integer> group : groups) {
            for(int item : group) {
                if(!answerList.contains(item)) answerList.add(item);
            }
        }
        //list > arr로 바꾸기
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) answer[i] = answerList.get(i);

        return answer;
    }
    
    public static ArrayList<ArrayList<Integer>> parsing(String s) {
        //바깥 중괄호 제거하기
        s = s.substring(2, s.length()-2);
        
        //그룹 분리하기
        String[] strArr = s.split("\\},\\{");
        
        //문자열로 되어있는 원소 정수형으로 바꿔주기
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for(String str : strArr){
            ArrayList<Integer> list = new ArrayList<>();
            String[] items = str.split(",");
            for(String item : items) list.add(Integer.parseInt(item));
            groups.add(list);
        }
        
        return groups;
    }
}