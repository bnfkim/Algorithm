import java.util.*;
import java.io.*;

class Node {
    int col, row;
    public Node(int col, int row){
        this.col = col;
        this.row = row;
    }
}

public class Main {
    static StringTokenizer st ;
    static int N, M;
    static int minDistance = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] selected;
    static ArrayList<Node> storeList;
    static ArrayList<Node> houseList;
    static ArrayList<Node> selectedStoreList;
    
    public static void main(String[] args) throws IOException {
        //(1) 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        storeList = new ArrayList<>();
        houseList = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 1) houseList.add(new Node(j, i));
                else if(map[i][j] == 2) storeList.add(new Node(j, i));
            }
        }
        selected = new boolean[storeList.size()];
        
        //(2) 치킨집 갯수 중 M개 선택하기 -> 조합
        //배열에 M개 치킨집 위치 담기
        combine(0, 0);
        
        System.out.println(minDistance);
    }
    
    public static void combine(int start, int dep) {
        if(dep == M) { //치킨집 M개 선택했다면
            selectedStoreList = new ArrayList<>();
            for(int i=0; i<storeList.size(); i++) {
                //i번째 치킨집 
                if(selected[i]) selectedStoreList.add(storeList.get(i));
            }
            
            minDistance = Math.min(minDistance, getMinDistance());
            return;
        }
        
        for(int i=start; i<storeList.size(); i++){
            selected[i] = true;
            combine(i+1, dep+1);
            selected[i] = false;
        }
    }
    
    public static int getMinDistance(){
        int distanceSum = 0;
        for(Node house : houseList) {
            int distance = Integer.MAX_VALUE;
            for(Node store : selectedStoreList) {
                distance = Math.min(distance, getDistance(store, house));
            }
            distanceSum += distance;
        }
        return distanceSum;
    }
    
    public static int getDistance(Node store, Node house){
        return Math.abs(store.col - house.col) + Math.abs(store.row - house.row);
    }
}
