class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        //         [4  7]
        //    [? 4]       [? 7] 
        // [1 2] [3 4] [5 6] [7 8] 
        
        int idxA = 0;
        int idxB = 1;
        
        while(idxA != idxB) {
            
            idxA = (a-1)/2 + 1;
            idxB = (b-1)/2 + 1;
            System.out.println(idxA);
            System.out.println(idxB);
            a = idxA;
            b = idxB;
            answer++;   
        }

        return answer;
    }
}