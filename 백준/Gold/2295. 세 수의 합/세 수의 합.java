import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //System.out.println(bruteForce(list));
        System.out.println(twoPointer(arr));
    }

    public static int twoPointer(int[] arr) {
        // A + B + C = X 가 있는가 ? 에 대한 질문을
        // X - C 가 A + B 의 집합에 있는가? 로 바꾸기
        int len = arr.length;

        Arrays.sort(arr);
        //(1) A+B 집합 만들기
        int cnt = 0;
        int[] sum = new int[len* len];
        for(int i=0; i<len; i++) {
            for(int j=i; j<len; j++) {
                sum[cnt++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sum, 0, cnt-1);

        //(2) X-C 탐색하기
        int result = 0;
        for(int i=len-1; i>=0; i--) {
            for(int j=i; j>=0; j--) {
                int value = arr[i] - arr[j];
                if(Arrays.binarySearch(sum, 0, cnt-1, value) < 0) continue;
                return arr[i];
            }
        }
        return result;
    }
}