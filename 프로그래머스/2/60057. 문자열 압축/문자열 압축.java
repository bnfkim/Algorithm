class Solution {
    //문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
    public int solution(String s) {
        int len = s.length();
        int answer = len; //문자 길이 자체가 default
        
        //1개 단위부터 절반 길이 단위까지 확인
        for(int i = 1; i <= len / 2; i++) {
            String prev = s.substring(0, i);
            int cnt = 1;
            StringBuilder compressed = new StringBuilder();
            
            //단위(i)만큼 증가 -> 이전 문자열과 비교
            for(int j = i; j <= len; j += i) {
                String next = s.substring(j, Math.min(j + i, s.length()));
                if (prev.equals(next)) {
                    cnt++;
                } else {
                    //다르다면 압축 문자열에 추가
                    compressed.append((cnt > 1) ? cnt : "").append(prev);
                    prev = next; //이전 문자열을 다음 문자열로 업데이트
                    cnt = 1; //카운트 초기화
                }
            }
            //남은 문자열 처리
            compressed.append((cnt > 1) ? cnt : "").append(prev);
            answer = Math.min(answer, compressed.length());
            
        }
    
        return answer;
    }
}