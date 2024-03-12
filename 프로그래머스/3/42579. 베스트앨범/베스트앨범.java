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
    
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        N = genres.length;
        ArrayList<Song> songList = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        //많이 재생된 장르를 수록하기 위한 map
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        //정렬하기 위해, Song class 만들어 정렬
        for(int i=0; i<N; i++) {
            songList.add(new Song(i, map.get(genres[i]), plays[i], genres[i]));
        }
        Collections.sort(songList);
        
        //장 많이 재생된 노래를 최대 두 개까지만 넣기 위한 cnt hashMap
        HashMap<String, Integer> cnt = new HashMap<>();
        for(String key : map.keySet()) {
            cnt.put(key, 0);
        }
        
        for(int i=0; i<songList.size(); i++) {
            Song song = songList.get(i);
            
            if(cnt.get(song.genre) < 2) {
                answer.add(songList.get(i).n);
                cnt.put(song.genre, cnt.get(song.genre) + 1);
            }
        }
        return answer;
    }
}