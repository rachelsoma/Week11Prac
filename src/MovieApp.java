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

    int returnMenu; // selected menu item
    int returnMovieMenu; // selected movie menu item
    int returnPlaylistMenu; // selected playlist menu item
    int returnSortMenu; // selected sort menu item
    int returnGenre; // selected genre
    String lookingFor; //search term
    int foundAt; // location in array of search result

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

    // instantiate all menus
    String[] mainMenuArray = {"Movies", "Playlists", "Save", "Exit Program"};
    String[] movieMenuArray =
        {"Display movies", "Sort Movies", "Rate Movie", "Change Movie Genre", "Exit sub-menu"};
    String[] sortMenuArray = {"Sort by Name", "Sort by Genre", "Exit sub-menu"};
    String[] genreArray = {"Action", "Adventure", "Comedy", "Fantasy", "Family", "Romance",
        "Horror", "Drama", "Sci-fi", "Thriller"};
    String[] playlistMenuArray =
        {"Display Playlists", "Create Playlists", "Add movie to playlist", "Exit submenu"};

    returnMenu = displayMenu(mainMenuArray);
    switch (returnMenu) {
      case 1: // Movie menu
        returnMovieMenu = displayMenu(movieMenuArray);
        switch (returnMovieMenu) {
          case 1:
            System.out.println("****Display Movies****");
            printMovies(arrayMovies);
            returnMovieMenu = displayMenu(movieMenuArray);
          case 2: // go to sort menu
            System.out.println("****Sort Movies****");
            returnSortMenu = displayMenu(sortMenuArray);
            switch (returnSortMenu) {
              case 1: // sort by name
                sortName(arrayMovies);
                returnSortMenu = displayMenu(sortMenuArray);
              case 2:// sort by genre
                sortGenre(arrayMovies);
                returnSortMenu = displayMenu(sortMenuArray);
              case 3: // exit sub-menu
                displayMenu(movieMenuArray);
                returnMovieMenu = displayMenu(movieMenuArray);
            }
          case 3: // go to rate movie function
            System.out.println("****Rate Movie****");

            
          case 4: // go to change movie genre function
            System.out.println("****Change movie genre****");
            // get user input for movie name and search
            System.out.println("Enter a title to search for: ");
            lookingFor = kb.nextLine();
            
            
            foundAt = searchArray(arrayMovies, lookingFor);
            System.out.println(arrayMovies[foundAt].getMovieTitle() + " " + arrayMovies[foundAt].getGenre());
            // choose genre

            returnGenre = displayMenu(genreArray);
            arrayMovies[foundAt].setGenre(genreArray[returnGenre-1]);
            System.out.println(arrayMovies[foundAt].getMovieTitle() + " " + arrayMovies[foundAt].getGenre());
            
            
            returnMovieMenu = displayMenu(movieMenuArray);

          case 5:

            returnMenu = displayMenu(mainMenuArray);
        }
      case 2: // playlist menu


        returnPlaylistMenu = displayMenu(playlistMenuArray);
        // displayMenu(playlistMenuArray);
        switch (returnPlaylistMenu) {
          case 1: // display playlists

            printPlaylists(arrayPlaylists);

          case 2: // create playlists


          case 3: // add movie to playlist

          case 4: // exit sub-ment
            displayMenu(mainMenuArray);
            returnMenu = displayMenu(mainMenuArray);

        }
      case 3:
        System.out.println("Saving...");

        break;
      case 4:
        System.out.println("Exiting program");
        break;
      default:
        break;
    }

    // System.out.println("Total: " + countMovies); // print total movies


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

  public static int searchArray(Movie[] array, String lookingFor) {
    int i = 0;
    int foundAt = -1;
    boolean found = false;
    while (!found && i < array.length) {
      if (array[i].getMovieTitle().contains(lookingFor)) {
        found = true;
        foundAt = i;
      }
      i++;
    }
    return foundAt;
  }

}
