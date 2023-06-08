import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Main{
    /**
     * 1:38 - 2:00
     */
    static LinkedList<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //큐의 크기
        int m = Integer.parseInt(st.nextToken()); //뽑아내려고 하는 수의 개수
        int count = 0;

        //뽑아내는 수 입력받기
        int[] arr = new int[m]; //뽑아내는 수
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) arr[i] = Integer.parseInt(st.nextToken());

        //덱 채우기
        deque = new LinkedList<>();
        for(int i=1; i<=n; i++) deque.offer(i);

        //뽑아낼 원소의 위치가 left가 빠른지 right가 빠른지 판별해서 진행
        for(int i=0; i<m; i++){
            int num = arr[i];
            if(check(num)) { //왼쪽 연산을 수행
                while(num != deque.get(0)) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else { //오른쪽 연산을 수행
                while(num != deque.get(0)) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }
            deque.poll();
        }
        System.out.println(count);
    }
    private static boolean check(int num){
        //num이 deque 크기의 반보다 작은 곳에서 존재한다면, true 반환 (왼쪽연산 수행)
        for(int i=0; i<=deque.size()/2; i++) {
            if(num == deque.get(i)) return true;
        }
        return false;
    }
}