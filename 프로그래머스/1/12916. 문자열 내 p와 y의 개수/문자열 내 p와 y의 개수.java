class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        char[] chArr = s.toCharArray();
        
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i=0; i<chArr.length; i++){
            if(chArr[i] =='P') pCnt++;
            if(chArr[i] =='Y') yCnt++;
        }

        return pCnt==yCnt;
    }
}