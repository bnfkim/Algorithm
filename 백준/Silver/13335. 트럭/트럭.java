import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    /**
     * 1:30 - 2: 30
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //다리를 건너는 트럭
        int w = Integer.parseInt(st.nextToken()); //다리의 길이
        int L = Integer.parseInt(st.nextToken()); //다리의 최대하중
        Queue<Integer> waitingQueue = new LinkedList<>();
        Queue<Integer> passingQueue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) waitingQueue.offer(Integer.parseInt(st.nextToken()));

        //다리 길이만큼 0으로 세팅
        for(int i=0; i<w; i++) passingQueue.offer(0);

        int cnt = 0;
        int sumWeight = 0;
        while(!passingQueue.isEmpty()) {
            sumWeight -= passingQueue.peek();
            passingQueue.poll();

            //대기 트럭이 다 빠져나온 경우
            if(waitingQueue.isEmpty()) {
                cnt += w;
                break;
            } else {
                //하중 무게를 견딜 수 있는 경우
                if(sumWeight + waitingQueue.peek() <= L) {
                    int truck = waitingQueue.poll();
                    passingQueue.offer(truck);
                    sumWeight += truck;
                } else passingQueue.offer(0);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}