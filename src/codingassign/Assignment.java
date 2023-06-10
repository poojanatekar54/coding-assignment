package codingassign;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Assignment{
    private int capacity;
    private Map<String, List<String>> store;

    public Assignment(int capacity) {
        this.capacity = capacity;
        this.store = new LinkedHashMap<>();
    }

    public void addSong(String user, String song) {
        List<String> songs = store.getOrDefault(user, new LinkedList<>());
        songs.add(song);

        if (songs.size() > capacity) {
            songs.remove(0); 
        }

        store.put(user, songs);
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        return store.getOrDefault(user, new LinkedList<>());
    }

    public static void main(String[] args) {
        Assignment store = new Assignment(3);

        store.addSong("User1", "S1");
        store.addSong("User1", "S2");
        store.addSong("User1", "S3");
        System.out.println(store.getRecentlyPlayedSongs("User1")); 

        store.addSong("User1", "S4");
        System.out.println(store.getRecentlyPlayedSongs("User1"));  

        store.addSong("User1", "S2");
        System.out.println(store.getRecentlyPlayedSongs("User1"));

        store.addSong("User1", "S1");
        System.out.println(store.getRecentlyPlayedSongs("User1")); 
    }
}
