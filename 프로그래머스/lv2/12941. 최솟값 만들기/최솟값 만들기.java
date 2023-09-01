import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        //최솟값이 되기 위해선 ? -> 가장 작은 값 * 작은 큰 값을 하는게 좋음
        
        //(1) 둘 다 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++){
            answer += A[i] * B[B.length-i-1];
        }

        return answer;
    }
}