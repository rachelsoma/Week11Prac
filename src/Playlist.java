import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Student ID: 18820821 Name: Rachel Hardie Campus: Kingswood Tutor Name: Jordan Collier Class Day:
 * Thursday Class Time: 0900
 */

/**
 *
 */
public class Playlist {

  private int playlistID;// a unique numeric identifier for the playlist
  private String name;// a name for the playlist
  private int length;// the number of movies in the playlist
  private StringBuilder movies;// a list of zero or more Movie IDs which make up this playlist


  public Playlist(int playlistID, String name, int length, StringBuilder movies) {
    this.playlistID = playlistID;
    this.name = name;
    this.length = length;
    this.movies = movies;

  }
  static Scanner kb = new Scanner(System.in);
  static Playlist[] arrayPlaylists = null;

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
  
  public static Playlist[] readFile(File inPlaylistsFile, String fileName)
      throws IOException {
    MovieApp.fileExists(inPlaylistsFile, fileName);
    Scanner inputFile = new Scanner(inPlaylistsFile);
    int countPlaylists = 0;
    String str;

    int playlistID; // : a unique numeric identifier for the playlist
    String name; // : a name for the playlist
    int length;// : the number of movies in the playlist


    Playlist[] arrayPlaylists = new Playlist[50];
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
      arrayPlaylists[countPlaylists] = new Playlist(playlistID, name, length, movies);
      countPlaylists++;// increment count
      // System.out.println(" ");
    }
    inputFile.close();

    return arrayPlaylists;
  }


  public static int search(Playlist[] array, String lookingFor) {
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

  public static void addMovie(Playlist[] arr) {
    System.out.println("Choose a playlist to add movie to: ");
    String lookingFor = kb.nextLine();
    int foundAt = search(arr, lookingFor);
    System.out.println("Choose a movie to add to playlist: ");
    String addToPlaylist = kb.next();
    StringBuilder playlist = new StringBuilder(search(arr, lookingFor));
    playlist.append(addToPlaylist);
    arr[foundAt].setMovies(playlist);
  }
  
  public static void print(Playlist[] arrayPlaylists) {
    // TODO Auto-generated method stub
    System.out.println("Calling printPlaylists");
    for (int i = 0; i < arrayPlaylists.length && arrayPlaylists[i] != null; i++) {
      // print one object at a time

      System.out.printf("%s, %s, %s, %s \n", arrayPlaylists[i].getPlaylistID(),
          arrayPlaylists[i].getName(), arrayPlaylists[i].getLength(),
          arrayPlaylists[i].getMovies());
    }
  }
  
}
