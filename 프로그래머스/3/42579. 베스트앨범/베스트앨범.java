import java.util.*;

class Song implements Comparable<Song> {
    int n, g, p;
    String genre;
    public Song(int n, int  g, int p, String genre) {
        this.n = n;
        this.g = g;
        this.p = p;
        this.genre = genre;
    }
    
    @Override
    public int compareTo(Song s) {
        if(s.g == this.g) {
            if(s.p == this.p) {
                return this.n - s.n;
            }
            return s.p - this.p;
        }
        return s.g - this.g;
    }
}

class Solution {
    static int N;
    //1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    //2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    //3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        N = genres.length;
        ArrayList<Song> songList = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for(int i=0; i<N; i++) {
            int g = map.get(genres[i]);
            int p = plays[i];
            songList.add(new Song(i, g, p, genres[i]));
        }
        
        Collections.sort(songList);
        
        HashMap<String, Integer> cnt = new HashMap<>();
        for(String key : map.keySet()) {
            cnt.put(key, 0);
        }
        
        for(int i=0; i<songList.size(); i++) {
            Song song = songList.get(i);
            
            if(cnt.get(song.genre) == 2) continue;
            
            answer.add(songList.get(i).n);
            cnt.put(song.genre, cnt.get(song.genre) + 1);
        }
        return answer;
    }
}