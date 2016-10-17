import java.util.Scanner;

/**
 * Student ID: 18820821 Name: Rachel Hardie Campus: Kingswood Tutor Name: Jordan Collier Class Day:
 * Thursday Class Time: 0900
 */

public class Menu {

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
   * 
   */
  public static void showMenu() {
    // Method to display and run menus
    returnMenu = Menu.displayMenu(mainMenuArray);
    switch (returnMenu) {
      case 1: // call Movie menu
        movieMenu();
      case 2: // playlist menu
        playlistMenu();
      case 3: // save
        System.out.println("Saving...");
        break;
      case 4: // Exit
        System.out.println("Exiting program");
        break;
    }
  }

  public static void movieMenu() {
    returnMovieMenu = Menu.displayMenu(movieMenuArray);
    // Object foundAt;
    // String lookingFor;
    switch (returnMovieMenu) {
      case 1:
        Movie.print(Movie.arrayMovies);
        returnMovieMenu = Menu.displayMenu(movieMenuArray);
      case 2: // go to sort menu
        sortMenu();
        returnMovieMenu = Menu.displayMenu(movieMenuArray);
      case 3: // go to rate movie function
        Movie.rate();
        returnMovieMenu = Menu.displayMenu(movieMenuArray);
      case 4: // go to change movie genre function
        Movie.changeGenre();
        returnMovieMenu = Menu.displayMenu(movieMenuArray);
      case 5:
        returnMenu = Menu.displayMenu(mainMenuArray);
    }
  }

  public static void playlistMenu() {
    returnPlaylistMenu = Menu.displayMenu(playlistMenuArray);
    // displayMenu(playlistMenuArray);
    switch (returnPlaylistMenu) {
      case 1: // display playlists
        Playlist.print(Playlist.arrayPlaylists);

      case 2: // create playlists
        Playlist.newPlaylist();
        Playlist.print(Playlist.arrayPlaylists);
      case 3: // add movie to playlist
        // select playlist
        Playlist.addMovie(Playlist.arrayPlaylists);

        Playlist.print(Playlist.arrayPlaylists);

      case 4: // exit sub-ment
        Menu.displayMenu(mainMenuArray);
        returnMenu = Menu.displayMenu(mainMenuArray);
    }
  }

  public static void sortMenu() {
    System.out.println("****Sort Movies****");
    returnSortMenu = Menu.displayMenu(sortMenuArray);
    switch (returnSortMenu) {
      case 1: // sort by name
        Movie.sortName(Movie.arrayMovies);
        returnSortMenu = Menu.displayMenu(sortMenuArray);
      case 2:// sort by genre
        Movie.sortGenre(Movie.arrayMovies);
        returnSortMenu = Menu.displayMenu(sortMenuArray);
      case 3: // exit sub-menu
        Menu.displayMenu(movieMenuArray);
        returnMovieMenu = Menu.displayMenu(movieMenuArray);
    }
  }
}
