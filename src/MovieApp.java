/**
 * Student ID: 18820821 Name: Rachel Hardie Campus: Kingswood Tutor Name: Jordan Collier Class Day:
 * Thursday Class Time: 0900
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;


public class MovieApp {
  static Scanner kb = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    System.out.println("Running");
    /** Declare Vaiables */

    int returnMenu;
    int returnMovieMenu;
    int returnPlaylistMenu;
    int returnSortMenu;
    Movie[] arrayMovies = null;
    Playlist[] arrayPlaylists = null;
    String fileNameMovies = "movieLibrary.txt";
    String fileNamePlaylists = "playlists.txt";
    int countMovies = 0;

    Scanner kb = new Scanner(System.in);
    File inMovies = new File(fileNameMovies);
    File inPlaylists = new File(fileNamePlaylists);
    arrayMovies = readMoviesFile(inMovies, fileNameMovies);
    arrayPlaylists = readPlaylistsFile(inPlaylists, fileNamePlaylists);


    String[] mainMenuArray = {"Movies", "Playlists", "Save", "Exit Program"};
    returnMenu = displayMenu(mainMenuArray);
    System.out.println("You selected: " + returnMenu);

    switch (returnMenu) {
      case 1: // Movie menu
        String[] movieMenuArray = {"Display movies", "Sort Movies", "Rate Movie",
            "Change Movie Genre", "Return to main menu"};

        returnMovieMenu = displayMenu(movieMenuArray);

        if (returnMovieMenu == 1) {

          System.out.println("****Display Movies****");
          printMovies(arrayMovies);

          returnMovieMenu = displayMenu(movieMenuArray);
        }
        if (returnMovieMenu == 2) {         
          System.out.println("****Sort Movies****");
          
          
          String[] sortMenuArray = {"Sort by Name", "Sort by Genre","Exit menu"};
          returnSortMenu = displayMenu(sortMenuArray);
          if (returnSortMenu == 1){
            sortName(arrayMovies);
          } else if (returnSortMenu ==  2){
            sortGenre(arrayMovies);
          }
          
          
          
          returnMovieMenu = displayMenu(movieMenuArray);
        }
        if (returnMovieMenu == 3) {
          System.out.println("****Rate Movie****");

          returnMovieMenu = displayMenu(movieMenuArray);
        }
        if (returnMovieMenu == 4) {
          System.out.println("****Change movie genre****");

          returnMovieMenu = displayMenu(movieMenuArray);
        }
        if (returnMovieMenu == 5) {

          returnMenu = displayMenu(mainMenuArray);
        }
        break;

      case 2: // playlist menu
        String[] playlistMenuArray =
            {"Display Playlists", "Create Playlists", "Add movie to playlist", "Exit submenu"};
        returnPlaylistMenu = displayMenu(playlistMenuArray);
        // displayMenu(playlistMenuArray);

        if (returnPlaylistMenu == 1) {

          printPlaylists(arrayPlaylists);
        }
        if (returnPlaylistMenu == 2) {
        }

        if (returnPlaylistMenu == 3) {
        }
        if (returnPlaylistMenu == 4) {
          displayMenu(mainMenuArray);
        }
        break;
      case 3:
        System.out.println("Saving...");

        break;
      case 4:
        System.out.println("Exiting program");
        break;
      default:
        break;
    }

    //System.out.println("Total: " + countMovies); // print total movies


    kb.close();
    System.out.println("Goodbye!");
  }

  public static void menu() {


  }

  public static int displayMenu(String[] menuArray) {

    final int min = 1;
    final int max = menuArray.length;
    // int input;

    System.out.println("Enter your menu choice");
    for (int i = 0; i < menuArray.length; i++) {
      System.out.println((i + 1) + ". " + menuArray[i]);
    }
    return getMenuChoice(min, max);

  }

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

  static void fileExists(File inFile, String fileName) throws IOException {

    while (!inFile.exists()) { // validates that file exists

      System.out.println("File not found"); // alerts user to missing file
      System.out.println("Please enter a new file location:"); // prompts for new input
      fileName = kb.next();
      inFile = new File(fileName); // replace filename with user input
      kb.close();
    }
  }

  public static Movie[] readMoviesFile(File inFile, String fileName) throws IOException {
    fileExists(inFile, fileName);
    Scanner inputFile = new Scanner(inFile);
    int countMovies = 0;
    String str;
    String[] tokens;
    // int[] array;

    Movie[] arrayMovies = new Movie[50];
    // Read each line, split, then print
    while (inputFile.hasNextLine() && countMovies < arrayMovies.length) {
      str = inputFile.nextLine();
      tokens = str.split(",");

      // parsing int/double inspiration from
      // http://stackoverflow.com/questions/8348591/splitting-string-and-put-it-on-int-array
      int inID = Integer.parseInt(tokens[0]);
      String inTitle = tokens[1];
      String inDirector = tokens[2];
      String inWriter = tokens[3];
      Double inDuration = Double.parseDouble(tokens[4]);
      String inGenre = tokens[5];
      String inClassification = tokens[6];
      String inDate = tokens[7];
      String inRating;
      if (tokens.length > 8) { /*
                                * greater than 8 because array starts from 0 and max tokens should
                                * be 9
                                */
        inRating = tokens[8];
      } else {
        inRating = "";
      }
      // create movie object
      arrayMovies[countMovies] = new Movie(inID, inTitle, inDirector, inWriter, inDuration, inGenre,
          inClassification, inDate, inRating);
      countMovies++;// increment count
      // System.out.println(" ");
    }
    inputFile.close();

    return arrayMovies;
  }

  public static void printMovies(Movie[] arrayMovies) {
    System.out.println("Calling printMovies");
    for (int i = 0; i < arrayMovies.length && arrayMovies[i] != null; i++) {
      System.out.printf("%s, %s, %s, %s, %s \n", arrayMovies[i].getMovieTitle(),
          arrayMovies[i].getDuration(), arrayMovies[i].getGenre(),
          arrayMovies[i].getClassification(), arrayMovies[i].getRating());

    }
  }

  public static Playlist[] readPlaylistsFile(File inPlaylistsFile, String fileName)
      throws IOException {
    fileExists(inPlaylistsFile, fileName);
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

  private static void printPlaylists(Playlist[] arrayPlaylists) {
    // TODO Auto-generated method stub
    System.out.println("Calling printPlaylists");
    for (int i = 0; i < arrayPlaylists.length && arrayPlaylists[i] != null; i++) {
      // print one object at a time

      System.out.printf("%s, %s, %s, %s \n", arrayPlaylists[i].getPlaylistID(),
          arrayPlaylists[i].getName(), arrayPlaylists[i].getLength(),
          arrayPlaylists[i].getMovies());
    }
  }

  public static void sortName(Movie[] arr) {
    int startAt; // index of starting position
    int j; // loop control
    int minIndex; // index of smallest element
    Movie tempObj; // temp object for swapping
    for (startAt = 0; startAt < arr.length - 1; startAt++) {
      minIndex = startAt; // assume smallest is at the start of arr
      tempObj = arr[startAt];
      if (arr[startAt] != null) {
        // look through the rest of the array for value smaller than starting value

        for (j = startAt + 1; j < arr.length && arr[j] != null; j++) {
          if (arr[j].getMovieTitle().compareTo(tempObj.getMovieTitle()) < 0) { // compare current
                                                                               // element with
                                                                               // tempObj
            tempObj = arr[j]; // set temp to be the new smallest value
            minIndex = j; // record where that smallest value is located
          }
        }
        arr[minIndex] = arr[startAt]; // perform the swap
        arr[startAt] = tempObj; // complete the swap
      }
    }
    printMovies(arr);
  }
  
  public static void sortGenre(Movie[] arr) {
    int startAt; // index of starting position
    int j; // loop control
    int minIndex; // index of smallest element
    Movie tempObj; // temp object for swapping
    for (startAt = 0; startAt < arr.length - 1; startAt++) {
      minIndex = startAt; // assume smallest is at the start of arr
      tempObj = arr[startAt];
      if (arr[startAt] != null) {
        // look through the rest of the array for value smaller than starting value

        for (j = startAt + 1; j < arr.length && arr[j] != null; j++) {
          if (arr[j].getGenre().compareTo(tempObj.getGenre()) < 0) { // compare current
                                                                               // element with
                                                                               // tempObj
            tempObj = arr[j]; // set temp to be the new smallest value
            minIndex = j; // record where that smallest value is located
          }
        }
        arr[minIndex] = arr[startAt]; // perform the swap
        arr[startAt] = tempObj; // complete the swap
      }
    }
    printMovies(arr);
  }
}
