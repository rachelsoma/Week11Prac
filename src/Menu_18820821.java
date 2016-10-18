import java.io.IOException;
import java.util.Scanner;

/**
 * Student ID: 18820821 Name: Rachel Hardie Campus: Kingswood Tutor Name: Jordan Collier Class Day:
 * Thursday Class Time: 0900
 */

public class Menu_18820821 {

  // CD - I would avoid making items static
  static Scanner kb = new Scanner(System.in);
  public static int returnMenu; // selected menu item
  public static int returnMovieMenu; // selected movie menu item
  public static int returnPlaylistMenu; // selected playlist menu item
  public static int returnSortMenu; // selected sort menu item

  // instantiate all menus
  public static String[] mainMenuArray = {"Movies", "Playlists", "Save", "Exit Program"}; // main
                                                                                          // menu
                                                                                          // items
  public static String[] movieMenuArray =
      {"Display movies", "Sort Movies", "Rate Movie", "Change Movie Genre", "Exit sub-menu"}; // movie
                                                                                              // sub-menu
                                                                                              // items
  public static String[] sortMenuArray = {"Sort by Name", "Sort by Genre", "Exit sub-menu"}; // sort
                                                                                             // sub-sub-menu
  public static String[] genreArray = {"Action", "Adventure", "Comedy", "Fantasy", "Family",
      "Romance", "Horror", "Drama", "Sci-fi", "Thriller"}; // genre sub-sub-menu
  public static String[] playlistMenuArray =
      {"Display Playlists", "Create Playlists", "Add movie to playlist", "Exit submenu"}; // playlist
                                                                                          // menu

  /**
   * Method to display formatted menu
   * 
   * @param menuArray - array generated from
   * @return min menu value and max menu value
   */
  public static int displayMenu(String[] menuArray) {
    //
    final int min = 1;
    final int max = menuArray.length;
    // int input;
    System.out.println("Enter your menu choice");
    for (int i = 0; i < menuArray.length; i++) {
      System.out.println((i + 1) + ". " + menuArray[i]);
    }
    return getMenuChoice(min, max);
  }

  /**
   * tests the user input to make sure it's within the range of the menu
   * 
   * @param min - minimum value in menu, the first option
   * @param max - the maximum value in menu, the last option on the menu
   * @return input - the users input
   */
  public static int getMenuChoice(int min, int max) {
    int input;
    do {
      input = kb.nextInt();
      if (input < min || input > max) {
        System.out.println("menu choice out of range");
      }
    } while (input < min || input > max);
    return input;
  }

  /**
   * @throws IOException 
   * 
   */
  public static void showMenu() throws IOException {
    // Method to display and run menus
    returnMenu = Menu_18820821.displayMenu(mainMenuArray);
    switch (returnMenu) {
      case 1: // call Movie menu
        movieMenu();
        break;
      case 2: // playlist menu
        playlistMenu();
        break;
      case 3: // save
        System.out.println("Saving...");
        Movie_18820821.save();
        Playlist_18820821.save();
        
        returnMenu = Menu_18820821.displayMenu(mainMenuArray);
        break;
      case 4: // Exit
        System.out.println("Exiting program");
        break;
    }
  }

  public static void movieMenu() {
    returnMovieMenu = Menu_18820821.displayMenu(movieMenuArray);
    // Object foundAt;
    // String lookingFor;
    switch (returnMovieMenu) {
      case 1:
        Movie.print(Movie.arrayMovies);
        returnMovieMenu = Menu_18820821.displayMenu(movieMenuArray);
        break;
      case 2: // go to sort menu
        sortMenu();
        returnMovieMenu = Menu_18820821.displayMenu(movieMenuArray);
        break;
      case 3: // go to rate movie function
        Movie.rate();
        returnMovieMenu = Menu_18820821.displayMenu(movieMenuArray);
        break;
      case 4: // go to change movie genre function
        Movie.changeGenre();
        returnMovieMenu = Menu_18820821.displayMenu(movieMenuArray);
        break;
      case 5:
        returnMenu = Menu_18820821.displayMenu(mainMenuArray);
        break;
    }
  }

  public static void playlistMenu() {
    returnPlaylistMenu = Menu_18820821.displayMenu(playlistMenuArray);
    // displayMenu(playlistMenuArray);
    switch (returnPlaylistMenu) {
      case 1: // display playlists
        Playlist.print(Playlist.arrayPlaylists);
        break;
      case 2: // create playlists
        Playlist.newPlaylist();
        Playlist.print(Playlist.arrayPlaylists);
        break;
      case 3: // add movie to playlist
        // select playlist
        Playlist.addMovie(Playlist.arrayPlaylists);

        Playlist.print(Playlist.arrayPlaylists);
        break;
      case 4: // exit sub-ment
        Menu_18820821.displayMenu(mainMenuArray);
        returnMenu = Menu_18820821.displayMenu(mainMenuArray);
        break;
    }
  }

  public static void sortMenu() {
    System.out.println("****Sort Movies****");
    returnSortMenu = Menu_18820821.displayMenu(sortMenuArray);
    switch (returnSortMenu) {
      case 1: // sort by name
        Movie.sortName(Movie.arrayMovies);
        returnSortMenu = Menu_18820821.displayMenu(sortMenuArray);
        break;
      case 2:// sort by genre
        Movie.sortGenre(Movie.arrayMovies);
        returnSortMenu = Menu_18820821.displayMenu(sortMenuArray);
        break;
      case 3: // exit sub-menu
        Menu_18820821.displayMenu(movieMenuArray);
        returnMovieMenu = Menu_18820821.displayMenu(movieMenuArray);
        break;
    }
  }
}
