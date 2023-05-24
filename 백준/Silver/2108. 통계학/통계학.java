import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    /**
     * 11:28 -
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int sum = 0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        //산술평균
        System.out.println((int) Math.round((double) sum /n));

        //중앙값
        Arrays.sort(arr);
        System.out.println(arr[n/2]);

        //최빈값
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr) map.put(a, map.getOrDefault(a, 0)+1);

        int maxCnt = 0;
        for(int cnt : map.values()) maxCnt = Math.max(maxCnt, cnt);

        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxCnt) list.add(key);
        }
        Collections.sort(list);
        if(list.size() > 1) System.out.println(list.get(1));
        else System.out.println(list.get(0));

        //범위
        if(n == 1) System.out.println(0);
        else System.out.println(Math.abs(arr[0] - arr[arr.length-1]));
    }
}