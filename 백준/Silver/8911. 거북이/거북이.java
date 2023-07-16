import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            String cmd = br.readLine();
            int d = 0; //0(북) 1(동) 2(남) 3(서)
            int maxX=0, maxY=0, minX=0, minY=0, nowX = 0, nowY=0;

            for(int i=0; i< cmd.length(); i++){
                char m = cmd.charAt(i);
                switch (m){
                    case 'F':
                        nowX += dx[d];
                        nowY += dy[d];
                        break;
                    case 'B':
                        nowX -= dx[d];
                        nowY -= dy[d];
                        break;
                    case 'L':
                        if(d == 0) d = 3;
                        else d--;
                        break;
                    case 'R':
                        if(d == 3) d = 0;
                        else d++;
                        break;
                }
                maxX = Math.max(nowX, maxX);
                maxY = Math.max(nowY, maxY);
                minX = Math.min(nowX, minX);
                minY = Math.min(nowY, minY);
            }
            sb.append((maxX - minX) * (maxY - minY)).append("\n");
        }
        System.out.println(sb);
    }
}