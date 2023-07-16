import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            String[] move = br.readLine().split("");
            int d = 0; //0(북) 1(동) 2(남) 3(서)
            int maxX=0, maxY=0, minX=0, minY=0;
            int dx[] = {0, 1, 0, -1};
            int dy[] = {1, 0, -1, 0};
            int nowX = 0;
            int nowY = 0;

            for(int i=0; i< move.length; i++){
                String m = move[i];
                switch (m){
                    case "F":
                        nowX += dx[d];
                        nowY += dy[d];
                        maxX = Math.max(nowX, maxX);
                        maxY = Math.max(nowY, maxY);
                        minX = Math.min(nowX, minX);
                        minY = Math.min(nowY, minY);
                        break;
                    case "B":
                        nowX -= dx[d];
                        nowY -= dy[d];
                        maxX = Math.max(nowX, maxX);
                        maxY = Math.max(nowY, maxY);
                        minX = Math.min(nowX, minX);
                        minY = Math.min(nowY, minY);
                        break;
                    case "L":
                        if(d == 0) d = 4;
                        d--;
                        break;
                    case "R":
                        d++;
                        if(d == 4) d = 0;
                        break;
                }
            }
            int result = (maxX - minX) * (maxY - minY);
            System.out.println(result);
        }
    }
}