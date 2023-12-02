import java.io.*;
import java.util.*;

public class Main {
    public static Long P, Q;
    public static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(find(N));
    }
    public static Long find(long N) {

        if(N==0) return 1L;
        if(map.containsKey(N)) return map.get(N);

        long a = (long) Math.floor((double) N/P);
        long b = (long) Math.floor((double) N/Q);

        map.put(N, find(a) + find(b));
        return map.get(N);
    }
}