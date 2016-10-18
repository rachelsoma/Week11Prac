/**
 * Student ID: 18820821 
 * Name: Rachel Hardie 
 * Campus: Kingswood 
 * Tutor Name: Jordan Collier 
 * Class Day: Thursday 
 * Class Time: 0900
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Playlist_18820821 {

  private static int countPlaylists = 0;
  private int playlistID;// a unique numeric identifier for the playlist
  private String name;// a name for the playlist
  private int length;// the number of movies in the playlist
  private StringBuilder movies;// a list of zero or more Movie IDs which make up this playlist


  public Playlist_18820821(int playlistID, String name, int length, StringBuilder movies) {
    this.playlistID = playlistID;
    this.name = name;
    this.length = length;
    this.movies = movies;

  }
  static Scanner kb = new Scanner(System.in);
  static Playlist_18820821[] arrayPlaylists = null;

  /**
   * @return the playlistID
   */
  public int getPlaylistID() {
    return playlistID;
  }

  /**
   * @param playlistID the playlistID to set
   */
  public void setPlaylistID(int playlistID) {
    this.playlistID = playlistID;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the length
   */
  public int getLength() {
    return length;
  }

  /**
   * @param length the length to set
   */
  public void setLength(int length) {
    this.length = length;
  }

  /**
   * @return the movies
   */
  public StringBuilder getMovies() {
    return movies;
  }

  /**
   * @param movies the movies to set
   */
  public void setMovies(StringBuilder movies) {
    this.movies = movies;
  }
  
  /**
   * @param inPlaylistsFile
   * @param fileName
   * @return arrayPlaylists
   * @throws IOException
   */
  public static Playlist_18820821[] readFile(File inPlaylistsFile, String fileName)
      throws IOException {
    MovieApp.fileExists(inPlaylistsFile, fileName);
    Scanner inputFile = new Scanner(inPlaylistsFile);
    String str;

    int playlistID; // : a unique numeric identifier for the playlist
    String name; // : a name for the playlist
    int length;// : the number of movies in the playlist


    Playlist_18820821[] arrayPlaylists = new Playlist_18820821[50];
    // Read each line, split, then print
    while (inputFile.hasNextLine() && countPlaylists < arrayPlaylists.length) {
      str = inputFile.nextLine();


      // creating string tokenizer
      StringTokenizer tokenizer = new StringTokenizer(str, ",");

      playlistID = Integer.parseInt(tokenizer.nextToken());
      name = tokenizer.nextToken();
      length = Integer.parseInt(tokenizer.nextToken());
      // checking tokens
      StringBuilder movies = new StringBuilder();
      while (tokenizer.hasMoreTokens()) {
        String next = tokenizer.nextToken();
        movies.append(next);
        movies.append(",");
      }
      movies.append("");
      /** remove trailing comma if time permots **/
      // movies.deleteCharAt(movies.lastIndexOf(","));

      // create movie object
      arrayPlaylists[countPlaylists] = new Playlist_18820821(playlistID, name, length, movies);
      countPlaylists++;// increment count
      // System.out.println(" ");
    }
    inputFile.close();

    return arrayPlaylists;
  }


  /**
   * @param array - the array to search
   * @param lookingFor - the search term to find
   * @return foundAt - the position in the array the search term was located
   */
  public static int search(Playlist_18820821[] array, String lookingFor) {
    int i = 0;
    int foundAt = -1;
    boolean found = false;
    while (!found && i < array.length) {
      if (array[i].getName().contains(lookingFor)) {
        found = true;
        foundAt = i;
      }
      i++;
    }
    return foundAt;
  }

  /**
   * @param arr - the array to alter
   */
  public static void addMovie(Playlist_18820821[] arr) {
    String lookingFor;
    String addToPlaylist;
    int foundAt;
    StringBuilder playlist;
    int tempLength;
    System.out.println("Choose a playlist to add movie to: ");
    lookingFor = kb.nextLine();
    foundAt = search(arr, lookingFor);
    System.out.println("Choose a movie to add to playlist: ");
    addToPlaylist = kb.next();
    playlist = new StringBuilder(search(arr, lookingFor));
    playlist.append(addToPlaylist);
    arr[foundAt].setMovies(playlist);
    tempLength = arr[foundAt].getLength();
    arr[foundAt].setLength(tempLength+1);
  }
  
  /**
   * prints formatted array to console
   * @param arrayPlaylists
   */
  public static void print(Playlist_18820821[] arrayPlaylists) {
    // TODO Auto-generated method stub
    System.out.println("Calling printPlaylists");
    for (int i = 0; i < arrayPlaylists.length && arrayPlaylists[i] != null; i++) {
      // print one object at a time

      System.out.printf("%s, %s, %s, %s \n", arrayPlaylists[i].getPlaylistID(),
          arrayPlaylists[i].getName(), arrayPlaylists[i].getLength(),
          arrayPlaylists[i].getMovies());
    }
  }
  
  public static void newPlaylist(){
      // creating string tokenizer
      

      int playlistID = arrayPlaylists.length+1;
      System.out.println("Enter new playlist name");
      String name = kb.nextLine();
      int length = 0;
      System.out.println("Enter movie IDs to add to playlist, seperated by commas");
      String newMovies = kb.nextLine();
      StringTokenizer tokenizer = new StringTokenizer(newMovies, ",");
      
      StringBuilder movies = new StringBuilder();
      while (tokenizer.hasMoreTokens()) {
        String next = tokenizer.nextToken();
        movies.append(next);
        movies.append(",");
        length++;
      }
      movies.append("");
    
      arrayPlaylists[countPlaylists+1] = new Playlist_18820821(playlistID, name, length, movies); 
      System.out.println(arrayPlaylists[countPlaylists+1]);
      
      countPlaylists++;
      
  }
  static void save() throws FileNotFoundException{

    PrintWriter outPlaylistFile = new PrintWriter("playlists.txt");
    
    for (int i = 0; i < arrayPlaylists.length && arrayPlaylists[i] != null; i++) {
      outPlaylistFile.printf("%i, %s, %i, %s \n", arrayPlaylists[i].getPlaylistID(),
         arrayPlaylists[i].getName(),arrayPlaylists[i].getLength(), arrayPlaylists[i].getMovies());
    }
    
    
    //close files

    outPlaylistFile.close();
  }
  
}
