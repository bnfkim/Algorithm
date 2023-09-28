class Solution {
        public static int solution(int[] arr) {
        int answer;
        //원소가 한 개인 경우 -> 바로 출력
        if(arr.length == 1) return arr[0];
        
        //원소가 두 개인 경우
        int g = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1])/g;
        
        //원소가 세 개이상인 경우
        if(arr.length > 2) {
            for(int i=2; i<arr.length; i++){
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i])/g;
            }
        }
        return answer;
    }
    //최대 공약수 구하는 함수
    public static int gcd(int a, int b) {
        int r = a%b;
        if(r == 0) return b;
        else return gcd(b, r);
        
    }
}