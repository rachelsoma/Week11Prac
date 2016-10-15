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
  private String movies;// a list of zero or more Movie IDs which make up this playlist


  public Playlist(int playlistID, String name, int length, String movies) {
    this.playlistID = playlistID;
    this.name = name;
    this.length = length;
    this.movies = movies;

  }

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
  public String getMovies() {
    return movies;
  }

  /**
   * @param movies the movies to set
   */
  public void setMovies(String movies) {
    this.movies = movies;
  }
}
