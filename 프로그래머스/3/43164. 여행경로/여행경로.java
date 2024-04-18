import java.util.*;

class Solution {
    //[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
    //["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]] [["ICN", "SFO"]
    static int len;
    static String pathResult;
    static boolean[] used;
    static ArrayList<Ticket> ticketList;
    static ArrayList<String> resultList;
    
    static class Ticket {
        String from;
        String to;
        public Ticket(String from, String to) {
            this.from = from;
            this.to = to;
        }
        
        @Override
        public String toString() {
            return "[" + this.from + " -> " + this.to + "]";
        }
    }    
    
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        ticketList = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            ticketList.add(new Ticket(tickets[i][0], tickets[i][1]));
        }
        
        pathResult = "";
        used = new boolean[len];
        dfs("ICN", 0, "ICN");
    
        String[] result = pathResult.split(",");
        return result;
    }
    
    public static void dfs(String from, int cnt, String path) {
        //System.out.println("path = " + path);
        
        if(cnt == len) {
            if(pathResult.isEmpty()) {
                pathResult = path;
            } else {
                if(path.compareTo(pathResult) < 0) {
                    pathResult = path;
                }
            }
            return;
        }
        
        for(int i = 0; i < len; i++) {
            Ticket ticket = ticketList.get(i);
            //System.out.println(ticket + "티켓이 있습니다");
            //System.out.println(Arrays.toString(used));
            
            if(from.equals(ticket.from) && !used[i]) {
                used[i] = true;
                dfs(ticket.to, cnt + 1, (path + "," + ticket.to));
                used[i] = false;
                //System.out.println("일로 오시긴 하나요?");
            }
        }
    }
}