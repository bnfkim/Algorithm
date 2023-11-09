import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            //N, M, K(1 ≤ N, M, K ≤ 100)
            int N = sc.nextInt(); //사람 수
            int M = sc.nextInt(); //붕어빵 만드는데 걸리는 시간
            int K = sc.nextInt(); //붕어빵 개수

            //손님 입력받기
            int[] arr = new int[11_112];
            for (int i = 0; i < N; i++) {
                int p = sc.nextInt();
                arr[p]++;
            }

            int second = 0;
            int bread = 0;
            boolean isPossible = true;

            while (N > 0) {
                //해당 시간에 붕어빵을 만듬
                if(second != 0 && second % M == 0) {
                    bread += K;
                }

                //해당 초에 방문한 사람이 있으면
                if(arr[second] != 0) {
                    //해당 시간에 온 손님보다 붕어빵이 부족하면 impossible
                    if(bread - arr[second] < 0) {
                        isPossible = false;
                        break;
                    } else {
                        bread -= arr[second];
                        N -= arr[second];
                    }
                }
                second++;
            }
            sb.append("#").append(test_case).append(" ");
            if(isPossible) sb.append("Possible\n");
            else sb.append("Impossible\n");
        }
        System.out.println(sb);
    }
}