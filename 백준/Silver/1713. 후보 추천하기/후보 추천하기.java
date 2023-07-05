import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student {
    int idx; //학생번호
    int cnt; //추천수
    int time; //입력받은수
    boolean isPosted;

    public Student(int idx, int cnt, int time, boolean isPosted) {
        this.idx = idx;
        this.cnt = cnt;
        this.time = time;
        this.isPosted = isPosted;
    }
}
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine()); //사진틀의 개수
        int s = Integer.parseInt(br.readLine()); //추천 횟수

        Student students[] = new Student[101]; //총 100명의 학생
        List<Student> list = new ArrayList<>(); //게시판

        //입력받기
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<s; i++) {
            int num = Integer.parseInt(st.nextToken()); //추천받은 학생 번호
            //(1) 처음 추천 받은 학생의 경우 -> 객체 생성
            if(students[num] == null) students[num] = new Student(num, 0, 0, false);
            //(2) 이미 게시된 경우 -> 추천 횟수 증가
            if(students[num].isPosted) students[num].cnt++;
            //(3) 게시된 적이 없는 경우
            else {
                // (3-1) 게시판이 꽉 찬 경우
                if(list.size() == p) {
                    //추천수에 따라 정렬 -> 같으면 시간 순에 따라 정렬
                    Collections.sort(list, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            if(o1.cnt == o2.cnt) return o1.time - o2.time; //시간 내림차순
                            return o1.cnt - o2.cnt; //횟수 내림자춘
                        }
                    });
                    //맨 앞에 정렬된 게시판 제거
                    list.get(0).isPosted = false;
                    list.remove(0);
                }
                students[num].cnt = 1;
                students[num].time = i;
                students[num].isPosted = true;
                list.add(students[num]);
            }
        }
        //오름차순 출력
        Collections.sort(list, (o1,o2) -> o1.idx-o2.idx);
        for(Student i : list) System.out.print(i.idx + " ");
    }
}