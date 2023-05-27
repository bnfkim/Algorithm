import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        /**
         * 맨 마지막 자릿수부터 살펴보면 1, 4, 5, 6 까지 오름차순으로 이어지다가  3이 나오는 순간 오름차순이 아니게 된다.
         * 이는 7 2 3 으로 시작하는 수열의 마지막이  7 2 3 6 5 4 1 이라는 뜻이다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //N(1 ≤ N ≤ 10,000)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        if(beforeNumber(arr)) {
            for(int a : arr) System.out.print(a + " ");
        } else System.out.println(-1);
    }
    private static boolean beforeNumber(int[] arr) {
        int i = arr.length-1;
        while(i>0 && arr[i-1] <= arr[i]) i--;
        if(i <= 0) return false; //첫번째 수열인 경우

        int j = arr.length-1;
        while (arr[i-1] <= arr[j]) j--;

        swap(arr, i-1, j);

        j = arr.length-1;
        while(i<j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        return true;
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}