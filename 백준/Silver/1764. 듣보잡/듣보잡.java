import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //듣도 못한
        int m = Integer.parseInt(st.nextToken()); //보도 못한
        HashMap<String, Integer> map = new HashMap<>();
        while(n-->0){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        while(m-->0){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0)+1);
        }

        ArrayList<String> nameList = new ArrayList<>();
        for(String s : map.keySet()) if(map.get(s) == 2) nameList.add(s);

        Collections.sort(nameList); //사전순을 위한 정렬
        System.out.println(nameList.size());
        for(String name : nameList) System.out.println(name);
    }

}