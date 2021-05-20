import java.util.ArrayList;

public class Album {
    public final String albumName;
    public final int year;
    public final Artist artist;

    public final ArrayList<Song> songs = new ArrayList<>();

    public Album(String albumName, int year, Artist artist) {
        this.albumName = albumName;
        this.year = year;
        this.artist = artist;
    }

    public void addTrack(Song song) {
        songs.add(song);
    }

    public Song getTrack(int trackNumber) {
        if (trackNumber < 1 || trackNumber > songs.size()) {
            return null;
        }
        return songs.get(trackNumber-1);
    }
}
