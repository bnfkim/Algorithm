class Solution {
    public int[] solution(int n, int m) {
        return new int[]{getGCD(n,m), getLCM(n,m)};
    }
    
    public int getGCD(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public int getLCM(int a, int b){
        return (a*b)/getGCD(a,b);
    }
}