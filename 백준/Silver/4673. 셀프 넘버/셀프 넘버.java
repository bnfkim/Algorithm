public class Main{
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];
        for(int i=1; i<arr.length; i++){
            int selfNum = checkSelfNum(i);
            if(selfNum<10001) arr[selfNum] = true;
        }
        for(int i=1; i<arr.length; i++){
            if(!arr[i]) System.out.println(i);
        }
    }
    public static int checkSelfNum(int num) {
        int sum = num;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }
}