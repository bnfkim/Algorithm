class Solution {
    public static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    public static void dfs(int idx, int sum, int[] numbers, int target) {
        if(idx == numbers.length && sum == target){
            answer++;
            return;
        }
        
        if(idx >= numbers.length) return;
        
        dfs(idx+1, sum+numbers[idx], numbers, target);
        dfs(idx+1, sum-numbers[idx], numbers, target);
        
    }
}