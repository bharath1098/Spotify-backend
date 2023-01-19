import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
   private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs =new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public void addSongsToAlbum(String title,double duration){
        Song s=new Song(title,duration);
        if(isSongExist(title)==true){
            System.out.println("song already added to the album");
           return;
        }
        else{
            songs.add(s);
            System.out.println("Song as been added to Album");
            return;
        }
    }
    public boolean isSongExist(String title){
        for(Song song:songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    public void printSongsInAlbum(){
        for(Song song:songs){
            System.out.println(song);
            }
    }
     //polymorphism
    public void addToPlayListFromAlbum(String title, LinkedList<Song> playlist){
        if(isSongExist(title)){
            for(Song song:songs){
                if(song.getTitle().equals(title)){
                    playlist.add(song);
                    System.out.println("Song as been added to the playList");
                    break;
                }
            }
        }
        else{
            System.out.println("Song not present in the Album");
        }
        return;
    }
    public void addToPlayListFromAlbum(int trackNo, LinkedList<Song> playlist) {
       int index=trackNo-1;
        if (index >= 0 && index < songs.size()) {
            playlist.add(songs.get(index));
            System.out.println("Song as been added to the playList");

        }
        else{
            System.out.println("Invalid Track No");
        }
        return;
    }
}
