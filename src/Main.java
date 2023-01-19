import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album a1=new Album("D-songs","Harikrishna");
        Album a2=new Album("vijay-prakash songs","VijayPrakash");

        a1.addSongsToAlbum("pushpavathi",5.2);
        a1.addSongsToAlbum("Basanni baa",4.8);
        a1.addSongsToAlbum("pushpavathi",5.2);

        a2.addSongsToAlbum("om shivoham",5.6);
        a2.addSongsToAlbum("kali kwatru bottle",4.8);

        a1.printSongsInAlbum();
        a2.printSongsInAlbum();

        LinkedList<Song> playlist=new LinkedList<>();
        a1.addToPlayListFromAlbum("pushpavathi",playlist);
        a1.addToPlayListFromAlbum("om shivoham",playlist);
        a2.addToPlayListFromAlbum("om shivoham",playlist);

        play(playlist);

    }
    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> itr=playlist.listIterator();
        Scanner sc=new Scanner(System.in);
         boolean isForward=false;
        if(playlist.size()>0){
            System.out.println("Current song Playing");
            System.out.println(itr.next());
            isForward=true;
        }
        else{
            System.out.println("Playlist is Empty");
        }
        System.out.println("Enter your choice");
        printMenu();
        boolean quit=false;
        while(!quit){
            int choice=sc.nextInt();
            switch (choice){
                case 1:
              // play next song
              if(isForward==false){
                  itr.next();
                  isForward=true;
              }
              if(itr.hasNext()){
                  System.out.println(itr.next());
              }
              else{
                  System.out.println("You have reached the end of the playList");
                  isForward=false;
              }
              break;
                case 2:
               //play previous song
                    if(isForward==true){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("You have reached the Begining of the playList");
                        isForward=true;
                    }

                    break;
                case 3:
              //Repeat the current song
              if(isForward==true){
                  if(itr.hasPrevious()) {
                      System.out.println(itr.previous());
                      isForward = false;
                  }
                  else{
                      System.out.println("song doesn't exist");
                  }
              }
              else{
                  if(itr.hasNext()) {
                      System.out.println(itr.next());
                      isForward = true;
                  }
                  else{
                      System.out.println("song doesn't exist");
                  }
              }
              break;

                case 4:
                    printMenu();
                    break;

                case 5:
                    if(playlist.size()>0){
                        itr.remove();
                    }
                    break;

                case 6:
                    printSongInPlaylist(playlist);
                    break;

                case 7:
                    quit=true;
                    break;
            }
        }
    }
    public static  void printMenu(){
        System.out.println("1 - Play next Song");
        System.out.println("2 - play previous Song");
        System.out.println("3 - Repeat the current Song");
        System.out.println("4 - Show Menu Again");
        System.out.println("5 - Delete the current Song");
        System.out.println("6 - print all the songs in PlayList");
        System.out.println("7 - Exit");
    }
    public static void printSongInPlaylist(LinkedList<Song> playlist){
        for(Song s:playlist){
            System.out.println(s);
        }
    }
}