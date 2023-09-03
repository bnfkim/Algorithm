class Solution {
    public int solution(int n) {
        int answer = 1;
        //1부터 쭉 더해서 기본 숫자보다 더 커지면 1 반환
        //같은게 있으면 cnt++;
        //적으면 다음 숫자 더함

        int start = 0;
        while(start < n/2) {
            int cnt = start + 1;
            int sum = 0;

            while(sum < n) {
                sum += cnt;
                if(sum == n) answer++; //숫자랑 같으면 방법 갯수 추가
                cnt++;
            }
            start++;
        }
        
        return answer;
    }
}