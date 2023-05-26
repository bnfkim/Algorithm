import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    /**
     * 10:57 - 1:00
     * 문제풀이
     * 1) 각 숫자의 위치를 따로 저장
     * 2) 해당 숫자가 4개 이상 있는지 확인
     * 3) 같은 열에 2개씩 2쌍, 같은 행에 2개씩 2쌍 있는지 확인
     * (정사각형이 행 또는 열에 평행해야하기 때문)
     */
    static int N, M;
    static ArrayList<Node>[] list;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int size = 1; //가장 큰 정사각형 크기

        list = new ArrayList[10];
        arr = new int[N][M];
        for(int i=0; i<10; i++) list[i] = new ArrayList<Node>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                int tmp = str.charAt(j) -'0';
                list[tmp].add(new Node(i, j));
                arr[i][j] = tmp;
            }
        }

        for(int i=0; i< list.length; i++) {
            if(list[i].size() < 4) continue;
            for(int j=0; j<list[i].size(); j++){
                int x = list[i].get(j).x;
                int y = list[i].get(j).y;

                int cnt=1;
                while(y+cnt<N && x+cnt<M){
                    if(arr[y+cnt][x] == i && arr[y][x+cnt] == i && arr[y+cnt][x+cnt] == i) {
                        size = Math.max(size, (cnt+1)*(cnt+1));
                    }
                    cnt++;
                }
            }
        }
        System.out.println(size);
    }
}
class Node {
    int x;
    int y;
    Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}