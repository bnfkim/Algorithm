import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        //차량 번호와 입차 시간을 저장할 HashMap
        HashMap<String, Integer> inMap = new HashMap<>();
        //차량 번호와 누적 주차 시간을 저장할 HashMap
        HashMap<String, Integer> timeMap = new HashMap<>();
        
        //(1)주차 차량 시간 계산하기
        for(String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String number = split[1];
            String status = split[2];
            
            int minute = getMinute(time);
            if(status.equals("IN")) {
                inMap.put(number, minute);
            } else {
                int inTime = inMap.remove(number);
                int parkedTime = minute - inTime;
                timeMap.put(number, timeMap.getOrDefault(number, 0) + parkedTime);
            }
        }
        
        // (1-1) 23:59에 출차되지 않은 차량 처리
        int lastTime = getMinute("23:59");
        for(String carNumber : inMap.keySet()) {
            int inTime = inMap.get(carNumber);
            int parkedTime = lastTime - inTime;
            timeMap.put(carNumber, timeMap.getOrDefault(carNumber, 0) + parkedTime);
        }
        
        //(2) 차량 번호순으로 정렬
        PriorityQueue<String> pq = new PriorityQueue<>(timeMap.keySet());

        ArrayList<Integer> feeList = new ArrayList<>();
        while(!pq.isEmpty()) {
            String carNumber = pq.poll();
            int totalTime = timeMap.get(carNumber);

            int fee = fees[1]; //기본 요금
            if(totalTime > fees[0]) { //추가 요금
                fee += Math.ceil((double)(totalTime - fees[0])/ fees[2]) * fees[3];
            }
            feeList.add(fee);
        }
        
        return feeList.stream().mapToInt(i -> i).toArray();
    }
    
    private int getMinute(String time) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]) * 60;
        int m = Integer.parseInt(split[1]);
        return h + m;
    }
}