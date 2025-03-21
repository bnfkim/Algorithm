import java.util.*;
import java.io.*;

public class Main {
    static int N, count;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static ArrayList<Integer> answerList;
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        answerList = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0) continue;
                if(visit[i][j]) continue;
                
                count = 0;
                dfs(i, j);
                answerList.add(count);
            }
        }
        
        Collections.sort(answerList);
        sb.append(answerList.size()).append("\n");
        for(int answer : answerList){
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
    
    public static void dfs(int row, int col) {
        visit[row][col] = true;
        count++;
        
        for(int i=0; i<4; i++){
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            
            if(nextRow<0 || nextCol<0 || nextRow>=N || nextCol>=N) continue;
            if(map[nextRow][nextCol] == 0) continue;
            if(visit[nextRow][nextCol]) continue;
            
            dfs(nextRow, nextCol);
        }
    }
}
