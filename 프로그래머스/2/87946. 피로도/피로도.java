class Solution {
    public static int answer = 0;
    public static boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        //완전탐색 방식 사용하기
        visit = new boolean[dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }
    public static void dfs(int cnt, int k, int[][] dungeons) {
        if(cnt > answer) {
            answer = cnt;
        }
        
        for(int i=0; i<dungeons.length; i++){
            
            if(!visit[i] && dungeons[i][0] <= k){
                visit[i] = true;
                dfs(cnt+1, k-dungeons[i][1], dungeons);   
                visit[i] = false;
            }
        }
        
    }
}