import java.util.*;

class Solution {
    public static class Move {
        int fromX, fromY, toX, toY;
        
        public Move(int fromX, int fromY, int toX, int toY) {
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }
    }
    
    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static ArrayList<Move> moveList;
    
    public int solution(String dirs) {
        moveList = new ArrayList<>();
        
        //방향에 맞게 이동해야하는 위치 미리 저장해두기
        HashMap<Character, Point> directions = new HashMap<>();
        directions.put('L', new Point(-1, 0));
        directions.put('R', new Point(1, 0));
        directions.put('U', new Point(0, -1));
        directions.put('D', new Point(0, 1));
        
        Point cur = new Point(0, 0);
        
        for(char d : dirs.toCharArray()) {
            //다음 진행 방향
            Point temp = directions.get(d);
            int nextX = cur.x + temp.x;
            int nextY = cur.y + temp.y;
            
            //범위를 벗어나면 아무 행동도 하지 않고 다음 방향으로 넘어감
            if(nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
                continue;
            }
            
            //중복해서 간 길이라면 위치만 업데이트
            if(!isFirstLine(cur.x, cur.y, nextX, nextY)){
                cur = new Point(nextX, nextY);
                continue;
            }
            
            //한번도 안 가본 위치로 판별
            //출발위치-도착위치 길 새로 저장
            moveList.add(new Move(cur.x, cur.y, nextX, nextY));
            cur = new Point(nextX, nextY);
        }
        return moveList.size();
    }
    
    public static boolean isFirstLine(int curX, int curY, int nextX, int nextY) {
        for(Move move : moveList) {
            if(move.fromX == curX && move.fromY == curY && move.toX == nextX && move.toY == nextY) return false;
            //다시 돌아오는 경우도 같은 라인으로 확인하기 위함
            if(move.fromX == nextX && move.fromY == nextY && move.toX == curX && move.toY == curY) return false;            
        }
        return true;
    }
}