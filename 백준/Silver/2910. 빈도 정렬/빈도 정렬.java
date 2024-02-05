import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.*;

class Number {
    int num;
    int cnt;
    int idx;

    public Number(int num, int cnt, int idx) {
        this.num = num;
        this.cnt = cnt;
        this.idx = idx;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Number> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)) {
                map.get(num).cnt++;
            } else {
                map.put(num, new Number(num, 1, i));
            }
        }

        PriorityQueue<Number> pq = new PriorityQueue<>(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                if(o1.cnt == o2.cnt) {
                    return o1.idx - o2.idx;
                }
                return o2.cnt - o1.cnt;
            }
        });

        pq.addAll(map.values());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Number number = pq.poll();
            for(int i=0; i<number.cnt; i++) {
                sb.append(number.num).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}